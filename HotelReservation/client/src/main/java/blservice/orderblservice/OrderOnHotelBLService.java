package blservice.orderblservice;

import java.util.ArrayList;

import po.OrderPO;
import util.ResultMsg;
import vo.OrderVO;

/**
 * 酒店工作人员查看酒店订单列表及详情，修改订单状态
 * 
 * @author txin
 *
 */
public interface OrderOnHotelBLService {
	
	/**
	 * 酒店工作人员查看酒店订单列表
	 *
	 * @param ID
	 * @return 酒店订单列表
	 */
	public ArrayList<OrderVO> hotelOrderScan(String ID);
	
	/**
	 * 酒店工作人员查看酒店订单详情
	 *
	 * @param OrderVO 订单VO
	 * @return 酒店订单详情
	 */
	public OrderVO hotelOrderDetail(String ID);
	
	/**
	 * 酒店工作人员修改订单状态
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
	 */
	public ResultMsg hotelOrderModify(OrderVO orderVO);

	public void update(OrderPO poTmp);
	
}
