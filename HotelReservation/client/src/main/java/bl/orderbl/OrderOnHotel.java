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
	 * 酒店工作人员查看酒店订单列表
	 *
	 * @param void
	 * @return 酒店订单列表
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
	 * 酒店工作人员查看酒店订单详情
	 *
	 * @param OrderOnHotelVO 订单VO
	 * @return 酒店订单详情
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
	 * 酒店工作人员修改订单状态
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
	 * @throws RemoteException 
	 */
	public ResultMsg hotelOrderModify(OrderOnHotelVO orderVO) throws RemoteException {
		OrderOnHotelPO hotelPO = hotelDataService.findByID(orderVO.getOrderID());
		if(hotelPO.getOrderState() == OrderState.UNEXECUTED) {
			hotelPO.setOrderState(OrderState.EXECUTED);
			return new ResultMsg(true, "执行成功！");
		}else{
			return new ResultMsg(false, "订单状态不可修改！");
		}
	}

}
