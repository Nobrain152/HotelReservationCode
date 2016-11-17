package businesslogicserviceimpl.hotelblserviceimpl;

import java.util.ArrayList;

import businesslogic.util.HotelMsg;
import vo.HotelInfoVO;

public class HotelInfoCheckBLServiceImpl {
	ArrayList<HotelInfoVO> hotelList;
	
	public HotelInfoCheckBLServiceImpl() {
		hotelList = new ArrayList<HotelInfoVO>();
	}
	
	
	/**
	 * œ‘ ææ∆µÍ–≈œ¢
	 * 
	 */
    public HotelMsg checkHotelInfo(HotelInfoVO hotelInfoVO){
    	return new HotelMsg(hotelInfoVO.getName(),hotelInfoVO.getAddress(),
    			hotelInfoVO.getArea(),hotelInfoVO.getLevel(),hotelInfoVO.getIntroduction(),
    			hotelInfoVO.getFacility(),hotelInfoVO.isReserved());
    }
      
}