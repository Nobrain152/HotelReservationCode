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
	
	public PromotionWebPO() {}
	
	public PromotionWebPO(PromotionWebType hotelType,VipType customType,
			String beginTime,String endTime,double ratio,int level,String location) {
		this.hotelType = hotelType;
		this.hotelType = hotelType;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = ratio;
		this.level = level;
		this.location = location;
	}
	
	public PromotionWebPO(PromotionWebType promotionWebType,Integer level,double ratio) {
		this.hotelType = promotionWebType;
		this.level = level;
		this.ratio = ratio;
	}
	
	public PromotionWebPO(PromotionWebType promotionWebType,String location,double ratio) {
		this.hotelType = promotionWebType;
		this.location  = location;
		this.ratio = ratio;
	}
	
	public PromotionWebPO(PromotionWebType type,String beginTime,String endTime,double radio) {
		this.hotelType = type;
		this.beginTime = beginTime;
		this.endTime = endTime;
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