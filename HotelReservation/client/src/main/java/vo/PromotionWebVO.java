package vo;

import util.Area;
import util.PromotionWebType;
import util.VipType;


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
	PromotionWebType webType;
	
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
	Area location;
	
	/**
	 * 促销策略打折比例
	 */
	double ratio;
	
	public PromotionWebVO() {}
	
	public PromotionWebVO(PromotionWebType webType,VipType customType,
			String beginTime,String endTime,double ratio,int level,Area location) {
		this.webType = webType;
		this.webType = webType;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = ratio;
		this.level = level;
		this.location = location;
	}
	
	public PromotionWebVO(PromotionWebType promotionWebType,int level,double ratio) {
		this.webType = promotionWebType;
		this.level = level;
		this.ratio = ratio;
	}
	
	public PromotionWebVO(PromotionWebType promotionWebType,Area location,double ratio) {
		this.webType = promotionWebType;
		this.location  = location;
		this.ratio = ratio;
	}
	
	public PromotionWebVO(PromotionWebType type,String beginTime,String endTime,double radio) {
		this.webType = type;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}
	
	public PromotionWebType getType(){
		return webType;
	}
	
	public VipType getMemberType() {
		return customType;
	}
	
	public Area getLocation() {
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
    
    public void setType(PromotionWebType type) {
    	this.webType = type;
    }
    
    public void setMember(VipType type) {
    	this.customType = type;
    }
    
    public void setLocation(Area location) {
    	this.location = location;
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