package blservice.hotelblservice;

import util.HotelMsg;
import util.ResultMsg;
import vo.HotelInfoVO;

public interface HotelInfoMaintainBLService {
	
	/**
	 * ����Ƶ���Ϣ
	 *
	 */
	public HotelMsg inputHotelInfo(HotelInfoVO hotelInfoVO);
	
	/**
	 * �ύ�Ƶ���Ϣ
	 * 
	 */
    public ResultMsg submitInfo(HotelInfoVO hotelInfoVO);
  
}