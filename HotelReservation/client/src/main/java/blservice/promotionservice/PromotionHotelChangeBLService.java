package blservice.promotionservice;

import util.PromotionMsg;

/**
 * �Ƶ���������߼���ӿ�
 * @author kevin
 *
 */

public interface PromotionHotelChangeBLService {
	public PromotionMsg changeBirthCut(String ratio);
	
	public PromotionMsg changeOverCut(String ratio);
	
	public PromotionMsg changeHotelCustomCut (String timeBegin,String timeOver, String ratio);
	
}
