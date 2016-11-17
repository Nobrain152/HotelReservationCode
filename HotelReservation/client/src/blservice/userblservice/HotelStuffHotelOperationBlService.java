package businesslogicservice.userblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.HotelIDVO;
import vo.HotelInfoVO;
import vo.OrderOnHotelVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;
import vo.UserIDVO;


/**
 * 酒店工作人员对酒店进行的操作
 * @author 曹畅
 *
 */
public interface HotelStuffHotelOperationBlService{
		
		
	/**
	 * 查看酒店信息	
	 * @param 酒店IDVO
	 * @return 酒店信息VO
	 */
	public HotelInfoVO HotelInformationInquiry(HotelIDVO vo);
		
	/**
	 * 修改酒店信息	
	 * @param 酒店VO
	 * @param 用户IDVO
	 * @return 修改结果
	 */
	public ResultMsg HotelInformationModification(HotelInfoVO vo1,UserIDVO vo2);
		
	/**
	 * 查看酒店促销策略
	 * @param 酒店IDVO
	 * @return 酒店促销策略列表
	 */
	public ArrayList<PromotionHotelVO> HotelPromotionInquire(HotelIDVO vo);
	
	/**
	 * 管理酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean HotelStrategeManage(HotelIDVO vo1,PromotionHotelVO vo); 
		
	/**
	 * 更新订单状态	
	 * @param 用户IDVO
	 * @param 订单VO
	 */
	public ResultMsg OrderStateUpdate(UserIDVO vo1,OrderOnHotelVO vo2);
		
	/**
	 * 浏览酒店订单	
	 * @param 酒店IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderOnHotelVO> OrderScan(HotelIDVO vo);
	
	/**
	 * 更新房间信息
	 * @param 房间信息VO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo);
		
}