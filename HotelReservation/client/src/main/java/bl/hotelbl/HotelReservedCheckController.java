package bl.hotelbl;

import java.util.ArrayList;

import vo.HotelInfoVO;

public class HotelReservedCheckController {
	public ArrayList<HotelInfoVO> hotelList;
	
	public HotelReservedCheckController() {
		hotelList = new ArrayList<HotelInfoVO>();
	}
	
	/**
	 * ��ʾ��Ԥ���Ƶ��б�
	 * 
	 */
    public ArrayList<HotelInfoVO> checkReserved(HotelInfoVO reservedHotelListVO){
    	return hotelList; 
    }
      
}