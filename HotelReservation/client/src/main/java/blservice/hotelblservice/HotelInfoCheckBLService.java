package blservice.hotelblservice;

import util.ResultMsg;
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
    public ResultMsg checkHotelInfo(HotelInfoVO hotelInfoVO);
  
}