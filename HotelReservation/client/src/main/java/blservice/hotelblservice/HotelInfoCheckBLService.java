package blservice.hotelblservice;

import util.ResultMsg;
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
    public ResultMsg checkHotelInfo(HotelInfoVO hotelInfoVO);
  
}