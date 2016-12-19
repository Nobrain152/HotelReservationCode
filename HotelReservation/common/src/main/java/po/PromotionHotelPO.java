package po;

import java.io.Serializable;
import util.PromotionHotelType;

/**
 * �Ƶ��������VO
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
	
	public PromotionHotelPO() {}
	
	/**
	 * �Զ���ʱ��Ҫ���в���
	 * @param hotelID
	 * @param hotelType
	 * @param customType
	 * @param beginTime
	 * @param endTime
	 * @param ratio
	 * @param level
	 * @param number
	 * @param businessName
	 */
	public PromotionHotelPO(String hotelID, PromotionHotelType hotelType,
			String beginTime,String endTime,double ratio,int level,int number,String businessName) {
		this.hotelID = hotelID;
		this.hotelType = hotelType;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = ratio;
		this.level = level;
		this.number = number;
		this.businessName = businessName;
	}
	
	/**
	 * �����ۿۣ�����һ������������ۿ�
	 * @param promotionHotelType
	 * @param hotelId
	 * @param num
	 * @param ratio
	 */
	public PromotionHotelPO(PromotionHotelType promotionHotelType,String hotelId,int num,double ratio) {
		this.hotelType = promotionHotelType;
		this.hotelID = hotelId;
		if(promotionHotelType == PromotionHotelType.BIRTH_PROMOTION)
			this.level = num;
		else if(promotionHotelType == PromotionHotelType.OVERTHREE_PROMOTION)
			this.number = num;
		this.ratio = ratio;
	}
	
	/**
	 * ������ҵ�ۿ�
	 * @param promotionHotelType
	 * @param hotelID
	 * @param businessName
	 * @param ratio
	 */
	public PromotionHotelPO(PromotionHotelType promotionHotelType,String hotelID,String businessName,double ratio) {
		this.hotelType = promotionHotelType;
		this.hotelID = hotelID;
		this.businessName  = businessName;
		this.ratio = ratio;
	}
	
	/**
	 * �Զ����ۿۣ�ĳ�ض�ʱ��
	 * @param type
	 * @param hotelID
	 * @param beginTime
	 * @param endTime
	 * @param radio
	 */
	public PromotionHotelPO(PromotionHotelType type,String hotelID,String beginTime,String endTime,double radio) {
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
}
