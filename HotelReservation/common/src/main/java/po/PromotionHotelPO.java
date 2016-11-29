package po;

import java.io.Serializable;
import util.PromotionHotelType;
import util.VipType;

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
	VipType customType;
	
	/**
	 * ����������ֹʱ��
	 */
	String beginTime,endTime;
	
	/**
	 * �������Դ��۱���
	 */
	double ratio;
	
	public PromotionHotelPO(String hotelID, PromotionHotelType hotelType,VipType customType,
			String beginTime,String endTime,double ratio) {
		this.hotelID = hotelID;
		this.hotelType = hotelType;
		this.hotelType = hotelType;
		this.beginTime = beginTime;
		this.endTime = endTime;
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
        return beginTime;
    }

    public String getTimeOver() {
        return endTime;
    }
    public double getRatio() {
		return ratio;
	}
}
