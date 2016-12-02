package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.RoomState;
import util.RoomType;

/**
 * ������Ϣ
 * @author �ܳ�
 *
 */
public class RoomInfoPO implements Serializable{

	
	private static final long serialVersionUID = 1L;

	/**
	 * ����״̬
	 */
	private RoomState state;
	
	/**
	 * �����
	 */
	private String roomID;

	/**
	 * ��������
	 */
	private RoomType type;
	
	/**
	 * �۸�
	 */
	private int price;
	
	private ArrayList<String> OrderedTime;

	public RoomInfoPO(RoomState state, RoomType type, String roomID, int price ) {
		this.state = state;
		this.type = type;
		this.roomID= roomID;
		this.price= price;
		OrderedTime=new ArrayList<String>();
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
	
	public  ArrayList<String> getOrderedTime(){
		return OrderedTime;
	}
	
	

}	