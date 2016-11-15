package po;

import java.io.Serializable;

import businesslogic.util.User;
import businesslogic.util.OrderState;
import businesslogic.util.RoomType;

/**
 * 客户订单VO
 * 
 * @author txin
 *
 */
public class OrderOnHotelPO extends OrderPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 入住时间
	 */
	public String checkInTime;
	
	/**
	 * 退房时间
	 */
	public String checkOutTime;
	
	/**
	 * 最晚执行时间
	 */
	public String latestExecutionTime;
	
	/**
	 * 房间类型
	 */
	public RoomType roomType;
	
	/**
	 * 房间数量
	 */
	public int roomNumber;
	
	/**
	 * 入住人数
	 */
	public int peopleNumber;
	
	/**
	 * 是否携带儿童
	 */
	public boolean hasChild;

	
	public OrderOnHotelPO(User initiator,String orderID,OrderState orderState,int price,String checkInTime,String checkOutTime,
		String latestExecutionTime,RoomType roomType,int roomNumber,int peopleNumber,boolean hasChild) {
		this.initiator = initiator;
		this.orderID = orderID;
		this.orderState = orderState;
		this.price = price;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.latestExecutionTime = latestExecutionTime;
		this.roomType = roomType;
		this.roomNumber = roomNumber;
		this.peopleNumber = peopleNumber;
		this.hasChild = hasChild;
	}
	
    public boolean getHasChild() {
        return hasChild;
    }

	public String getCheckInTime() {
		return checkInTime;
	}
	
	public String getCheckOutTime() {
		return checkOutTime;
	}
	
	public String getLatestExecutionTime() {
		return latestExecutionTime;
	}
	
	public RoomType getRoomType() {
		return roomType;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public int getPeopleNumber() {
		return peopleNumber;
	}
}
