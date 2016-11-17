package vo;

import java.util.ArrayList;

/**
 * 信用值VO
 * 
 * @author kevin
 *
 */

public class IntegralVO {
	/**
	 * 用户信用值
	 */
	int integral;
	/**
	*  信用值修改记录
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
