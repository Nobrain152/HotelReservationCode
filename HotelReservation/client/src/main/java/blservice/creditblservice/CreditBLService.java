package blservice.creditblservice;

import util.ResultMsg;
import vo.CustomerInfoVO;

/**
 * ����ҵ���߼��ӿ�
 * @author kevin
 *
 */
public interface CreditBLService{
	/**
	 * �������ֵ
	 * 
	 */
	public int getCredit(CustomerInfoVO client);
	
	/**
	 * ��������ֵ
	 */
	public ResultMsg addCredit(CustomerInfoVO client,int value);
	
	/**
	 * ��������ֵ
	 */
	public ResultMsg subCredit(CustomerInfoVO client,int value);
	
	/**
	 * �޸�����ֵ
	 */
	public ResultMsg changeCredit(CustomerInfoVO client,int value);

}
