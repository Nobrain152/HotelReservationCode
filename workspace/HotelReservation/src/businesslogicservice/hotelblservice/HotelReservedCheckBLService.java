package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelInfoVO;

public interface HotelReservedCheckBLService {
	
	
	/**
	 * ��ʾ��Ԥ���Ƶ��б�
	 * 
	 */
    public ArrayList<HotelInfoVO> checkReserved(HotelInfoVO reservedHotelListVO);
   

      
}