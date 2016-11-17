package vo;

import util.OrderState;
import util.User;

/**
 * 所有订单VO的父类
 * 
 * @author txin
 *
 */
public abstract class OrderVO {
	/**
	 * 订单发起人
	 */
	public User initiator;
	
	/**
	 * 订单编号
	 */
	public String orderID;
	
	/**
	 * 价格
	 */
	public int price;
	
	/**
	 * 订单状态
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
