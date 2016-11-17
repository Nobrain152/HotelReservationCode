package util;


/**
 * ��ϵ��Ϣ
 * 
 * @author txin
 *
 */
public class ConnectionMsg extends ResultMsg{
	
	/**
	 * �ֻ�����
	 */
	public String phoneNumber;
	
	/**
	 * �����ַ
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
