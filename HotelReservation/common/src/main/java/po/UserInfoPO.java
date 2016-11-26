package po;

import java.io.Serializable;

public class UserInfoPO implements Serializable{
	
	private static final long serialVersionUID = -7187002330817151504L;
	/**
	 * 用户ID
	 */
	private String userID;

	/**
	 * 用户姓名
	 */
	private String username;

	/**
	 * 联系方式
	 */
	private ContactPO contact;

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
}