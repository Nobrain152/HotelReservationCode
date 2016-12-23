package blservice.vipblservice;

import po.BusinessVipPO;
import po.CommonVipPO;

/**
 * 会员业务逻辑层接口
 * @author kevin
 *
 */


import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public interface VipLevelBLService {
	
	/**
	 * 获得用户当前信用值对应的等级
	 */
	public int searchLevel(CustomerInfoVO user);
	
	/**
	 * 注册会员
	 * @param userID
	 * @param str
	 * @return
	 */
	public ResultMsg registerVip(String userID,VipType type,String str);
	
	/**
	 * 制定等级制度
	 * @param levelSystemVO
	 */
	public ResultMsg createLevelSystem(LevelSystemVO levelSystemVO);

	public CommonVipPO findByUserIDC(String userID);
	
	public BusinessVipPO findByUserIDB(String userID);
	
	public ResultMsg updateC(CommonVipPO commonVipPO);
	
	public ResultMsg updateB(BusinessVipPO businessVipPO);
}
