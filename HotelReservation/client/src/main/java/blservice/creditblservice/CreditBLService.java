package blservice.creditblservice;

import util.ResultMsg;
import vo.CustomerInfoVO;

/**
 * 积分业务逻辑接口
 * @author kevin
 *
 */
public interface CreditBLService{
	/**
	 * 获得信用值
	 * 
	 */
	public int getCredit(CustomerInfoVO client);
	
	/**
	 * 增加信用值
	 */
	public ResultMsg addCredit(CustomerInfoVO client,int value);
	
	/**
	 * 减少信用值
	 */
	public ResultMsg subCredit(CustomerInfoVO client,int value);
	
	/**
	 * 修改信用值
	 */
	public ResultMsg changeCredit(CustomerInfoVO client,int value);

}
