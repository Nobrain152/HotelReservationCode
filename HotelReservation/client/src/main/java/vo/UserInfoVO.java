package vo;

/**
 * 所有用户信息的父类
 * 
 * @author lenovo
 *
 */
public class UserInfoVO {

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
	private ContactVO contact;

	public UserInfoVO(String userID, String username, ContactVO contact) {
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

	public ContactVO getContact() {
		return contact;
	}
	
	public void setUserid(String userID) {
		this.userID = userID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setContact(ContactVO contactVO) {
		this.contact = contactVO;
	}
}