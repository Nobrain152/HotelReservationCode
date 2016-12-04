package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.UserInfoVO;


/**
 * 客户管理个人信息
 * @author 曹畅
 *
 */
public interface CustomerIndividualInformationManagementBLService{
        
	/**
	 * 查询个人基本信息
	 * @param 用户IDVO
	 * @return 用户基本信息VO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid);
		
	/**
	 * 修改个人基本信息
	 * @param 用户IDVO
	 * @param 客户个人信息VO
	 * @return 修改成功与否
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,CustomerInfoVO vo2);
		
	/**
	 * 查询个人订单
	 * @param 用户IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid);
		
	
	/**
	 * 查询个人未执行订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> UnfinishedOrderInquiry(String userid);
	
	
	/**
	 * 查询个人已执行订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> finishedOrderInquiry(String userid);
	
	
	/**
	 * 查询个撤销订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> CancelOrderInquiry(String userid);
	
	
	/**
	 * 查询个人异常订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> AbnormalOrderInquiry(String userid);
	
	
	/**
	 * 查询预定过的酒店	
	 * @param 用户IDVO
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(String userid);
	
	/**
	 * 查询个人未执行酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> UnfinishedHotelInquiry(String userid);
	
	/**
	 * 查询个人已执行酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> finishedHotelInquiry(String userid);
	
	/**
	 * 查询个人异常酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> AbnormalHotelInquiry(String userid);
	
	/**
	 * 查询个撤销酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> CancelHotelInquiry(String userid);
		
	/**
	 * 查询个人信用信息	
	 * @param 用户IDVO
	 * @return 信用VO
	 */
	public int[] IndividualCredictInquiry(String userid);
	
	/**
	 * 查询个人信用信息记录	
	 * @param 用户IDVO
	 * @return 信用VO
	 */
	public ArrayList<CreditVO> IndividualCredictRecord(String userid);
	
	/**
	 * 删除个人订单
	 * @param orderVO
	 * @return
	 */
	public ResultMsg personalOrderCancel(OrderVO orderVO);
	
	
	
	
			
}