package po;

import java.util.ArrayList;

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
	
	/**
	 * ����ֵ�б�
	 * ��ʽ XXXX/XX/XX/+/number
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
