package bl.hotelbl;

import java.util.ArrayList;

import util.HotelMsg;
import util.ResultMsg;
import vo.HotelInfoVO;

public class HotelInfoMaintainController {
	
	public ArrayList<HotelInfoVO> hotelList;
	
	public HotelInfoMaintainController() {
		hotelList = new ArrayList<HotelInfoVO>();
	}
	
	/**
	 * 输入酒店信息
	 *
	 */
	public HotelMsg inputHotelInfo(HotelInfoVO hotelInfoVO){
		return new HotelMsg(hotelInfoVO.getName(),hotelInfoVO.getAddress(),
    			hotelInfoVO.getArea(),hotelInfoVO.getLevel(),hotelInfoVO.getIntroduction(),
    			hotelInfoVO.getFacility(),hotelInfoVO.isReserved());
	}
	
	/**
	 * 提交酒店信息
	 * 
	 */
    public ResultMsg submitInfo(HotelInfoVO hotelInfoVO){
    	return new ResultMsg(true,"维护成功");
    }

}