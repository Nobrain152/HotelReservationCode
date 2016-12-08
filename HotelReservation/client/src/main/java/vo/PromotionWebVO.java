package vo;

import util.PromotionWebType;
import util.VipType;


/**
 * ��վ��������VO
 * 
 * @author kevin
 *
 */

public class PromotionWebVO {
	
	/**
	 * ������������
	 */
	PromotionWebType hotelType;
	
	/**
	 * �ͻ�����
	 */
	VipType customType;
	
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
	String location;
	
	/**
	 * �������Դ��۱���
	 */
	double ratio;
	
	public PromotionWebVO() {}
	
	public PromotionWebVO(PromotionWebType hotelType,VipType customType,
			String beginTime,String endTime,double ratio,int level,String location) {
		this.hotelType = hotelType;
		this.hotelType = hotelType;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = ratio;
		this.level = level;
		this.location = location;
	}
	
	public PromotionWebVO(PromotionWebType promotionWebType,int level,double ratio) {
		this.hotelType = promotionWebType;
		this.level = level;
		this.ratio = ratio;
	}
	
	public PromotionWebVO(PromotionWebType promotionWebType,String location,double ratio) {
		this.hotelType = promotionWebType;
		this.location  = location;
		this.ratio = ratio;
	}
	
	public PromotionWebVO(PromotionWebType type,String beginTime,String endTime,double radio) {
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