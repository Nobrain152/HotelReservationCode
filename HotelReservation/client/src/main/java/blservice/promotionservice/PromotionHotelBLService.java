package blservice.promotionservice;

import java.util.ArrayList;

import util.PromotionMsg;
import vo.PromotionHotelVO;

/**
 * 酒店促销策略逻辑层接口
 * @author kevin
 *
 */

public interface PromotionHotelBLService {
	//修改促销策略，返回是否修改成功的信息
	public PromotionMsg changeBirthCut(int level,double ratio);
	
	public PromotionMsg changeOverCut(int number,double ratio);
	
	public PromotionMsg changeJoin(String businessName,double ratio) ;
	
	public PromotionMsg changeHotelCustomCut (String timeBegin,String timeOver, double ratio);
	//增加促销策略
	public PromotionMsg addBirthCut(int level,double ratio);
	
	public PromotionMsg addOverCut(int number,double ratio);
	
	public PromotionMsg addJoin(String businessName,double ratio) ;
	
	public PromotionMsg addHotelCustomCut (String timeBegin,String timeOver, double ratio);
	
	/**
	 * @param type
	 * 0:表示会员生日促销策略
	 * 1:表示三间以上优惠策略
	 * 2:表示合作企业促销策略
	 * 3:表示自定义促销策略
	 * @return 相应促销策略列表
	 */
	public ArrayList<PromotionHotelVO> getHotelPromotion(int type);
}
