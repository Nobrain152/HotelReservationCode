package po;

import java.io.Serializable;

import util.OrderState;

/**
 * 订单
 * 
 * @author txin
 *
 */
public class OrderPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4372713957287414663L;

	/**
	 * 订单发起人
	 */
	public CustomerInfoPO initiator;

	/**
	 * 订单ID
	 */
	public String orderID;

	/**
	 * 酒店ID
	 */
	public String hotelID;

	/**
	 * 价格
	 */
	public double price;

	/**
	 * 订单状态
	 */
	public OrderState orderState;

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
	 * 订单撤销时间
	 */
	public String cancelledTime;

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
	
	/**
	 * 申诉理由
	 */
	public String reason;
	
	/**
	 * 申诉是否通过
	 */
	public boolean pass;
	
	/**
	 * 房间信息
	 */
	public RoomInfoPO roomInfoPO;
	
	public OrderPO(String orderID,CustomerInfoPO customerInfoPO, 
			OrderState orderState,double price,String hotelID, boolean hasChild,
			String latestExecutionTime, String checkInTime, String checkOutTime,
			String cancelledTime,int roomNumber, int peopleNumber,RoomInfoPO roomInfoPO){
		this.initiator = customerInfoPO;
		this.orderState = orderState;
		this.price = price;
		this.orderID = orderID;
		this.hotelID = hotelID;
		this.hasChild = hasChild;
		this.roomInfoPO = roomInfoPO;
		this.latestExecutionTime = latestExecutionTime;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.cancelledTime = cancelledTime;
		this.roomNumber = roomNumber;
		this.peopleNumber = peopleNumber;
	}
	
	/**
	 * 申诉用的PO
	 * @param po
	 * @param reason
	 */
	public OrderPO(OrderPO po, String reason){
		this.initiator = po.getInitiator();
		this.orderState = po.getOrderState();
		this.price = po.getPrice();
		this.orderID = po.getOrderID();
		this.hotelID = po.getHotelID();
		this.hasChild = po.getHasChild();
		this.latestExecutionTime = po.getLatestExecutionTime();
		this.checkInTime = po.getCheckInTime();
		this.checkOutTime = po.getCheckOutTime();
		this.roomNumber = po.getRoomNumber();
		this.peopleNumber = po.getPeopleNumber();
		this.reason = reason;		
	}
	
	/**
	 * 处理完申诉返回的PO
	 * @param po
	 * @param pass
	 */
	public OrderPO(OrderPO po, boolean pass){
		this.initiator = po.getInitiator();
		this.orderState = po.getOrderState();
		this.price = po.getPrice();
		this.orderID = po.getOrderID();
		this.hotelID = po.getHotelID();
		this.hasChild = po.getHasChild();
		this.latestExecutionTime = po.getLatestExecutionTime();
		this.checkInTime = po.getCheckInTime();
		this.checkOutTime = po.getCheckOutTime();
		this.roomNumber = po.getRoomNumber();
		this.peopleNumber = po.getPeopleNumber();
		this.reason = po.getReason();
		this.pass = pass;
	}

	public CustomerInfoPO getInitiator() {
		return initiator;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public double getPrice() {
		return price;
	}

	public String getOrderID() {
		return orderID;
	}

	public String getHotelID() {
		return hotelID;
	}
	
	public RoomInfoPO getRoomInfoPO() {
		return roomInfoPO;
	}
	
	public void setRoomInfoPO(RoomInfoPO roomInfoPO) {
		this.roomInfoPO = roomInfoPO;
	}

	public boolean getHasChild() {
		return hasChild;
	}

	public String getLatestExecutionTime() {
		return latestExecutionTime;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public int getPeopleNumber() {
		return peopleNumber;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}
	
	public String getReason() {
		return reason;
	}
	
	public boolean getPass() {
		return pass;
	}

	public String getCancelledTime() {
		return cancelledTime;
	}
	
	public void setCancelledTime(String cancelledTime) {
		this.cancelledTime = cancelledTime;
	}
	
	public void setInitiator(CustomerInfoPO initiator) {
		this.initiator = initiator;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public void setLatestExecutionTime(String lastestExecutionTime) {
		this.latestExecutionTime = lastestExecutionTime;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
}
