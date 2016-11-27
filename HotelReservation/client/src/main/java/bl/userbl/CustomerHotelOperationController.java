package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.CustomerHotelOperationBlService;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.VipVO;


/**
 * 客户对酒店的操作
 * 
 * @author 曹畅
 *
 */
public class CustomerHotelOperationController implements CustomerHotelOperationBlService {
	
	private Customer customer;
	
	public CustomerHotelOperationController(String userID){
		customer=new Customer(userID);
	}

	
	/**
	 * 根据输入的酒店搜索条件返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public ArrayList<HotelInfoVO> HotelSearch(HotelInfoVO vo){
		return customer.HotelSearch(vo);
	}		
	
	
	/**
	 * 对某一酒店生成订单
	 * @param 酒店IDVO
	 * @param 订单VO
	 *
	 */
	public void OederCreat(String hotelID,OrderVO vo2){
	   customer.OederCreat(hotelID, vo2);
		
	}
			

	/**
	 * 评价酒店	
	 * @param 酒店评价VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo){
		customer.HotelEvaluate(vo);
	}
			
	
	/**
	 * 申请会员
	 * @param 酒店IDVO
	 * @param 会员信息VO
	 */
	public void MemberRegisterApply(String id,VipVO vo2){
		customer.MemberRegisterApply(id, vo2);
	}


}
