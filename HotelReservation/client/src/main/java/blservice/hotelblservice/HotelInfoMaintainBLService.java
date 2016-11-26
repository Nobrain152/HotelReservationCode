package blservice.hotelblservice;

import util.HotelMsg;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * 维护酒店基本信息的接口
 * @author gyf
 *
 */
public interface HotelInfoMaintainBLService {
	
	/**
	 * 输入酒店信息
	 * @param hotelInfoVO
	 * @return
	 */
	public HotelMsg inputHotelInfo(HotelInfoVO hotelInfoVO);
	
	/**
	 * 检查信息是否符合条件
	 * @param hotelInfoVO
	 * @return
	 */
    public ResultMsg checkInfo(HotelInfoVO hotelInfoVO);
  
}