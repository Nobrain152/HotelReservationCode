package vo;

import util.PromotionHotelType;
import util.VipType;

/**
 * �Ƶ��������VO
 * 
 * @author kevin
 *
 */

public class PromotionHotelVO {
	
	/**
	 * �Ƶ�ID
	 */
	String hotelID;
	
	/**
	 * ������������
	 */
	PromotionHotelType hotelType;
	
	/**
	 * �ͻ�����
	 */
	VipType customType;
	
	/**
	 * ����������ֹʱ��
	 */
	String timeBegin,timeOver;
	
	/**
	 * �������Դ��۱���
	 */
	double ratio;
	
	public PromotionHotelVO(String hotelID, PromotionHotelType hotelType,VipType customType,
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
	
	public PromotionHotelType getType(){
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
