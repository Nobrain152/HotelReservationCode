package blservice.hotelblservice;

import java.util.ArrayList;

import util.HotelMsg;
import vo.HotelInfoVO;

/**
 * 搜索酒店的接口
 * @author gyf
 *
 */
public interface HotelSearchBLService {
	
	/**
	 * 选择酒店条件
	 * @param hotelConditionVO
	 * @return
	 */
	public HotelMsg selectCondition(HotelInfoVO hotelConditionVO);
	
	/**
	 * 显示搜索到的酒店列表
	 * @param hotelListInfoVO
	 * @return
	 */
    public ArrayList<HotelInfoVO> showList(HotelInfoVO hotelListInfoVO);
    
}