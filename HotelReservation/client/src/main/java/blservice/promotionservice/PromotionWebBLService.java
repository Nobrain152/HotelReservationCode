package blservice.promotionservice;

import java.util.ArrayList;

import util.PromotionMsg;
import vo.PromotionWebVO;

/**
 * ��վ�������Խӿ�
 * @author kevin
 *
 */


public interface PromotionWebBLService {
	//�޸Ĵ�������
	public PromotionMsg changeLevelCut(int level,double ratio);
	
	public PromotionMsg changeCircleCut(String location,double ratio);
	
	public PromotionMsg changeWebCustomCut(String timeBegin,String timeOver, double ratio);
	
	//���Ӵ�������
	public PromotionMsg addLevelCut(int level,double ratio);
	
	public PromotionMsg addCircleCut(String location,double ratio);
	
	public PromotionMsg addWebCustomCut(String timeBegin,String timeOver, double ratio);
	
	/**
	 * @param type
	 * 0:��ʾ��Ա�ȼ��Żݲ���
	 * 1:��ʾ�ض������Żݲ���
	 * 2:��ʾ�Զ����������
	 * @return ��Ӧ���������б�
	 */
	public ArrayList<PromotionWebVO> getWebPromotion(int type);
}
