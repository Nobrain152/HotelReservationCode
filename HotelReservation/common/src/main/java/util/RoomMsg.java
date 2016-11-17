package util;

public class RoomMsg {
	/**
	 * 客房状态
	 */
	private RoomState state;

	/**
	 * 客房种类
	 */
	private RoomType type;
	
	/**
	 * 数量
	 */
	private int number;
	
	
	/**
	 * 价格
	 */
	private int price;
	


	public RoomMsg(RoomState state, RoomType type, int number, int price ) {
		super();
		this.state = state;
		this.type = type;
		this.number= number;
		this.price= price;
	}

	public RoomState getState() {
		return state;
	}

	public RoomType getType() {
		return type;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getPrice() {
		return price;
	}
	
}
