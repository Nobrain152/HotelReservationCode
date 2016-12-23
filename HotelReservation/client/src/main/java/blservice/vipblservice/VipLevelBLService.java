package blservice.vipblservice;

import po.BusinessVipPO;
import po.CommonVipPO;

/**
 * ��Աҵ���߼���ӿ�
 * @author kevin
 *
 */


import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public interface VipLevelBLService {
	
	/**
	 * ����û���ǰ����ֵ��Ӧ�ĵȼ�
	 */
	public int searchLevel(CustomerInfoVO user);
	
	/**
	 * ע���Ա
	 * @param userID
	 * @param str
	 * @return
	 */
	public ResultMsg registerVip(String userID,VipType type,String str);
	
	/**
	 * �ƶ��ȼ��ƶ�
	 * @param levelSystemVO
	 */
	public ResultMsg createLevelSystem(LevelSystemVO levelSystemVO);

	public CommonVipPO findByUserIDC(String userID);
	
	public BusinessVipPO findByUserIDB(String userID);
	
	public ResultMsg updateC(CommonVipPO commonVipPO);
	
	public ResultMsg updateB(BusinessVipPO businessVipPO);
}
