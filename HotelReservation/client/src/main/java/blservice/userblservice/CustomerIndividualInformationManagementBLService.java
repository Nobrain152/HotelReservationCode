package blservice.userblservice;

import java.util.ArrayList;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderOnUserVO;
import vo.UserIDVO;
import vo.UserInfoVO;
import vo.IntegralVO;


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
	public UserInfoVO IndividualBaseInfolnquiry(UserIDVO vo);
		
	/**
	 * 修改个人基本信息
	 * @param 用户IDVO
	 * @param 客户个人信息VO
	 * @return 修改成功与否
	 */
	public boolean IndividualBaseInfoModification(UserIDVO vo1,CustomerInfoVO vo2);
		
	/**
	 * 查询个人订单
	 * @param 用户IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderOnUserVO> IndividualOrderInquiry(UserIDVO vo);
		
	/**
	 * 查询预定过的酒店	
	 * @param 用户IDVO
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(UserIDVO vo);
		
	/**
	 * 查询个人信用信息	
	 * @param 用户IDVO
	 * @return 信用VO
	 */
	public IntegralVO IndividualCredictInquiry(UserIDVO vo);
		
			
}