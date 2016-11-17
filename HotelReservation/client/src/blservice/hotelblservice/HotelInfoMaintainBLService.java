package businesslogicservice.hotelblservice;

import businesslogic.util.HotelMsg;
import businesslogic.util.ResultMsg;
import vo.HotelInfoVO;

public interface HotelInfoMaintainBLService {
	
	/**
	 * 输入酒店信息
	 *
	 */
	public HotelMsg inputHotelInfo(HotelInfoVO hotelInfoVO);
	
	/**
	 * 提交酒店信息
	 * 
	 */
    public ResultMsg submitInfo(HotelInfoVO hotelInfoVO);
   
  
      
}