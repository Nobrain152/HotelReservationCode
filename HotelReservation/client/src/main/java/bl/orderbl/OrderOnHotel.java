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
	 * 酒店工作人员查看酒店订单列表
	 *
	 * @param ID
	 * @return 酒店订单列表
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
	 * 酒店工作人员查看酒店订单详情
	 *
	 * @param String 订单ID
	 * @return 酒店订单详情
	 * @throws RemoteException 
	 */
	public OrderVO hotelOrderDetail(String ID) throws RemoteException {
		OrderPO hotelPO = hotelDataService.findByOrderID(ID);
		return (OrderVO)VOPOchange.POtoVO(hotelPO);
	}
	
	/**
	 * 酒店工作人员修改订单状态
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
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
