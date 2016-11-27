package po;


import java.io.Serializable;

/**
 * 
 * ��������ֵ���PO
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
	 * �û�ID
	 */
	String userID;
	
	/**
	 * �û�����ֵ
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
