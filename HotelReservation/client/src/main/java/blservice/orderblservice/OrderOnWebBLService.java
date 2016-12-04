package blservice.orderblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.OrderVO;

/**
 * 网站营销人员查看申诉列表并处理，查看一场订单列表及详情
 * 
 * @author txin
 *
 */
public interface OrderOnWebBLService {
	
	/**
	 * 网站营销人员查看申诉列表
	 *
	 * @param void
	 * @return 申诉列表
	 */
	public ArrayList<OrderVO> complaintListScan();
	
	/**
	 * 网站营销人员处理申诉
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
	 */
	public ResultMsg complaintHandle(OrderVO orderVO,double rate);
	
	/**
	 * 网站营销人员查看异常订单列表
	 *
	 * @param void
	 * @return 异常订单列表
	 */
	public ArrayList<OrderVO> abnormalOrderScan();
	
	/**
	 * 网站营销人员查看异常订单详情
	 *
	 * @param orderVO 订单VO
	 * @return 个人订单详情
	 */
	public OrderVO abnormalOrderDetail(String ID);
	
}
