package po;

import java.util.ArrayList;

import java.io.Serializable;

/**
 * 
 * 处理信用值相关PO
 * 
 * @author kevin
 *
 */

public class CreditPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	public CreditPO(String userID, int credit,ArrayList<String> creditList) {
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
