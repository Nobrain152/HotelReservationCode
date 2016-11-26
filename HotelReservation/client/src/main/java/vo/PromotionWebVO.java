package vo;

import util.CustomerType;
import util.PromotionWebType;


/**
 * ��վ��������VO
 * 
 * @author kevin
 *
 */

public class PromotionWebVO {
	
	/**
	 * �Ƶ�ID
	 */
	String hotelID;
	
	/**
	 * ������������
	 */
	PromotionWebType hotelType;
	
	/**
	 * �ͻ�����
	 */
	CustomerType customType;
	
	/**
	 * ����������ֹʱ��
	 */
	String timeBegin,timeOver;
	
	/**
	 * �������Դ��۱���
	 */
	double ratio;
	
	public PromotionWebVO(String hotelID, PromotionWebType hotelType,CustomerType customType,
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
	
	public PromotionWebType getType(){
		return hotelType;
	}
	
	public CustomerType getMemberType() {
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