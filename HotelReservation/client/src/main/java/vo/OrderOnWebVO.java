package vo;

import util.OrderState;
import util.User;

/**
 * �ͻ�����VO
 * 
 * @author txin
 *
 */
public class OrderOnWebVO extends OrderVO{
	
	/**
	 * ��������
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
