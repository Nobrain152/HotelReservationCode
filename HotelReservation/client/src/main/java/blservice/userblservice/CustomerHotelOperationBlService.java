package blservice.userblservice;

import java.util.ArrayList;

import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;

/**
 * 客户对酒店的操作
 * 
 * @author 曹畅
 *
 */
public interface CustomerHotelOperationBlService{
        
	/**
	 * 根据输入的酒店搜索条件返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public ArrayList<HotelInfoVO> HotelSearch(HotelInfoVO vo);
	
	
	/**
	 * 对某一酒店生成订单
	 * @param 酒店IDVO
	 * @param 订单VO
	 *
	 */
	public void OederCreat(String hotelID,OrderVO vo2);
		
	/**
	 * 评价酒店	
	 * @param 酒店评价VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo);
		
	
	
		
			
}