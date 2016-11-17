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

public class IntegralPO implements Serializable {

	private static final long serialVersionUID = 1L;
	public IntegralPO(String id,int integral,ArrayList<String> integralRecord) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.integral = integral;
		this.integralRecord = integralRecord;
	}
	
	/**
	 * �û�ID
	 */
	String id ;
	
	/**
	 * ����ֵ
	 */
	int integral ;
	
	/**
	 * ����ֵ��ֵ��¼
	 *
	 *��ʽ XXXX/XX/XX/+/number
	 */
	ArrayList<String> integralRecord ;
	
	public int getIntegral() {
		return integral;
	}
	
	public ArrayList<String> getIntegralRecord() {
		return integralRecord;
	}
	
	public String getUserID(){
		return id;
	}
	
}
