
package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.OrderState;

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
	public double price;

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
	 * ��������ʱ��
	 */
	public String cancelledTime;

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
	 * ������Ϣ
	 */
	public ArrayList<String> roomIDs;
	
	public OrderPO() {}
	
	public OrderPO(String orderID,CustomerInfoPO customerInfoPO, 
			OrderState orderState,double price,String hotelID, boolean hasChild,
			String latestExecutionTime, String checkInTime, String checkOutTime,
			String cancelledTime,int roomNumber, int peopleNumber,ArrayList<String> roomIDs){
		this.initiator = customerInfoPO;
		this.orderState = orderState;
		this.price = price;
		this.orderID = orderID;
		this.hotelID = hotelID;
		this.hasChild = hasChild;
		this.roomIDs = roomIDs;
		this.latestExecutionTime = latestExecutionTime;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.cancelledTime = cancelledTime;
		this.roomNumber = roomNumber;
		this.peopleNumber = peopleNumber;
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
	
	public ArrayList<String> getRoomIDs() {
		return roomIDs;
	}
	
	public void setRoomIDs(ArrayList<String> roomIDs) {
		this.roomIDs = roomIDs;
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
