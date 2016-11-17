package vo;

import util.OrderState;
import util.User;

/**
 * ���ж���VO�ĸ���
 * 
 * @author txin
 *
 */
public abstract class OrderVO {
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
	
	public String getOrderID(){
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
	
	public void setOrderID(String orderID){
		this.orderID = orderID;
	}
}
