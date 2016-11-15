package po;

import java.io.Serializable;

import businesslogic.util.User;
import businesslogic.util.OrderState;

/**
 * �ͻ�����VO
 * 
 * @author txin
 *
 */
public class OrderOnWebPO extends OrderPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ��������
	 */
	public String reason;
	
	public OrderOnWebPO(User initiator,String orderID,OrderState orderState,int price,String reason) {
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
