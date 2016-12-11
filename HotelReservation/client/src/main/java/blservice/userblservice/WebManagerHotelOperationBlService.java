package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * 网站管理人员对酒店的操作
 * @author 曹畅
 *
 */
public interface WebManagerHotelOperationBlService{
	
	/**
	 * 查看酒店列表
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelInfoVO> HotelScan();
	
	
	
	/**
	 * 添加酒店	
	 * @param 酒店信息VO
	 */
	public String HotelAdd(HotelInfoVO vo);
		
	/**
	 * 添加酒店工作人员
	 * @param 酒店IDVO
	 * @param 用户IDVO
	 */
	public ResultMsg StuffAdd(String hotelid,String userid);
		
}