package blservice.hotelblservice;

import util.HotelMsg;
import vo.HotelInfoVO;

public interface HotelInfoCheckBLService {
	
	/**
	 * ��ʾ�Ƶ���Ϣ
	 * 
	 */
    public HotelMsg checkHotelInfo(HotelInfoVO hotelInfoVO);
  
}