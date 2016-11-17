package po;

import java.io.Serializable;

import businesslogic.util.User;
import businesslogic.util.OrderState;

/**
 * ���ж���VO�ĸ���
 * 
 * @author txin
 *
 */
public abstract class OrderPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4372713957287414663L;

	/**
	 * ����������
	 */
	public User initiator;
	
	
	/**
	 * �������
	 */
	public String orderID;
	
	/**
	 * �۸�
	 */
	public int price;
	
	/**
	 * ����״̬
	 */
	public OrderState orderState;
	
    public User getInitiator() {
        return initiator;
    }
	
	public OrderState getOrderState() {
		return orderState;
	}
	
	public int getPrice(){
		return price;
	}
	
	public String orderID(){
		return orderID;
	}

    public void setInitiator(User initiator) {
        this.initiator = initiator;
    }
	
	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
}
