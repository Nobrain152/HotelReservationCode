package blservice.hotelblservice;

import util.HotelMsg;
import vo.HotelInfoVO;

/**
 * �鿴�Ƶ���Ϣ�Ľӿ�
 * @author gyf
 *
 */
public interface HotelInfoCheckBLService {
	
	/**
	 * �鿴�Ƶ���Ϣ
	 * @param hotelInfoVO
	 * @return
	 */
    public HotelMsg checkHotelInfo(HotelInfoVO hotelInfoVO);
  
}