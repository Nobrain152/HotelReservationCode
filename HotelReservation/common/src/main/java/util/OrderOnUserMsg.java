package util;

/**
 * 客户订单VO
 * 
 * @author txin
 *
 */
public class OrderOnUserMsg extends OrderMsg{
	
	/**
	 * 申诉理由
	 */
	public String reason;
	
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
	
	public OrderOnUserMsg(User initiator,String orderID,OrderState orderState,int price,String latestExecutionTime,
			RoomType roomType,int roomNumber,int peopleNumber,boolean hasChild) {
		this.initiator = initiator;
		this.orderID = orderID;
		this.orderState = orderState;
		this.price = price;
		this.latestExecutionTime = latestExecutionTime;
		this.roomType = roomType;
		this.roomNumber = roomNumber;
		this.peopleNumber = peopleNumber;
		this.hasChild = hasChild;
	}
	
	public OrderOnUserMsg(User initiator,OrderState orderState,String reason){
		super();
		this.reason = reason;
	}
	
    public boolean getHasChild() {
        return hasChild;
    }

	public String getReason() {
		return reason;
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
