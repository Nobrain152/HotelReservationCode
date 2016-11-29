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
	String beginTime,endTime;
	
	/**
	 * 会员等级
	 */
	int level;
	
	/**
	 * 位置
	 */
	String location;
	
	/**
	 * 促销策略打折比例
	 */
	double ratio;
	
	public PromotionWebPO(String hotelID, PromotionWebType hotelType,VipType customType,
			String beginTime,String endTime,double ratio,int level,String location) {
		this.hotelID = hotelID;
		this.hotelType = hotelType;
		this.hotelType = hotelType;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = ratio;
		this.level = level;
		this.location = location;
	}
	
	public PromotionWebPO(PromotionWebType promotionWebType,String hotelId,Integer level,double ratio) {
		this.hotelType = promotionWebType;
		this.hotelID = hotelId;
		this.level = level;
		this.ratio = ratio;
	}
	
	public PromotionWebPO(PromotionWebType promotionWebType,String hotelID,String location,double ratio) {
		this.hotelType = promotionWebType;
		this.hotelID = hotelID;
		this.location  = location;
		this.ratio = ratio;
	}
	
	public PromotionWebPO(PromotionWebType type,String hotelID,String beginTime,String endTime,double radio) {
		this.hotelType = type;
		this.hotelID = hotelID;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.hotelID = hotelID;
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
	
	public String getLocation() {
		return location;
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