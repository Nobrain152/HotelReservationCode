package blservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelInfoVO;

/**
 * �鿴�Ƶ���Ϣ�Ľӿ�
 * @author �ܳ�
 *
 */
public interface HotelInfoCheckBLService {
	
	/**
	 * �鿴�Ƶ���Ϣ
	 * @param hotelInfoVO
	 * @return
	 */
    public HotelInfoVO checkHotelInfo(String hotelid);
    
    /**
	 * �鿴�Ƶ��б���
	 * @return
	 */
	public ArrayList<HotelInfoVO> hotelScan();
  
}