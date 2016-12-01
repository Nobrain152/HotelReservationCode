package vo;

import java.util.ArrayList;

import util.VipType;

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
	
	/**
	 * ��Ա����
	 */
	private VipType vipType;
	
	ArrayList<String> orderIDList;
	ArrayList<String> hotelIDList;
	ArrayList<String> creditList;

	public CustomerInfoVO(String userid, String username, ContactVO contact,
			int credit, boolean isMember,VipType vipType) {
		super(userid, username, contact);
		this.credit = credit;
		this.isMember = isMember;
		this.vipType = vipType;
		this.orderIDList = new ArrayList<String>();
		this.hotelIDList = new ArrayList<String>();
		this.creditList = new ArrayList<String>();
	}

	public int getCredit() {
		return credit;
	}

	public boolean getIsMember() {
		return isMember;
	}
	
	public VipType getVipType() {
		return vipType;
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
	
	public void setVipType(VipType vipType) {
		this.vipType = vipType;
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
	
}