package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.CustomerHotelOperationBlService;
import dataservice.userdataservice.CustomerManagementDataService;
import net.RMIManage;
import util.DataServiceType;
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
	private CustomerManagementDataService customerManagementDataService;
	
	public CustomerHotelOperationController(){
		customerManagementDataService = (CustomerManagementDataService)RMIManage.
				getDataService(DataServiceType.CustomerManagementDataService);
		customer=new Customer(customerManagementDataService);
	}

	
	/**
	 * 根据输入的酒店搜索条件返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public ArrayList<HotelInfoVO> HotelSearch(HotelInfoVO vo){
		try {
			return customer.HotelSearch(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}		
	
	
	/**
	 * 对某一酒店生成订单
	 * @param 酒店IDVO
	 * @param 订单VO
	 *
	 */
	public void OederCreat(String hotelID,OrderVO vo2){
	   try {
		customer.OederCreat(hotelID, vo2);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
			

	/**
	 * 评价酒店	
	 * @param 酒店评价VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo){
		try {
			customer.HotelEvaluate(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
	
	/**
	 * 申请酒店会员
	 * @param 酒店IDVO
	 * @param 会员信息VO
	 */
	public void HotelMemberRegisterApply(String hotelID,VipVO vo2){
		
	}
	
	
	/**
	 * 申请网站会员
	 * @param 会员信息VO
	 */
	public void WebMemberRegisterApply(VipVO vo2){
		
	}

}
