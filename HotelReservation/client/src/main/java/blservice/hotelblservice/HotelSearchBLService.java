package blservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelInfoVO;

/**
 * �����Ƶ�Ľӿ�
 * @author �ܳ�
 *
 */
public interface HotelSearchBLService {
	
	/**
	 * ѡ��Ƶ�����
	 * @param hotelConditionVO
	 * @return
	 */
	public ArrayList<HotelInfoVO> selectCondition(HotelInfoVO hotelConditionVO);
	
	
    
}