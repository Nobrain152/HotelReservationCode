package po;

import java.io.Serializable;

import businesslogic.util.RoomType;
import businesslogic.util.RoomState;

public class RoomInfoPO implements Serializable{



	private static final long serialVersionUID = -7187002330817151504L;

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
	


	public RoomInfoPO(RoomState state, RoomType type, int number, int price ) {
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