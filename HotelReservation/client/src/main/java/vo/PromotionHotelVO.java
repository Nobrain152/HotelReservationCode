package vo;

import util.PromotionHotelType;


/**
 * 酒店促销策略VO
 * 
 * @author kevin
 *
 */

public class PromotionHotelVO {
	/**
	 * 促销策略类型
	 */
	PromotionHotelType hotelType;
	
	
	/**
	 * 促销策略起止时间
	 */
	String timeBegin,timeOver;
	
	/**
	 * 促销策略打折比例
	 */
	double ratio;
	
	public PromotionHotelVO(PromotionHotelType hotelType,String timeBegin,String timeOver,double ratio) {
		// TODO Auto-generated constructor stub
		this.hotelType = hotelType;
		this.timeBegin = timeBegin;
		this.timeOver = timeOver;
		this.ratio = ratio;
	}
	
	public PromotionHotelType getType(){
		return hotelType;
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
