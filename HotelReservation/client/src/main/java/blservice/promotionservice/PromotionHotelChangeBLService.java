package blservice.promotionservice;

import util.PromotionMsg;

/**
 * 酒店促销策略逻辑层接口
 * @author kevin
 *
 */

public interface PromotionHotelChangeBLService {
	public PromotionMsg changeBirthCut(String ratio);
	
	public PromotionMsg changeOverCut(String ratio);
	
	public PromotionMsg changeHotelCustomCut (String timeBegin,String timeOver, String ratio);
	
}
