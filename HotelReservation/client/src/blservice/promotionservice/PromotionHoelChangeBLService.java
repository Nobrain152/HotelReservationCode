package businesslogicservice.PromotionService;

import businesslogic.util.PromotionMsg;

/**
 * �Ƶ���������߼���ӿ�
 * @author kevin
 *
 */

public interface PromotionHoelChangeBLService {
	public PromotionMsg changeBirthCut(String ratio);
	
	public PromotionMsg changeOverCut(String ratio);
	
	public PromotionMsg changeHotelCustomCut (String timeBegin,String timeOver, String ratio);
	
}
