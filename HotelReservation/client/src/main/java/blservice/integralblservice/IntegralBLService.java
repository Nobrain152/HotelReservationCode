package blservice.integralblservice;

import vo.IntegralVO;
/**
 * ����ҵ���߼��ӿ�
 * @author kevin
 *
 */

import vo.UserInfoVO;

public interface IntegralBLService{
	/**
	 * �������ֵ
	 * 
	 */
	public IntegralVO getIntegral(UserInfoVO client);
	
	/**
	 * ��������ֵ
	 */
	public IntegralVO addIntegral(UserInfoVO client,int value);
	
	/**
	 * ��������ֵ
	 */
	public IntegralVO subIntegral(UserInfoVO client,int value);
	
	/**
	 * �޸�����ֵ
	 */
	public IntegralVO changeIntegral(UserInfoVO client,int value);

}
