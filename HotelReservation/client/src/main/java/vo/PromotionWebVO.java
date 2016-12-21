package vo;

import util.Area;
import util.PromotionWebType;


/**
 * ��վ��������VO
 * 
 * @author kevin
 *
 */

public class PromotionWebVO {
	/**
	 * ��վ��������ID
	 */
	String promotionWebID;
	
	/**
	 * ������������
	 */
	PromotionWebType webType;
	
	/**
	 * ����������ֹʱ��
	 */
	String beginTime,endTime;
	
	/**
	 * ��Ա�ȼ�
	 */
	int level;
	
	/**
	 * λ��
	 */
	Area location;
	
	/**
	 * �������Դ��۱���
	 */
	double ratio;
	
	public PromotionWebVO() {}
	
	public PromotionWebVO(String promotionWebID,PromotionWebType webType,
			String beginTime,String endTime,double ratio,int level,Area location) {
		this.promotionWebID = promotionWebID;
		this.webType = webType;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = ratio;
		this.level = level;
		this.location = location;
	}
	
	public PromotionWebVO(String promotionWebID,PromotionWebType promotionWebType,int level,double ratio) {
		this.promotionWebID = promotionWebID;
		this.webType = promotionWebType;
		this.level = level;
		this.ratio = ratio;
	}
	
	public PromotionWebVO(String promotionWebID,PromotionWebType promotionWebType,Area location,double ratio) {
		this.promotionWebID = promotionWebID;
		this.webType = promotionWebType;
		this.location  = location;
		this.ratio = ratio;
	}
	
	public PromotionWebVO(String promotionWebID,PromotionWebType type,String beginTime,String endTime,double radio) {
		this.promotionWebID = promotionWebID;
		this.webType = type;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = radio;
	}
	
	public String getPromotionWebID(){
		return promotionWebID;
	}
	
	public PromotionWebType getType(){
		return webType;
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