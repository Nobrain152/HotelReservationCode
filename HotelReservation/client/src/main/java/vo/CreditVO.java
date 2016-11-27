package vo;

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
	
	public CreditVO(String userID, int credit) {
		this.userID = userID;
		this.credit = credit;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public int getcredit() {
		return credit;
	}
	
}
