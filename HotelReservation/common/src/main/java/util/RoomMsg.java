package util;

public class RoomMsg {
	/**
	 * �ͷ�״̬
	 */
	private RoomState state;

	/**
	 * �ͷ�����
	 */
	private RoomType type;
	
	/**
	 * ����
	 */
	private int number;
	
	
	/**
	 * �۸�
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
