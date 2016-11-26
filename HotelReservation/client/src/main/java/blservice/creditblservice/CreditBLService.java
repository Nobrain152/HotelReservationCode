package blservice.creditblservice;

import vo.CreditVO;
/**
 * ����ҵ���߼��ӿ�
 * @author kevin
 *
 */
import vo.CustomerInfoVO;
import vo.UserInfoVO;

public interface CreditBLService{
	/**
	 * �������ֵ
	 * 
	 */
	public CreditVO getCredit(CustomerInfoVO client);
	
	/**
	 * ��������ֵ
	 */
	public CreditVO addCredit(CustomerInfoVO client,int value);
	
	/**
	 * ��������ֵ
	 */
	public CreditVO subCredit(CustomerInfoVO client,int value);
	
	/**
	 * �޸�����ֵ
	 */
	public CreditVO changeCredit(CustomerInfoVO client,int value);

}
