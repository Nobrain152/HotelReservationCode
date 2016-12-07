package vo;

import java.util.ArrayList;

import bl.hotelbl.Date;
import util.RoomState;
import util.RoomType;

/**
 * ������Ϣ
 * @author �ܳ�
 *
 */
public class RoomInfoVO {

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
	private double price;
	
	/**
	 * �����Ѿ���Ԥ����ʱ��
	 */
	private ArrayList<Date> OrderedTime;
	
	/**
	 * ���������ľƵ�ID
	 */
	private String hotelid;
	
	public RoomInfoVO() {}

	public RoomInfoVO(RoomState state, RoomType type, String roomID, double price,String hotelid ) {
		this.state = state;
		this.type = type;
		this.roomID= roomID;
		this.price= price;
		this.hotelid=hotelid;
		OrderedTime=new ArrayList<Date>();
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
	
	public double getPrice() {
		return price;
	}
	
	public String getRoomID() {
		return roomID;
	}
	
	public String getHotelid(){
		return hotelid;
	}
	
	public  ArrayList<Date> getOrderedTime(){
		return OrderedTime;
	}
	
	/**
	 * ���ӷ���Ԥ��ʱ��
	 * @param date
	 * @return
	 */
	public boolean addOrderedTime(Date date){
		for(Date time:OrderedTime){
			if(time.isConflict(date)){
				return false;
			}
		}
		OrderedTime.add(date);
		return true;
	}
	
	/**
	 * �Ƴ�һ��Ԥ��ʱ��
	 * @param date
	 * @return
	 */
	public boolean RemoveOrderedTime(Date date){
		int i=OrderedTime.indexOf(date);
		if(i==-1){
			return false;
		}
		OrderedTime.remove(i);
		return true;
	}

}	