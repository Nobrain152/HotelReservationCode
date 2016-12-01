package blservice.vipblservice;

/**
 * 会员业务逻辑层接口
 * @author kevin
 *
 */

import vo.VipVO;

import java.util.ArrayList;

import util.ResultMsg;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public interface VipLevelBLService {
	/**
	 * 获得各个会员等级对应信用值
	 */
	public ArrayList<VipVO> showLevelNeed() ;
	
	/**
	 * 获得用户当前信用值对应的等级
	 */
	public int searchLevel(CustomerInfoVO user);
	
	/**
	 * 注册会员
	 * @param customerInfoVO
	 * @param str
	 * @return
	 */
	public ResultMsg registerVip(CustomerInfoVO customerInfoVO,String str);
	
	/**
	 * 制定等级制度
	 * @param levelSystemVO
	 */
	public ResultMsg createLevelSystem(LevelSystemVO levelSystemVO);
}
