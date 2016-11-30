package blservice.vipblservice;

/**
 * 会员业务逻辑层接口
 * @author kevin
 *
 */

import vo.VipVO;

import java.util.ArrayList;

import po.VipPO;
import vo.UserInfoVO;

public interface VipLevelBLService {
	/**
	 * 获得各个会员等级对应信用值
	 */
	public ArrayList<VipVO> showLevelNeed() ;
	
	/**
	 * 获得用户当前信用值对应的等级
	 */
	public int searchLevel(UserInfoVO user);
	
	/**
	 * 修改用户等级需要的信用值
	 */
	public void changeLevelNeed(int level, int integral);
}
