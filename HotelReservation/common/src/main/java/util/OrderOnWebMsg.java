package util;

/**
 * 客户订单VO
 * 
 * @author txin
 *
 */
public class OrderOnWebMsg extends OrderMsg{
	
	/**
	 * 申诉理由
	 */
	public String reason;
	
	public OrderOnWebMsg(User initiator,String orderID,OrderState orderState,int price,String reason) {
		this.initiator = initiator;
		this.orderID = orderID;
		this.orderState = orderState;
		this.price = price;
		this.reason = reason;
	}
	
	public String getReason(){
		return reason;
	}
	
}
