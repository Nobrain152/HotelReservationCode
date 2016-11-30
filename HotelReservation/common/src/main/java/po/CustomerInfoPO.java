package po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * �ͻ���Ϣ
 * @author �ܳ�
 *
 */
public class CustomerInfoPO extends UserInfoPO implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ͻ�����ֵ
	 */
	private int credit;
	
	/**
	 * �Ƿ��Ա
	 */
	boolean isMember;
	
	/*
	 * ����
	 */
	private String birthday;
	
	ArrayList<String> orderIDList;
	ArrayList<String> hotelIDList;

	public CustomerInfoPO(String userid, String username, ContactPO contact, int credit,String birthday) {
		super(userid, username, contact);
		this.credit = credit;
		this.isMember = false;
		this.orderIDList = new ArrayList<String>();
		this.hotelIDList = new ArrayList<String>();
		this.birthday=birthday;
	}

	public int getCredit() {
		return credit;
	}

	public boolean getIsMember() {
		return isMember;
	}
	
	public String getBirthday(){
		return birthday;
	}
	
	public ArrayList<String> getOrderIDList() {
		return orderIDList;
	}

	public ArrayList<String> getHotelIDList() {
		return hotelIDList;
	}
	
	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	public void addOrderID(String id) {
		if (orderIDList.indexOf(id) == -1) {
			orderIDList.add(id);
		}
	}

	public void addHotelID(String id) {
		if (hotelIDList.indexOf(id) == -1) {
			hotelIDList.add(id);
		}
	}
	
	public void setBirthday(String birthday){
		this.birthday=birthday;
	}
}