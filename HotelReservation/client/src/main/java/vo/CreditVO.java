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
	 * �û�ID
	 */
	String userID;
	
	/**
	 * ִ�ж���
	 */
	Action action;
	
	/**
	 * ����ֵ�仯
	 * ����+100��-100��t100��
	 */
	String creditChange;
	
	/**
	 * ����ֵ���
	 */
	int creditResult;
	
	public CreditVO() {}
	
	public CreditVO(String userID, String orderID,String time,Action action,
			String creditChange,int creditResult) {
		this.userID = userID;
		this.time = time;
		this.orderID = orderID;
		this.action = action;
		this.creditChange = creditChange;
		this.creditResult = creditResult;
	}
	
	public String getUserID(){
		return userID;
	}
	
	public String getOrderID(){
		return orderID;
	}
	
	public String getTime(){
		return time;
	}
	
	public int getCreditResult() {
		return creditResult;
	}
	
	public String getCreditChange(){
		return creditChange;
	}
	
	public Action getAction(){
		return action;
	}
	
	public void setCreditResult(int creditResult) {
		this.creditResult = creditResult;
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	
	public void setCreditChange(String creditChange) {
		this.creditChange = creditChange;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
}
