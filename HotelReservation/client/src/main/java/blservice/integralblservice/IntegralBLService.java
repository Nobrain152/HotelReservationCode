package blservice.integralblservice;

import vo.IntegralVO;
/**
 * 积分业务逻辑接口
 * @author kevin
 *
 */

import vo.UserInfoVO;

public interface IntegralBLService{
	/**
	 * 获得信用值
	 * 
	 */
	public IntegralVO getIntegral(UserInfoVO client);
	
	/**
	 * 增加信用值
	 */
	public IntegralVO addIntegral(UserInfoVO client,int value);
	
	/**
	 * 减少信用值
	 */
	public IntegralVO subIntegral(UserInfoVO client,int value);
	
	/**
	 * 修改信用值
	 */
	public IntegralVO changeIntegral(UserInfoVO client,int value);

}
