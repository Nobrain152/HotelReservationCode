package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelInfoVO;

public interface HotelReservedCheckBLService {
	
	
	/**
	 * 显示已预订酒店列表
	 * 
	 */
    public ArrayList<HotelInfoVO> checkReserved(HotelInfoVO reservedHotelListVO);
   

      
}