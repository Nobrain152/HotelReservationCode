package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.CustomerHotelOperationBlService;
import dataservice.userdataservice.CustomerManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;


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
	public ArrayList<HotelInfoVO> HotelSearch(RoomInfoVO vo1,HotelInfoVO vo,String userid){
		try {
			return customer.HotelSearch(vo1,vo,userid);
		} catch (RemoteException e) {
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
	public ResultMsg OederCreat(String hotelID,OrderVO vo2){
	   try {
		return customer.OederCreat(hotelID, vo2);
	} catch (RemoteException e) {
		e.printStackTrace();
		return ResultMsg.FAIL;
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
			e.printStackTrace();
		}
	}
			
	
	/**
	 * 申请酒店会员
	 * @param 酒店IDVO
	 * @param 会员信息VO
	 */
	public ResultMsg HotelMemberRegisterApply(VipType type,String pa,CustomerInfoVO vo){
		try {
			return customer.HotelMemberRegisterApply(type,pa, vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
	
	

}
