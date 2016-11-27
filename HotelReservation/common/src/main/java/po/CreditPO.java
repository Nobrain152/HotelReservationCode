package po;


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
	
	public CreditPO(String userID, int credit) {
		this.userID = userID;
		this.credit = credit;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public int getcredit() {
		return credit;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
}
