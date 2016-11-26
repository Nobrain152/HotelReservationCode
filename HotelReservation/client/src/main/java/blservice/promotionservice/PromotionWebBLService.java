package blservice.promotionservice;

import java.util.ArrayList;

import util.PromotionMsg;
import vo.PromotionWebVO;

/**
 * 网站促销策略接口
 * @author kevin
 *
 */


public interface PromotionWebBLService {
	//修改促销策略
	public PromotionMsg changeLevelCut(int level,double ratio);
	
	public PromotionMsg changeCircleCut(String location,double ratio);
	
	public PromotionMsg changeWebCustomCut(String timeBegin,String timeOver, double ratio);
	
	//增加促销策略
	public PromotionMsg addLevelCut(int level,double ratio);
	
	public PromotionMsg addCircleCut(String location,double ratio);
	
	public PromotionMsg addWebCustomCut(String timeBegin,String timeOver, double ratio);
	
	/**
	 * @param type
	 * 0:表示会员等级优惠策略
	 * 1:表示特定区域优惠策略
	 * 2:表示自定义促销策略
	 * @return 相应促销策略列表
	 */
	public ArrayList<PromotionWebVO> getWebPromotion(int type);
}
