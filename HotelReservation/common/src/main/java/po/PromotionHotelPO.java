package po;

import java.io.Serializable;

import util.CustomerType;
import util.PromotionHotelType;

/**
 * 酒店促销策略VO
 * 
 * @author kevin
 *
 */

public class PromotionHotelPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 酒店ID
	 */
	String hotelID;
	
	/**
	 * 促销策略类型
	 */
	PromotionHotelType hotelType;
	
	/**
	 * 客户类型
	 */
	CustomerType customType;
	
	/**
	 * 促销策略起止时间
	 */
	String timeBegin,timeOver;
	
	/**
	 * 促销策略打折比例
	 */
	double ratio;
	
	public PromotionHotelPO(String hotelID, PromotionHotelType hotelType,CustomerType customType,
			String timeBegin,String timeOver,double ratio) {
		this.hotelID = hotelID;
		this.hotelType = hotelType;
		this.hotelType = hotelType;
		this.timeBegin = timeBegin;
		this.timeOver = timeOver;
		this.ratio = ratio;
	}
	
	public String getHotelID() {
		return hotelID;
	}
	
	public PromotionHotelType getType(){
		return hotelType;
	}
	
	public CustomerType getMemberType() {
		return customType;
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
