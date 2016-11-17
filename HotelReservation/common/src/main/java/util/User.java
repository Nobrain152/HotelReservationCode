package util;

public class User {
	
	/**
	 * 电话
	 */
	public String phoneNumber;
	
	/**
	 * 邮箱
	 */
	public String email;
	
	/**
	 * 信用值
	 */
	int credit;
	
	/**
	 * 姓名
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
