package blservice.promotionservice;

import util.PromotionMsg;

/**
 * 网站促销策略接口
 * @author kevin
 *
 */


public interface PromotionWebChangeBLService {
	public PromotionMsg changeLevelCut(int level,String ratio);
	
	public PromotionMsg changeCircleCut(String ratio);
	
	public PromotionMsg changeWebCustomCut(String timeBegin,String timeOver, String ratio);
}
