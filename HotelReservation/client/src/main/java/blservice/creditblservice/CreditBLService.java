package blservice.creditblservice;

import vo.CreditVO;
/**
 * 积分业务逻辑接口
 * @author kevin
 *
 */
import vo.CustomerInfoVO;
import vo.UserInfoVO;

public interface CreditBLService{
	/**
	 * 获得信用值
	 * 
	 */
	public CreditVO getCredit(CustomerInfoVO client);
	
	/**
	 * 增加信用值
	 */
	public CreditVO addCredit(CustomerInfoVO client,int value);
	
	/**
	 * 减少信用值
	 */
	public CreditVO subCredit(CustomerInfoVO client,int value);
	
	/**
	 * 修改信用值
	 */
	public CreditVO changeCredit(CustomerInfoVO client,int value);

}
