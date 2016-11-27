package vo;

import util.OrderState;
import util.RoomType;

/**
 * ���ж���VO�ĸ���
 * 
 * @author txin
 *
 */
public class OrderVO {
	
	/**
	 * ����������
	 */
	public CustomerInfoVO initiator;

	/**
	 * ����ID
	 */
	public String orderID;

	/**
	 * �Ƶ�ID
	 */
	public String hotelID;

	/**
	 * �۸�
	 */
	public int price;

	/**
	 * ����״̬
	 */
	public OrderState orderState;

	/**
	 * ��סʱ��
	 */
	public String checkInTime;

	/**
	 * �˷�ʱ��
	 */
	public String checkOutTime;

	/**
	 * ����ִ��ʱ��
	 */
	public String latestExecutionTime;

	/**
	 * ��������
	 */
	public RoomType roomType;

	/**
	 * ��������
	 */
	public int roomNumber;

	/**
	 * ��ס����
	 */
	public int peopleNumber;

	/**
	 * �Ƿ�Я����ͯ
	 */
	public boolean hasChild;
	
	/**
	 * ��������
	 */
	public String reason;
	
	/**
	 * �����Ƿ�ͨ��
	 */
	public boolean pass;
	
	public OrderVO(CustomerInfoVO customerInfoVO, OrderState orderState,
			int price, String orderID, String hotelID, boolean hasChild,
			String latestExecutionTime, String checkInTime, String checkOutTime,
			int roomNumber, int peopleNumber, RoomType roomType){
		this.initiator = customerInfoVO;
		this.orderState = orderState;
		this.price = price;
		this.orderID = orderID;
		this.hotelID = hotelID;
		this.hasChild = hasChild;
		this.latestExecutionTime = latestExecutionTime;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.roomNumber = roomNumber;
		this.peopleNumber = peopleNumber;
		this.roomType = roomType;
	}
	
	/**
	 * �����õ�VO
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
		this.roomType = vo.getRoomType();
		this.reason = reason;		
	}
	
	/**
	 * ���������߷��ص�VO
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
		this.roomType = vo.getRoomType();
		this.reason = vo.getReason();
		this.pass = pass;
	}

	public CustomerInfoVO getInitiator() {
		return initiator;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public int getPrice() {
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

	public RoomType getRoomType() {
		return roomType;
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

	public void setInitiator(CustomerInfoVO initiator) {
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

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
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
