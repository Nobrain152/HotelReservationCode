package vo;

import util.UserType;

/**
 * �û���Ϣ
 * 
 * @author �ܳ�
 *
 */
public class UserInfoVO {

	/**
	 * �û�ID
	 */
	private String userID;
	
	
	private String password;

	/**
	 * �û�����
	 */
	private String username;

	/**
	 * ��ϵ��ʽ
	 */
	private String  contact;
	
	/**
	 * �û�����
	 */
	private UserType type;
	
	
	public UserInfoVO() {}

	public UserInfoVO(String userID, String username, String contact,String pass) {
		this.userID = userID;
		this.username = username;
		this.contact = contact;
		this.password=pass;
	}

	public String getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public String getContact() {
		return contact;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUserid(String userID) {
		this.userID = userID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setContact(String contactVO) {
		this.contact = contactVO;
	}
	
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public UserType getType(){
		return type;
	}
	
	public void setType(UserType ty){
		type=ty;
	}
	
	
	

}