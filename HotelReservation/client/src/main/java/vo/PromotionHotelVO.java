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
	 * ������������
	 */
	PromotionHotelType hotelType;
	
	
	/**
	 * ����������ֹʱ��
	 */
	String timeBegin,timeOver;
	
	/**
	 * �������Դ��۱���
	 */
	double ratio;
	
	public PromotionHotelVO(PromotionHotelType hotelType,String timeBegin,String timeOver,double ratio) {
		// TODO Auto-generated constructor stub
		this.hotelType = hotelType;
		this.timeBegin = timeBegin;
		this.timeOver = timeOver;
		this.ratio = ratio;
	}
	
	public PromotionHotelType getType(){
		return hotelType;
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
