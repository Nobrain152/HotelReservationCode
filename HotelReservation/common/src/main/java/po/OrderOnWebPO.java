package po;

import java.io.Serializable;

import util.OrderState;
import util.User;

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
	
	/**
	 * �����Ƿ�ͨ��
	 */
	public boolean pass;
	
	public OrderOnWebPO(User initiator,String orderID,OrderState orderState,int price,String reason) {
		this.initiator = initiator;
		this.orderID = orderID;
		this.orderState = orderState;
		this.price = price;
		this.reason = reason;
	}

	/**
	 * ���ߵĶ���
	 * @param initiator
	 * @param orderID
	 * @param orderState
	 * @param price
	 * @param reason
	 * @param pass
	 */
	public OrderOnWebPO(User initiator,String orderID,OrderState orderState,int price,String reason,boolean pass) {
		this.initiator = initiator;
		this.orderID = orderID;
		this.orderState = orderState;
		this.price = price;
		this.reason = reason;
		this.pass = pass;
	}
	public String getReason() {
		return reason;
	}
	
	public boolean getPass() {
		return pass;
	}
	
}
