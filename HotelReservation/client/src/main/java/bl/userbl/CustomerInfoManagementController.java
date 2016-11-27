package bl.userbl;

import java.util.ArrayList;

import blservice.userblservice.CustomerIndividualInformationManagementBLService;
import vo.CreditVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.UserInfoVO;

public class CustomerInfoManagementController
		implements CustomerIndividualInformationManagementBLService {
	
	private Customer customer;
	
	/**
	 * 构造方法
	 * @param 用户ID
	 */
	public CustomerInfoManagementController(String userid){
		customer=new Customer(userid);
		
	}
	
	
	/**
	 * 查询个人基本信息
	 * @param userid
	 * @return 个人基本信息
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
		return customer.IndividualBaseInfolnquiry(userid);
	}
			
	/**
	 * 修改个人基本信息
	 * @param userid
	 * @param 客户基本信息
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(String userid,CustomerInfoVO vo2){
		return customer.IndividualBaseInfoModification(userid, vo2);
	}
			
	/**
	 * 查询个人订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid){
		return customer.IndividualOrderInquiry(userid);
	}
			
	/**
	 * 查询个人酒店信息
	 * @param userid
	 * @return 个人酒店信息列表
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(String userid){
		return customer.IndividualHotelInquiry(userid);
	}
			
	/**
	 * 查询个人信用
	 * @param userid
	 * @return 个人信用信息
	 */
	public CreditVO IndividualCredictInquiry(String userid){
		return 	customer.IndividualCredictInquiry(userid);
	}
			
}
