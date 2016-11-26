package vo;

import java.util.ArrayList;

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
	
	/**
	 * ����ֵ�б�
	 * ��ʽ XXXX/XX/XX/+/number
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
