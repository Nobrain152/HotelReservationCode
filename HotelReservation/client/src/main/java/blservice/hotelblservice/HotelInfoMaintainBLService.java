package blservice.hotelblservice;

import util.HotelMsg;
import util.ResultMsg;
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