package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import util.OrderState;
import util.ResultMsg;
import vo.OrderVO;

public class OrderOnHotel {
	
	private OrderDataService hotelDataService;
	
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
		OrderPO hotelPO = hotelDataService.findByOrderID(orderVO.getOrderID());
		ResultMsg resultMsg = ResultMsg.FAIL;
		if(hotelPO.getOrderState() == OrderState.UNEXECUTED) {
			hotelPO.setOrderState(OrderState.EXECUTED);
			resultMsg = hotelDataService.update(hotelPO);
		}
		return resultMsg;
	}

}
