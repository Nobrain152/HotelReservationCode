package blservice.vipblservice;

/**
 * ��Աҵ���߼���ӿ�
 * @author kevin
 *
 */

import vo.VipVO;

import java.util.ArrayList;

import vo.CustomerInfoVO;

public interface VipLevelBLService {
	/**
	 * ��ø�����Ա�ȼ���Ӧ����ֵ
	 */
	public ArrayList<VipVO> showLevelNeed() ;
	
	/**
	 * ����û���ǰ����ֵ��Ӧ�ĵȼ�
	 */
	public int searchLevel(CustomerInfoVO user);
	
	/**
	 * �޸��û��ȼ���Ҫ������ֵ
	 */
	public void changeLevelNeed(int level, int integral);
}
