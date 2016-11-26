package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.orderdataservice.OrderOnHotelDataService;
import po.OrderOnHotelPO;
import util.OrderOnHotelMsg;
import util.OrderState;
import util.ResultMsg;
import vo.OrderOnHotelVO;

public class OrderOnHotel {
	
	private OrderOnHotelDataService hotelDataService;
	
	/**
	 * �Ƶ깤����Ա�鿴�Ƶ궩���б�
	 *
	 * @param void
	 * @return �Ƶ궩���б�
	 * @throws RemoteException 
	 */
	public ArrayList<OrderOnHotelVO> hotelOrderScan() throws RemoteException {
		
		ArrayList<OrderOnHotelVO> hotelVOs = new ArrayList<>();
		ArrayList<OrderOnHotelPO> hotelPOs;
		
		hotelPOs = hotelDataService.getTotalHotelOrderList();
		if(hotelPOs == null || hotelPOs.isEmpty()) {
			return null;
		}
		
		hotelVOs = new ArrayList<>(hotelPOs.size());
		for(OrderOnHotelPO hotelPO : hotelPOs) {
			hotelVOs.add((OrderOnHotelVO)VOPOchange.POtoVO(hotelPO));
		}
		
		return hotelVOs;
	}
	
	/**
	 * �Ƶ깤����Ա�鿴�Ƶ궩������
	 *
	 * @param OrderOnHotelVO ����VO
	 * @return �Ƶ궩������
	 * @throws RemoteException 
	 */
	public OrderOnHotelMsg hotelOrderDetail(OrderOnHotelVO hotelOrderVO) throws RemoteException {
		ArrayList<OrderOnHotelPO> hotelPOs;
		hotelPOs = (ArrayList<OrderOnHotelPO>) hotelDataService.getTotalHotelOrderList();
		for(OrderOnHotelPO hotelPO : hotelPOs) {
			if(hotelPO.getOrderID().equals(hotelOrderVO.getOrderID()))
				return new OrderOnHotelMsg(hotelPO.getInitiator(),hotelPO.getOrderID(), hotelPO.getOrderState(), hotelPO.getPrice(), 
						hotelPO.getCheckInTime(), hotelPO.getCheckOutTime(), hotelPO.getLatestExecutionTime(), 
						hotelPO.getRoomType(), hotelPO.getRoomNumber(), hotelPO.getPeopleNumber(), hotelPO.getHasChild());
		}
		return null;
	}
	
	/**
	 * �Ƶ깤����Ա�޸Ķ���״̬
	 *
	 * @param orderVO ����VO
	 * @return ϵͳ��ʾ��Ϣ
	 * @throws RemoteException 
	 */
	public ResultMsg hotelOrderModify(OrderOnHotelVO orderVO) throws RemoteException {
		OrderOnHotelPO hotelPO = hotelDataService.findByID(orderVO.getOrderID());
		if(hotelPO.getOrderState() == OrderState.UNEXECUTED) {
			hotelPO.setOrderState(OrderState.EXECUTED);
			return new ResultMsg(true, "ִ�гɹ���");
		}else{
			return new ResultMsg(false, "����״̬�����޸ģ�");
		}
	}

}
