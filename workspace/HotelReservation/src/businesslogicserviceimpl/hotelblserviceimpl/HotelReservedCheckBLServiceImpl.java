package businesslogicserviceimpl.hotelblserviceimpl;

import java.util.ArrayList;

import vo.HotelInfoVO;

public class HotelReservedCheckBLServiceImpl {
	ArrayList<HotelInfoVO> hotelList;
	
	public HotelReservedCheckBLServiceImpl() {
		hotelList = new ArrayList<HotelInfoVO>();
	}
	
	/**
	 * 显示已预订酒店列表
	 * 
	 */
    public ArrayList<HotelInfoVO> checkReserved(HotelInfoVO reservedHotelListVO){
    	return hotelList; 
    }
      
}