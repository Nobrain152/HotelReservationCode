package vo;

import java.util.ArrayList;

/**
 * �ͻ���Ϣ
 * 
 * @author �ܳ�
 *
 */
public class CustomerInfoVO extends UserInfoVO {

	/**
	 * �ͻ�����ֵ
	 */
	private int credit;
	
	/**
	 * �Ƿ��Ա
	 */
	private boolean isMember;
	
	/*
	 * ����
	 */
	private String birthday;
	
	ArrayList<String> orderIDList;
	ArrayList<String> hotelIDList;
	ArrayList<String> creditList;

	public CustomerInfoVO(String userid, String username, ContactVO contact, int credit,String birthday) {
		super(userid, username, contact);
		this.credit = credit;
		this.isMember = false;
		this.orderIDList = new ArrayList<String>();
		this.hotelIDList = new ArrayList<String>();
		this.creditList = new ArrayList<String>();
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
	
	public ArrayList<String> getCreditList() {
		return creditList;
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