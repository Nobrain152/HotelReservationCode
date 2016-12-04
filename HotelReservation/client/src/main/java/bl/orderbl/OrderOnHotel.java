package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import bl.creditbl.CreditController;
import dataservice.hoteldataservice.RoomInfoDataService;
import dataservice.orderdataservice.OrderDataService;
import po.CustomerInfoPO;
import po.OrderPO;
import po.RoomInfoPO;
import util.OrderState;
import util.ResultMsg;
import util.RoomState;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class OrderOnHotel {
	
	private OrderDataService hotelDataService;
	private RoomInfoDataService roomInfoDataService;
	
	public OrderOnHotel(OrderDataService hotelDataService,RoomInfoDataService roomInfoDataService) {
		this.hotelDataService = hotelDataService;
		this.roomInfoDataService = roomInfoDataService;
	}
	
	/**
	 * �Ƶ깤����Ա�鿴�Ƶ궩���б�
	 *
	 * @param ID
	 * @return �Ƶ궩���б�
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> hotelOrderScan(String ID) throws RemoteException {
		
		ArrayList<OrderVO> hotelVOs = new ArrayList<OrderVO>();
		ArrayList<OrderPO> hotelPOs;
		
		hotelPOs = hotelDataService.findByHotelID(ID);
		if(hotelPOs == null || hotelPOs.isEmpty()) {
			return null;
		}
		
		hotelVOs = new ArrayList<OrderVO>(hotelPOs.size());
		for(OrderPO hotelPO : hotelPOs) {
			hotelVOs.add((OrderVO)VOPOchange.POtoVO(hotelPO));
		}
		
		return hotelVOs;
	}
	
	/**
	 * �Ƶ깤����Ա�鿴�Ƶ궩������
	 *
	 * @param String ����ID
	 * @return �Ƶ궩������
	 * @throws RemoteException 
	 */
	public OrderVO hotelOrderDetail(String ID) throws RemoteException {
		OrderPO hotelPO = hotelDataService.findByOrderID(ID);
		return (OrderVO)VOPOchange.POtoVO(hotelPO);
	}
	
	/**
	 * �Ƶ깤����Ա�޸Ķ���״̬
	 *
	 * @param orderVO ����VO
	 * @return ϵͳ��ʾ��Ϣ
	 * @throws RemoteException 
	 */
	public ResultMsg hotelOrderModify(OrderVO orderVO) throws RemoteException {
		OrderPO orderPO = hotelDataService.findByOrderID(orderVO.getOrderID());
		ResultMsg resultMsg = ResultMsg.FAIL;
		RoomInfoPO roomInfoPO = roomInfoDataService.findByRoomID(orderVO.getRoomInfoVO().getRoomID());
		if(orderPO.getOrderState() == OrderState.UNEXECUTED
				&& roomInfoPO.getState() == RoomState.USABLE) {
			orderPO.setOrderState(OrderState.EXECUTED);
			CustomerInfoPO customerInfoPO = orderPO.getInitiator();
			CreditController controller = new CreditController();
			controller.addCredit((CustomerInfoVO)VOPOchange.POtoVO(customerInfoPO), (int)orderVO.getPrice());
			roomInfoPO.setRoomState(RoomState.UNUSABLE);
			orderPO.setRoomInfoPO(roomInfoPO);
			resultMsg = hotelDataService.update(orderPO);
		} else if(orderPO.getOrderState() == OrderState.EXECUTED
				&& roomInfoPO.getState() == RoomState.UNUSABLE) {
			roomInfoPO.setRoomState(RoomState.USABLE);
			orderPO.setRoomInfoPO(roomInfoPO);
			resultMsg = hotelDataService.update(orderPO);
		}
		return resultMsg;
	}

}
