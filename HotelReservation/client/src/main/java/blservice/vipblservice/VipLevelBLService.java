package blservice.vipblservice;

/**
 * ��Աҵ���߼���ӿ�
 * @author kevin
 *
 */


import util.ResultMsg;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public interface VipLevelBLService {
	
	/**
	 * ����û���ǰ����ֵ��Ӧ�ĵȼ�
	 */
	public int searchLevel(CustomerInfoVO user);
	
	/**
	 * ע���Ա
	 * @param customerInfoVO
	 * @param str
	 * @return
	 */
	public ResultMsg registerVip(CustomerInfoVO customerInfoVO,String str);
	
	/**
	 * �ƶ��ȼ��ƶ�
	 * @param levelSystemVO
	 */
	public ResultMsg createLevelSystem(LevelSystemVO levelSystemVO);
}
