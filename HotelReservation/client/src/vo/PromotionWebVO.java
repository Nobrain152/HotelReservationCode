package vo;

import businesslogic.util.PromotionWebType;


/**
 * 网站促销策略VO
 * 
 * @author kevin
 *
 */

public class PromotionWebVO {
	/**
	 * 促销策略类型
	 */
	PromotionWebType WebType;
	
	
	/**
	 * 促销策略起止时间
	 */
	String timeBegin,timeOver;
	
	/**
	 * 促销策略打折比例
	 */
	double ratio;
	
	public PromotionWebVO(PromotionWebType WebType,String timeBegin,String timeOver,double ratio) {
		// TODO Auto-generated constructor stub
		this.WebType = WebType;
		this.timeBegin = timeBegin;
		this.timeOver = timeOver;
		this.ratio = ratio;
	}
	
	public PromotionWebType getType(){
		return WebType;
	}
	
	public String getTimeBegin() {
        return timeBegin;
    }

    public String getTimeOver() {
        return timeOver;
    }
    public double getRatio() {
		return ratio;
	}
}