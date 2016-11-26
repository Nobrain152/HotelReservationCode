package po;

import java.io.Serializable;

import util.CustomerType;
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
	
	public PromotionHotelPO(String hotelID, PromotionHotelType hotelType,CustomerType customType,
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
