package util;


/**
 * ��ϵ��Ϣ
 * 
 * @author txin
 *
 */
public class ConnectionMsg{
	
	/**
	 * �ֻ�����
	 */
	public String phoneNumber;
	
	/**
	 * �����ַ
	 */
	public String emailAddress;
	
	public ConnectionMsg(String phoneNumber,String emailAddress) {
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
