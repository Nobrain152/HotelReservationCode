package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.creditbl.CreditController;
import bl.hotelbl.RoomAddController;
import dataservice.orderdataservice.OrderDataService;
import po.CreditPO;
import po.CustomerInfoPO;
import po.OrderPO;
import po.RoomInfoPO;
import util.Action;
import util.OrderState;
import util.ResultMsg;
import util.RoomState;
import util.Today;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class OrderOnHotel {
	
	private OrderDataService hotelDataService;
	private RoomAddController room;
	private CreditController credit;
	
	public OrderOnHotel(OrderDataService hotelDataService) {
		this.hotelDataService = hotelDataService;
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
		ResultMsg resultMsg = ResultMsg.FAIL;
		credit = (CreditController)BusinessLogicDataFactory.getFactory().getCreditBLService();
		ArrayList<CreditPO> creditPOs = credit.getListByUserID(orderVO.getInitiator().getUserID());
		CreditPO creditPO = creditPOs.get(creditPOs.size()-1);
		OrderPO orderPO = hotelDataService.findByOrderID(orderVO.getOrderID());
		ArrayList<String> roomIDs = orderVO.getRoomIDs();

		room = (RoomAddController)BusinessLogicDataFactory.getFactory().getRoomAddBLService();
		for(int i = 0; i < roomIDs.size(); i++){
			RoomInfoPO roomInfoPO = room.findByRoomID(roomIDs.get(0));
			if(orderPO.getOrderState() == OrderState.UNEXECUTED
					&& roomInfoPO.getState() == RoomState.USABLE) {
				CustomerInfoPO customerInfoPO = orderPO.getInitiator();
				CreditController controller = new CreditController();
				
				CustomerInfoVO customerInfoVO = (CustomerInfoVO)VOPOchange.POtoVO(customerInfoPO);
				controller.addCredit(customerInfoVO, (int)orderVO.getPrice());
				
				roomInfoPO.setRoomState(RoomState.UNUSABLE);
				orderPO.setOrderState(OrderState.EXECUTED);
				room.update(roomInfoPO);
				hotelDataService.update(orderPO);
				
				creditPO.setAction(Action.Executed);
				creditPO.setCreditResult(creditPO.getCreditResult() + (int)orderVO.getPrice());
				creditPO.setCreditChange("+" + (int)orderVO.getPrice());
				creditPO.setTime(new Today().getToday());
				credit.insert(creditPO);
				System.out.println(resultMsg);
				resultMsg = ResultMsg.SUCCESS;
			} else if(orderPO.getOrderState() == OrderState.EXECUTED
					&& roomInfoPO.getState() == RoomState.UNUSABLE) {
				
				roomInfoPO.setRoomState(RoomState.USABLE);
				room.update(roomInfoPO);
				resultMsg = ResultMsg.SUCCESS;
				
			} else if(orderPO.getOrderState() == OrderState.ABNORMAL) {
				
				CustomerInfoPO customerInfoPO = orderPO.getInitiator();
				CreditController controller = new CreditController();
				
				CustomerInfoVO customerInfoVO = (CustomerInfoVO)VOPOchange.POtoVO(customerInfoPO);
				controller.addCredit(customerInfoVO, (int)orderVO.getPrice());
				
				roomInfoPO.setRoomState(RoomState.UNUSABLE);
				orderPO.setOrderState(OrderState.EXECUTED);
				room.update(roomInfoPO);
				hotelDataService.update(orderPO);
				
				creditPO.setAction(Action.Executed);
				creditPO.setCreditResult(creditPO.getCreditResult() + (int)orderVO.getPrice());
				creditPO.setCreditChange("+" + (int)orderVO.getPrice());
				creditPO.setTime(new Today().getToday());
				credit.insert(creditPO);
				
				resultMsg = ResultMsg.SUCCESS;
			}
		}
		return resultMsg;
	}

}
