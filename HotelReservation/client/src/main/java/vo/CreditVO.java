package vo;

import util.Action;

public class CreditVO {

	/**
	 * ʱ��
	 */
	String time;
	
	/**
	 * ����ID
	 */
	String orderID;
	
	/**
	 * ִ�ж���
	 */
	Action action;
	
	/**
	 * ����ֵ�仯
	 */
	String creditChange;
	
	/**
	 * ����ֵ���
	 */
	int creditResult;
	
	public CreditVO(String time,String orderID,Action action,
			String creditChange,int creditResult) {
		this.time = time;
		this.orderID = orderID;
		this.action = action;
		this.creditChange = creditChange;
		this.creditResult = creditResult;
	}
	
	public int getCreditResult() {
		return creditResult;
	}
	
	public void setCreditResult(int creditResult) {
		this.creditResult = creditResult;
	}
	
}
