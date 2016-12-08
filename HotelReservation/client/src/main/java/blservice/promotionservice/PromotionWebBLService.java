package blservice.promotionservice;

import java.util.ArrayList;

import util.PromotionWebType;
import util.ResultMsg;
import vo.PromotionWebVO;

/**
 * 网站促销策略接口
 * @author kevin
 *
 */


public interface PromotionWebBLService {
	//修改促销策略
	public ResultMsg changeLevelCut(int level,double ratio);
	
	public ResultMsg changeCircleCut(String location,double ratio);
	
	public ResultMsg changeWebCustomCut(String timeBegin,String timeOver, double ratio);
	
	//增加促销策略
	public ResultMsg addLevelCut(int level,double ratio);
	
	public ResultMsg addCircleCut(String location,double ratio);
	
	public ResultMsg addWebCustomCut(String timeBegin,String timeOver, double ratio);
	
	//删除促销策略
	public ResultMsg deleteLevelCut(int level);
	
	public ResultMsg deleteCircleCut(String location);
	
	public ResultMsg deleteWebCustomCut(String timeBegin,String timeOver);
	
	/**
	 * @param type
	 * 0:表示会员等级优惠策略
	 * 1:表示特定区域优惠策略
	 * 2:表示自定义促销策略
	 * @return 相应促销策略列表
	 */
	public ArrayList<PromotionWebVO> getWebPromotion(PromotionWebType type);
}
