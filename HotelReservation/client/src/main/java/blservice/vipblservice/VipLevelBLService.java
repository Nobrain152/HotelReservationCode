package blservice.vipblservice;

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
}
