package blservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelInfoVO;

/**
 * 查看预订过的酒店的接口
 * @author gyf
 *
 */
public interface HotelReservedCheckBLService {
	
	/**
	 * 显示已预订过的酒店列表
	 * @param reservedHotelListVO
	 * @return
	 */
    public ArrayList<HotelInfoVO> showReservedList(HotelInfoVO reservedHotelListVO);
   
}