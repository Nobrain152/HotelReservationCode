package vo;

import util.OrderState;
import util.User;

/**
 * 客户订单VO
 * 
 * @author txin
 *
 */
public class OrderOnWebVO extends OrderVO{
	
	/**
	 * 申诉理由
	 */
	public String reason;
	
	public OrderOnWebVO(User initiator,String orderID,OrderState orderState,int price,String reason) {
		this.initiator = initiator;
		this.orderID = orderID;
		this.orderState = orderState;
		this.price = price;
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}
	
}
