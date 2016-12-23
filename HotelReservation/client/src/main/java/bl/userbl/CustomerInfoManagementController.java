package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.CustomerIndividualInformationManagementBLService;
import dataservice.userdataservice.CustomerManagementDataService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import po.CustomerInfoPO;
import util.DataServiceType;
import util.OrderState;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;


/**
 * 客户对个人信息的操作
 * @author 曹畅
 *
 */
public class CustomerInfoManagementController
		implements CustomerIndividualInformationManagementBLService {
	
	private Customer customer;
	private CustomerManagementDataService customerManagementDataService;
	private UserManagementDataService userManagementDataService;
	
	/**
	 * 构造方法
	 * @param 用户ID
	 */
	public CustomerInfoManagementController(){
		customerManagementDataService = (CustomerManagementDataService)RMIManage.
				getDataService(DataServiceType.CustomerManagementDataService);
		userManagementDataService = (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		customer=new Customer(customerManagementDataService);
	}
	
	
	/**
	 * 查询个人基本信息
	 * @param userid
	 * @return 个人基本信息
	 */
	public CustomerInfoVO IndividualBaseInfolnquiry(String userid){
		try {
			return customer.IndividualBaseInfolnquiry(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	/**
	 * 修改个人基本信息
	 * @param userid
	 * @param 客户基本信息
	 * @return 修改结果
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,CustomerInfoVO vo2){
		try {
			return customer.IndividualBaseInfoModification(userid, vo2);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMsg.FAIL;
		}
	}
			
	/**
	 * 查询个人订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid){
		try {
			return customer.IndividualOrderInquiry(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查询个人未执行订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> UnfinishedOrderInquiry(String userid){
		try {
			return customer.SpecialOrderInquiry(userid,OrderState.UNEXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 查询个人已执行订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> finishedOrderInquiry(String userid){
		try {
			return customer.SpecialOrderInquiry(userid,OrderState.EXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 查询个撤销订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> CancelOrderInquiry(String userid){
		try {
			return customer.SpecialOrderInquiry(userid,OrderState.CANCELLED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 查询个人异常订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> AbnormalOrderInquiry(String userid){
		try {
			return customer.SpecialOrderInquiry(userid,OrderState.ABNORMAL);
		} catch (RemoteException e) {
			return null;
		}
	}
			
	/**
	 * 查询个人酒店信息
	 * @param userid
	 * @return 个人酒店信息列表
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(String userid){
		try {
			return customer.IndividualHotelInquiry(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查询个人未执行酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> UnfinishedHotelInquiry(String userid){
		try {
			return customer.SpecialHotelInquiry(userid,OrderState.UNEXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 查询个人已执行酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> finishedHotelInquiry(String userid){
		try {
			return customer.SpecialHotelInquiry(userid,OrderState.EXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 查询个人异常酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> AbnormalHotelInquiry(String userid){
		try {
			return customer.SpecialHotelInquiry(userid,OrderState.ABNORMAL);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 查询个撤销酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> CancelHotelInquiry(String userid){
		try {
			return customer.SpecialHotelInquiry(userid,OrderState.CANCELLED);
		} catch (RemoteException e) {
			return null;
		}
	}
			
	/**
	 * 查询个人信用
	 * @param userid
	 * @return 个人信用信息
	 */
	public int IndividualCredictInquiry(String userid){
		try {
			int result= customer.IndividualCredictInquiry(userid);
			return result;
		} catch (RemoteException e) {
			return -1;
		}
	}


	/**
	 * 查询个人信用记录
	 * @param userid
	 * @return 个人信用信息
	 */
	public ArrayList<CreditVO> IndividualCredictRecord(String userid) {
		try {
			return customer.IndividualCredictRecord(userid);
		} catch (RemoteException e) {
			return null;
		}
	}


	/**
	 * 撤销个人订单
	 * @param orderVO
	 * @return
	 */
	public ResultMsg personalOrderCancel(OrderVO orderVO){
		try {
			return customer.personalOrderCancel(orderVO);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}


	@Override
	public CustomerInfoPO getCustomerInfo(String userID) {
		try {
			return userManagementDataService.GetCustomerInfo(userID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void setCustomerInfo(String userID, CustomerInfoPO customerInfoPO) {
		try {
			userManagementDataService.SetCustomerInfo(userID, customerInfoPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
			
}
