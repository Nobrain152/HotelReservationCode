package blservice.hotelblservice;

import util.HotelMsg;
import vo.HotelInfoVO;

/**
 * 查看酒店信息的接口
 * @author gyf
 *
 */
public interface HotelInfoCheckBLService {
	
	/**
	 * 查看酒店信息
	 * @param hotelInfoVO
	 * @return
	 */
    public HotelMsg checkHotelInfo(HotelInfoVO hotelInfoVO);
  
}