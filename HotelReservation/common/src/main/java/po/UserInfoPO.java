package po;

import java.io.Serializable;

import util.UserType;
import util.VipType;

public class UserInfoPO implements Serializable{
	
	private static final long serialVersionUID = -7187002330817151504L;
	/**
	 * �û�ID
	 */
	private String userID;

	/**
	 * �û�����
	 */
	private String username;

	/**
	 * ��ϵ��ʽ
	 */
	private ContactPO contact;
	
	/**
	 * �û�����
	 */
	private UserType type;
	
	/**
	 * �Ƶ깤����Ա�������Ƶ�ID
	 */
	private String hotel;
	
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

	public UserInfoPO(String userID, String username, ContactPO contact) {
		this.userID = userID;
		this.username = username;
		this.contact = contact;
	}

	public String getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public ContactPO getContact() {
		return contact;
	}
	
	public void setUserid(String userID) {
		this.userID = userID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setContact(ContactPO contactVO) {
		this.contact = contactVO;
	}
	
	public UserType getType(){
		return type;
	}
	
	public void setType(UserType ty){
		type=ty;
	}
	
	public String getHotel(){
		return hotel;
	}	
	
	public void setHotel(String id){
		hotel = id;
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
	
	
	public void setVipType(VipType vipType) {
		this.vipType = vipType;
	}
	
	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}
}