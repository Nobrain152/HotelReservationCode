package vo;

/**
 * �����û���Ϣ�ĸ���
 * 
 * @author lenovo
 *
 */
public class UserInfoVO {

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