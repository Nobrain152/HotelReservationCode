package businesslogicservice.userblservice;

import java.util.ArrayList;

import vo.HotelEvaluateVO;
import vo.HotelIDVO;
import vo.HotelInfoVO;
import vo.OrderOnUserVO;
import vo.VipVO;

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
	public void OederCreat(HotelIDVO vo1,OrderOnUserVO vo2);
		
	/**
	 * 评价酒店	
	 * @param 酒店评价VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo);
		
	
	/**
	 * 申请会员
	 * @param 酒店IDVO
	 * @param 会员信息VO
	 */
	public void MemberRegisterApply(HotelIDVO vo1,VipVO vo2);
		
			
}