package blservice.hotelblservice;

import vo.HotelInfoVO;

/**
 * �鿴�Ƶ���Ϣ�Ľӿ�
 * @author �ܳ�
 *
 */
public interface HotelInfoCheckBLService {
	
	/**
	 * �鿴�Ƶ���Ϣ
	 * @param hotelInfoVO
	 * @return
	 */
    public HotelInfoVO checkHotelInfo(String hotelid);
  
}