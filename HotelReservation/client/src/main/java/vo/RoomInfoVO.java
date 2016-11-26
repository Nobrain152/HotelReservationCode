package vo;

import util.RoomState;
import util.RoomType;

/**
 * 房间信息
 * @author lenovo
 *
 */
public class RoomInfoVO {

	/**
	 * 房间状态
	 */
	private RoomState state;

	/**
	 * 房间类型
	 */
	private RoomType type;
	
	/**
	 * 房间数量
	 */
	private int number;
	
	/**
	 * 价格
	 */
	private int price;

	public RoomInfoVO(RoomState state, RoomType type, int number, int price ) {
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