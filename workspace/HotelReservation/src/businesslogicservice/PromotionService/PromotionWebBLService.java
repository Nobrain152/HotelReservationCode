package businesslogicservice.PromotionService;

import java.util.ArrayList;

import businesslogic.util.PromotionMsg;
import po.PromotionWebPO;

/**
 * ��վ�������Խӿ�
 * @author kevin
 *
 */


public interface PromotionWebBLService {
	//�޸Ĵ�������
	public PromotionMsg changeLevelCut(int level,String ratio);
	
	public PromotionMsg changeCircleCut(String location,String ratio);
	
	public PromotionMsg changeWebCustomCut(String timeBegin,String timeOver, String ratio);
	
	//���Ӵ�������
	public PromotionMsg addLevelCut(int level,String ratio);
	
	public PromotionMsg addCircleCut(String location,String ratio);
	
	public PromotionMsg addWebCustomCut(String timeBegin,String timeOver, String ratio);
	
	/**
	 * @param type
	 * 0:��ʾ��Ա�ȼ��Żݲ���
	 * 1:��ʾ�ض������Żݲ���
	 * 2:��ʾ�Զ����������
	 * @return ��Ӧ���������б�
	 */
	public ArrayList<PromotionWebPO> getWebPromotion(int type);
}
