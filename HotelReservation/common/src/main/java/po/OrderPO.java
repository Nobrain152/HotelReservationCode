package po;

import java.io.Serializable;

import util.OrderState;
import util.RoomType;

/**
 * ����
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
	 * ����������
	 */
	public CustomerInfoPO initiator;

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
	
	public OrderPO(CustomerInfoPO customerInfoPO, OrderState orderState,
			int price, String orderID, String hotelID, boolean hasChild,
			String latestExecutionTime, String checkInTime, String checkOutTime,
			int roomNumber, int peopleNumber, RoomType roomType){
		this.initiator = customerInfoPO;
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
	 * �����õ�PO
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
		this.roomType = po.getRoomType();
		this.reason = reason;		
	}
	
	/**
	 * ���������߷��ص�PO
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
		this.roomType = po.getRoomType();
		this.reason = po.getReason();
		this.pass = pass;
	}

	public CustomerInfoPO getInitiator() {
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

	public void setInitiator(CustomerInfoPO initiator) {
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
