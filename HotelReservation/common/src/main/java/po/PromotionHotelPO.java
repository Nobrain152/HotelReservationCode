package po;

import java.io.Serializable;
import util.PromotionHotelType;
import util.VipType;

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
	VipType customType;
	
	/**
	 * 促销策略起止时间
	 */
	String beginTime,endTime;
	
	/**
	 * 会员等级
	 */
	int level;
	
	/**
	 * 房间数量
	 */
	int number;
	
	/**
	 * 企业名称
	 */
	String businessName;
	
	/**
	 * 促销策略打折比例
	 */
	double ratio;
	
	public PromotionHotelPO(String hotelID, PromotionHotelType hotelType,VipType customType,
			String beginTime,String endTime,double ratio) {
		this.hotelID = hotelID;
		this.hotelType = hotelType;
		this.hotelType = hotelType;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = ratio;
	}
	
	public PromotionHotelPO(PromotionHotelType promotionHotelType,int level,double ratio) {
		this.hotelType = promotionHotelType;
		this.level = level;
		this.ratio = ratio;
	}
	
	public String getHotelID() {
		return hotelID;
	}
	
	public PromotionHotelType getType(){
		return hotelType;
	}
	
	public VipType getMemberType() {
		return customType;
	}
	
	public String getTimeBegin() {
        return beginTime;
    }

    public String getTimeOver() {
        return endTime;
    }
    
    public int getLevel() {
    	return level;
    }
    
    public double getRatio() {
		return ratio;
	}
    
    public void setRatio(double ratio) {
    	this.ratio = ratio;
    }
}
