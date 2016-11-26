package vo;

import java.util.ArrayList;

/**
 * 信用值VO
 * 
 * @author kevin
 *
 */

public class CreditVO {
	
	/**
	 * 用户ID
	 */
	String userID;
	
	/**
	 * 用户信用值
	 */
	int credit;
	
	/**
	 * 信用值列表
	 * 格式 XXXX/XX/XX/+/number
	 */
	ArrayList<String> creditList;
	
	public CreditVO(String userID, int credit,ArrayList<String> creditList) {
		this.userID = userID;
		this.credit = credit;
		this.creditList = creditList;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public int getcredit() {
		return credit;
	}
	
	public ArrayList<String> getCreditList() {
		return creditList;
	}
}
