package blservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelInfoVO;

/**
 * �鿴Ԥ�����ľƵ�Ľӿ�
 * @author gyf
 *
 */
public interface HotelReservedCheckBLService {
	
	/**
	 * ��ʾ��Ԥ�����ľƵ��б�
	 * @param reservedHotelListVO
	 * @return
	 */
    public ArrayList<HotelInfoVO> showReservedList(HotelInfoVO reservedHotelListVO);
   
}