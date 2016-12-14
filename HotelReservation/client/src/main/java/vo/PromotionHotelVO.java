package vo;

import util.PromotionHotelType;
import util.VipType;

/**
 * 酒店促销策略VO
 * 
 * @author kevin
 *
 */

public class PromotionHotelVO {
	

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
	
	public PromotionHotelVO() {}
	
	public PromotionHotelVO(String hotelID, PromotionHotelType hotelType,VipType customType,
			String beginTime,String endTime,double ratio,int level,int number,String businessName) {
		this.hotelID = hotelID;
		this.hotelType = hotelType;
		this.hotelType = hotelType;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = ratio;
		this.level = level;
		this.number = number;
		this.businessName = businessName;
	}
	
	public PromotionHotelVO(PromotionHotelType promotionHotelType,String hotelId,int num,double ratio) {
		this.hotelType = promotionHotelType;
		this.hotelID = hotelId;
		if(promotionHotelType == PromotionHotelType.BIRTH_PROMOTION)
			this.level = num;
		else if(promotionHotelType == PromotionHotelType.OVERTHREE_PROMOTION)
			this.number = num;
		this.ratio = ratio;
	}
	
	public PromotionHotelVO(PromotionHotelType promotionHotelType,String hotelID,String businessName,double ratio) {
		this.hotelType = promotionHotelType;
		this.hotelID = hotelID;
		this.businessName  = businessName;
		this.ratio = ratio;
	}
	
	public PromotionHotelVO(PromotionHotelType type,String hotelID,String beginTime,String endTime,double radio) {
		this.hotelType = type;
		this.hotelID = hotelID;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.hotelID = hotelID;
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
	
	public int getNumber() {
		return number;
	}
	
	public String getBusinessName() {
		return businessName;
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
    
    public void setType(PromotionHotelType type) {
    	this.hotelType = type;
    }
    
    public void setMemberType(VipType type) {
    	this.customType = type;
    }
    
    public void setNumber(int num) {
    	this.number = num;
    }
    
    public void setBusinessName(String businessName) {
    	this.businessName = businessName;
    }
    
    public void setTimeBegin(String time) {
    	this.beginTime = time;
    }
    
    public void setTimeOver(String time) {
    	this.endTime = time;
    }
    
    public void setLevel(int level) {
    	this.level = level;
    }
    
}
