package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.CustomerIndividualInformationManagementBLService;
import dataservice.userdataservice.CustomerManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.UserInfoVO;

/**
 * 客户对个人信息的操作
 * @author 曹畅
 *
 */
public class CustomerInfoManagementController
		implements CustomerIndividualInformationManagementBLService {
	
	private Customer customer;
	private CustomerManagementDataService customerManagementDataService;
	
	/**
	 * 构造方法
	 * @param 用户ID
	 */
	public CustomerInfoManagementController(){
		customerManagementDataService = (CustomerManagementDataService)RMIManage.
				getDataService(DataServiceType.CustomerManagementDataService);
		customer=new Customer(customerManagementDataService);
	}
	
	
	/**
	 * 查询个人基本信息
	 * @param userid
	 * @return 个人基本信息
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
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
	public boolean IndividualBaseInfoModification(String userid,CustomerInfoVO vo2){
		try {
			return customer.IndividualBaseInfoModification(userid, vo2);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
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
			return customer.UnfinishedOrderInquiry(userid);
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
	 * 查询个人信用
	 * @param userid
	 * @return 个人信用信息
	 */
	public int[] IndividualCredictInquiry(String userid){
		try {
			int[] result= {customer.IndividualCredictInquiry(userid),0};
			return result;
		} catch (RemoteException e) {
			int[] result={-1,-1};
			return result;
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
	 * 删除个人订单
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


	
			
}
