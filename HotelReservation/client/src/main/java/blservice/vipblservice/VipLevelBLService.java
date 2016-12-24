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

/**
 * ��Ա
 * @author txin15
 *
 */
public interface VipLevelBLService {
	
	/**
	 * ����û���ǰ����ֵ��Ӧ�ĵȼ�
	 * @param user
	 * @return
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

	/**
	 * ������ͨ��Ա
	 * @param userID
	 * @return
	 */
	public CommonVipPO findByUserIDC(String userID);
	
	/**
	 * ������ҵ��Ա
	 * @param userID
	 * @return
	 */
	public BusinessVipPO findByUserIDB(String userID);
	
	/**
	 * ������ͨ��Ա��Ϣ
	 * @param commonVipPO
	 * @return
	 */
	public ResultMsg updateC(CommonVipPO commonVipPO);
	
	/**
	 * ������ҵ��Ա��Ϣ
	 * @param businessVipPO
	 * @return
	 */
	public ResultMsg updateB(BusinessVipPO businessVipPO);
}
