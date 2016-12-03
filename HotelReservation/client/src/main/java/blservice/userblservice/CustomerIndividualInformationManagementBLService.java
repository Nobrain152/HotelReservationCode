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
	public boolean IndividualBaseInfoModification(String userid,CustomerInfoVO vo2);
		
	/**
	 * 查询个人订单
	 * @param 用户IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid);
		
	/**
	 * 查询预定过的酒店	
	 * @param 用户IDVO
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(String userid);
		
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