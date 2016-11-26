package po;

import java.io.Serializable;

public class ContactPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ÊÖ»úºÅÂë
	 */
	public String phoneNumber;
	
	/**
	 * ÓÊÏäµØÖ·
	 */
	public String emailAddress;
	
	public ContactPO(String phoneNumber,String emailAddress) {
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
