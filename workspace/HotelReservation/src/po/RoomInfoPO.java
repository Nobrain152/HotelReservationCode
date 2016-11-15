package po;

import java.io.Serializable;

import businesslogic.util.RoomType;
import businesslogic.util.RoomState;

public class RoomInfoPO implements Serializable{



	private static final long serialVersionUID = -7187002330817151504L;

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