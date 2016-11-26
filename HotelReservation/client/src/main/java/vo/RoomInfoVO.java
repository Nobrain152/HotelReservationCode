package vo;

import util.RoomState;
import util.RoomType;

/**
 * ������Ϣ
 * @author gyf
 *
 */
public class RoomInfoVO {

	/**
	 * ����״̬
	 */
	private RoomState state;

	/**
	 * ��������
	 */
	private RoomType type;
	
	/**
	 * ��������
	 */
	private int number;
	
	/**
	 * �۸�
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