package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.orderdataservice.OrderOnHotelDataService;
import po.OrderOnHotelPO;
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
	public OrderOnHotelVO hotelOrderDetail(String ID) throws RemoteException {
		ArrayList<OrderOnHotelPO> hotelPOs;
		hotelPOs = (ArrayList<OrderOnHotelPO>) hotelDataService.getTotalHotelOrderList();
		for(OrderOnHotelPO hotelPO : hotelPOs) {
			if(hotelPO.getOrderID().equals(ID))
				return (OrderOnHotelVO)VOPOchange.POtoVO(hotelPO);
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
		ResultMsg resultMsg;
		if(hotelPO.getOrderState() == OrderState.UNEXECUTED) {
			hotelPO.setOrderState(OrderState.EXECUTED);
			resultMsg = hotelDataService.update(hotelPO);
			return resultMsg;
		}else{
			return ResultMsg.FAIL;
		}
	}

}
