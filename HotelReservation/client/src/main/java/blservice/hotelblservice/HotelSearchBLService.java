package blservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelInfoVO;
import vo.RoomInfoVO;

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
	public ArrayList<HotelInfoVO> selectCondition(HotelInfoVO hotelConditionVO,RoomInfoVO vo2);
	
	
    
}