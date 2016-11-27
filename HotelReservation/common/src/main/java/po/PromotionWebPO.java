package po;

import java.io.Serializable;
import util.PromotionWebType;
import util.VipType;


/**
 * 网站促销策略VO
 * 
 * @author kevin
 *
 */

public class PromotionWebPO implements Serializable{
	
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
	PromotionWebType hotelType;
	
	/**
	 * 客户类型
	 */
	VipType customType;
	
	/**
	 * 促销策略起止时间
	 */
	String timeBegin,timeOver;
	
	/**
	 * 促销策略打折比例
	 */
	double ratio;
	
	public PromotionWebPO(String hotelID, PromotionWebType hotelType,VipType customType,
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
	
	public PromotionWebType getType(){
		return hotelType;
	}
	
	public VipType getMemberType() {
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