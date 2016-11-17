package util;


/**
 * 联系信息
 * 
 * @author txin
 *
 */
public class ConnectionMsg extends ResultMsg{
	
	/**
	 * 手机号码
	 */
	public String phoneNumber;
	
	/**
	 * 邮箱地址
	 */
	public String emailAddress;
	
	public ConnectionMsg(String phoneNumber,String emailAddress) {
		super(false, null);
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

}
