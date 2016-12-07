package vo;


import util.OrderState;

/**
 * 所有订单VO的父类
 * 
 * @author txin
 *
 */
public class OrderVO {
	
	/**
	 * 订单发起人
	 */
	public CustomerInfoVO initiator;

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
	 * 房间信息
	 */
	public RoomInfoVO roomInfoVO;
	
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
	
	public OrderVO() {}
	
	public OrderVO(String orderID,CustomerInfoVO customerInfoVO, OrderState orderState,
			double price , String hotelID, boolean hasChild,
			String latestExecutionTime, String checkInTime, String checkOutTime,
			String cancelledTime,int roomNumber,RoomInfoVO roomInfoVO, int peopleNumber){
		this.initiator = customerInfoVO;
		this.orderState = orderState;
		this.price = price;
		this.orderID = orderID;
		this.hotelID = hotelID;
		this.hasChild = hasChild;
		this.latestExecutionTime = latestExecutionTime;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.cancelledTime = cancelledTime;
		this.roomInfoVO = roomInfoVO;
		this.roomNumber = roomNumber;
		this.peopleNumber = peopleNumber;
	}
	
	/**
	 * 申诉用的VO
	 * @param vo
	 * @param reason
	 */
	public OrderVO(OrderVO vo, String reason){
		this.initiator = vo.getInitiator();
		this.orderState = vo.getOrderState();
		this.price = vo.getPrice();
		this.orderID = vo.getOrderID();
		this.hotelID = vo.getHotelID();
		this.hasChild = vo.getHasChild();
		this.latestExecutionTime = vo.getLatestExecutionTime();
		this.checkInTime = vo.getCheckInTime();
		this.checkOutTime = vo.getCheckOutTime();
		this.roomNumber = vo.getRoomNumber();
		this.peopleNumber = vo.getPeopleNumber();
		this.reason = reason;		
	}
	
	/**
	 * 处理完申诉返回的VO
	 * @param vo
	 * @param pass
	 */
	public OrderVO(OrderVO vo, boolean pass){
		this.initiator = vo.getInitiator();
		this.orderState = vo.getOrderState();
		this.price = vo.getPrice();
		this.orderID = vo.getOrderID();
		this.hotelID = vo.getHotelID();
		this.hasChild = vo.getHasChild();
		this.latestExecutionTime = vo.getLatestExecutionTime();
		this.checkInTime = vo.getCheckInTime();
		this.checkOutTime = vo.getCheckOutTime();
		this.roomNumber = vo.getRoomNumber();
		this.peopleNumber = vo.getPeopleNumber();
		this.reason = vo.getReason();
		this.pass = pass;
	}

	public CustomerInfoVO getInitiator() {
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

	public boolean getHasChild() {
		return hasChild;
	}

	public String getLatestExecutionTime() {
		return latestExecutionTime;
	}

	public RoomInfoVO getRoomInfoVO() {
		return roomInfoVO;
	}
	
	public void setRoomInfoVO(RoomInfoVO roomInfoVO) {
		this.roomInfoVO = roomInfoVO;
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
	
	public String getCancelledTime() {
		return cancelledTime;
	}
	
	public void setCancelledTime(String cancelledTime) {
		this.cancelledTime = cancelledTime;
	}
	
	public String getReason() {
		return reason;
	}
	
	public boolean getPass() {
		return pass;
	}

	public void setInitiator(CustomerInfoVO initiator) {
		this.initiator = initiator;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public void setPrice(double price) {
		this.price = price;
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
