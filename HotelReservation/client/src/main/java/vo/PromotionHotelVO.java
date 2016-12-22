package vo;

import util.PromotionHotelType;

/**
 * �Ƶ��������VO
 * 
 * @author kevin
 *
 */

public class PromotionHotelVO {
	/**
	 * �Ƶ��������ID
	 */
	String promotionHotelID;

	/**
	 * �Ƶ�ID
	 */
	String hotelID;
	
	/**
	 * ������������
	 */
	PromotionHotelType hotelType;
	
	/**
	 * ����������ֹʱ��
	 */
	String beginTime,endTime;
	
	/**
	 * ��Ա�ȼ�
	 */
	int level;
	
	/**
	 * ��������
	 */
	int number;
	
	/**
	 * ��ҵ����
	 */
	String businessName;
	
	/**
	 * �������Դ��۱���
	 */
	double ratio;
	
	public PromotionHotelVO() {}
	
	public PromotionHotelVO(String promotionHotelID,String hotelID, PromotionHotelType hotelType,
			String beginTime,String endTime,double ratio,int level,int number,String businessName) {
		this.promotionHotelID = promotionHotelID;
		this.hotelID = hotelID;
		this.hotelType = hotelType;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = ratio;
		this.level = level;
		this.number = number;
		this.businessName = businessName;
	}
	
	public PromotionHotelVO(String promotionHotelID,PromotionHotelType promotionHotelType,String hotelId,int num,double ratio) {
		this.promotionHotelID = promotionHotelID;
		this.hotelType = promotionHotelType;
		this.hotelID = hotelId;
		if(promotionHotelType == PromotionHotelType.BIRTH_PROMOTION)
			this.level = num;
		else if(promotionHotelType == PromotionHotelType.OVERTHREE_PROMOTION)
			this.number = num;
		this.ratio = ratio;
	}
	
	public PromotionHotelVO(String promotionHotelID,PromotionHotelType promotionHotelType,String hotelID,String businessName,double ratio) {
		this.promotionHotelID = promotionHotelID;
		this.hotelType = promotionHotelType;
		this.hotelID = hotelID;
		this.businessName  = businessName;
		this.ratio = ratio;
	}
	
	public PromotionHotelVO(String promotionHotelID,PromotionHotelType type,String hotelID,String beginTime,String endTime,double radio) {
		this.promotionHotelID = promotionHotelID;
		this.hotelType = type;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.hotelID = hotelID;
		this.ratio = radio;
	}
	
	public String getPromotionHotelID(){
		return promotionHotelID;
	}
	
	public String getHotelID() {
		return hotelID;
	}
	
	public PromotionHotelType getType(){
		return hotelType;
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
    
    public void setHotelID(String hotelID) {
    	this.hotelID = hotelID;
    }
    
}
