package po;

import java.io.Serializable;

import util.RoomState;
import util.RoomType;

/**
 * 房间信息
 * @author gyf
 *
 */
public class RoomInfoPO implements Serializable{

	
	private static final long serialVersionUID = 1L;

	/**
	 * 房间状态
	 */
	private RoomState state;
	
	/**
	 * 房间号
	 */
	private String roomID;

	/**
	 * 房间类型
	 */
	private RoomType type;
	
	/**
	 * 价格
	 */
	private int price;

	public RoomInfoPO(RoomState state, RoomType type, String roomID, int price ) {
		this.state = state;
		this.type = type;
		this.roomID= roomID;
		this.price= price;
	}

	public RoomState getState() {
		return state;
	}

	public RoomType getType() {
		return type;
	}
	
	public String getNumber() {
		return roomID;
	}
	
	public int getPrice() {
		return price;
	}

}	