package blservice.promotionservice;

import util.PromotionMsg;

/**
 * ��վ�������Խӿ�
 * @author kevin
 *
 */


public interface PromotionWebChangeBLService {
	public PromotionMsg changeLevelCut(int level,String ratio);
	
	public PromotionMsg changeCircleCut(String ratio);
	
	public PromotionMsg changeWebCustomCut(String timeBegin,String timeOver, String ratio);
}
