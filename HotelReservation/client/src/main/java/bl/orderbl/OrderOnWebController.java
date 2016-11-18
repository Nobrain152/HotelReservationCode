package bl.orderbl;

import java.util.ArrayList;

import util.OrderOnWebMsg;
import util.OrderState;
import util.ResultMsg;
import vo.OrderOnWebVO;

public class OrderOnWebController {
	
	public static ArrayList<OrderOnWebVO> webList;
	
	public OrderOnWebController() {
		webList = new ArrayList<OrderOnWebVO>();
	}
	/**
	 * 网站营销人员查看申诉列表
	 *
	 * @param void
	 * @return 申诉列表
	 */
	public ArrayList<OrderOnWebVO> complaintListScan() {
		ArrayList<OrderOnWebVO> orderOnWebs = new ArrayList<OrderOnWebVO>();
		for(int i = 0;i < webList.size(); i++){
			if(webList.get(i).getReason() != "")
				orderOnWebs.add(webList.get(i));
		}
		return orderOnWebs;
	}
	
	/**
	 * 网站营销人员处理申诉
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
	 */
	public ResultMsg complaintHandle(OrderOnWebVO order){
		if(order.getReason().equals("火车晚点")){
			order.setOrderState(OrderState.UNEXECUTED);
			order.getInitiator().setCredit(order.getPrice());
			return new ResultMsg(true, "处理成功！");
		}else{
			order.setOrderState(OrderState.CANCELLED);
			return new ResultMsg(false, "不予处理");
		}
	}
	
	/**
	 * 网站营销人员查看异常订单列表
	 *
	 * @param void
	 * @return 异常订单列表
	 */
	public ArrayList<OrderOnWebVO> abnormalOrderScan() {
		ArrayList<OrderOnWebVO> orderOnWebs = new ArrayList<OrderOnWebVO>();
		for(int i = 0;i < webList.size(); i++){
			if(webList.get(i).getOrderState() == OrderState.ABNORMAL)
				orderOnWebs.add(webList.get(i));
		}
		return orderOnWebs;
	}
	
	/**
	 * 网站营销人员查看异常订单详情
	 *
	 * @param orderVO 订单VO
	 * @return 个人订单详情
	 */
	public OrderOnWebMsg abnormalOrderDetail(OrderOnWebVO order){
		return new OrderOnWebMsg(order.getInitiator(),order.getOrderID(),order.getOrderState(),order.getPrice(),order.getReason());
	}
	

}
