package blservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelInfoVO;

/**
 * 搜索酒店的接口
 * @author 曹畅
 *
 */
public interface HotelSearchBLService {
	
	/**
	 * 选择酒店条件
	 * @param hotelConditionVO
	 * @return
	 */
	public ArrayList<HotelInfoVO> selectCondition(HotelInfoVO hotelConditionVO);
	
	
    
}