package vo;

import java.util.ArrayList;

/**
 * ����ֵVO
 * 
 * @author kevin
 *
 */

public class IntegralVO {
	/**
	 * �û�����ֵ
	 */
	int integral;
	/**
	*  ����ֵ�޸ļ�¼
	*/
	String integralNote;
	
	public IntegralVO(int integral,String integralNote) {
		// TODO Auto-generated constructor stub
		this.integral = integral;
		this.integralNote = integralNote;
	}
	
	public int getIntegral() {
		return integral;
	}
	
	public String  getIntegralNote() {
		return integralNote;
	}
}
