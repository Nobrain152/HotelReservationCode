package vo;

/**
 * ����ֵVO
 * 
 * @author kevin
 *
 */

public class CreditVO {
	
	/**
	 * �û�ID
	 */
	String userID;
	
	/**
	 * �û�����ֵ
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
