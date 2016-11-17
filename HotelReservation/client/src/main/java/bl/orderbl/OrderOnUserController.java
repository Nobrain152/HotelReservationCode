package bl.orderbl;

import java.util.ArrayList;

import util.OrderOnUserMsg;
import util.OrderState;
import util.ResultMsg;
import vo.OrderOnUserVO;

public class OrderOnUserController {
	
	ArrayList<OrderOnUserVO> userList;
	
	public OrderOnUserController() {
		userList = new ArrayList<OrderOnUserVO>();
	}
	/**
	 * 客户查看个人订单信息
	 *
	 * @param void
	 * @return 个人订单列表
	 */
	public ArrayList<OrderOnUserVO> personalOrderScan() {
		return userList;
	}
	
	/**
	 * 客户创建订单
	 *
	 * @param 个人订单
	 * @return void
	 */
	public void createOrder(OrderOnUserVO order) {
		userList.add(order);
	}
	
	/**
	 * 客户撤销个人订单
	 *
	 * @param order 订单
	 * @return 系统提示消息
	 */
	public ResultMsg personalOrderCancel(OrderOnUserVO order) {
		if(order.getOrderState() == OrderState.UNEXECUTED)
			return new ResultMsg(true, "撤销成功!");
		else if(order.getOrderState() == OrderState.CANCELLED)
			return new ResultMsg(false, "请勿重复操作！");
		else if(order.getOrderState() == OrderState.EXECUTED)
			return new ResultMsg(false, "该订单已经执行，不可撤销！");
		else
			return new ResultMsg(false, "异常订单，不可撤销！");
	}
	
	/**
	 * 客户查看个人订单详情
	 *
	 * @param void
	 * @return 个人订单详情
	 */
	public OrderOnUserMsg personalOrderDetail(OrderOnUserVO order) {
		return new OrderOnUserMsg(order.getInitiator(), order.getOrderID(),order.getOrderState(), order.getPrice(), order.getLatestExecutionTime(), 
				order.getRoomType(), order.getRoomNumber(), order.getPeopleNumber(), order.getHasChild());
	}

}
