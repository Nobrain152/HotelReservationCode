package util;

public class User {
	
	/**
	 * �绰
	 */
	public String phoneNumber;
	
	/**
	 * ����
	 */
	public String email;
	
	/**
	 * ����ֵ
	 */
	int credit;
	
	/**
	 * ����
	 */
	String name;
	
	public int getCredit() {
		return credit;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public String getPhoneNumber (){
		return phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public User(String name,int credit,String phoneNum,String email){
		this.credit = credit;
		this.name = name;
		this.phoneNumber = phoneNum;
		this.email = email;
	}

}
