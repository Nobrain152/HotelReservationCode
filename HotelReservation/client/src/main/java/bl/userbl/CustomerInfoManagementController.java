package bl.userbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
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
 * �ͻ��Ը�����Ϣ�Ĳ���
 * @author �ܳ�
 *
 */
public class CustomerInfoManagementController extends BusinessController
		implements CustomerIndividualInformationManagementBLService {
	
	private Customer customer;
	private CustomerManagementDataService customerManagementDataService;
	private UserManagementDataService userManagementDataService;
	
	/**
	 * ���췽��
	 * @param �û�ID
	 */
	public CustomerInfoManagementController(){
		customerManagementDataService = (CustomerManagementDataService)RMIManage.
				getDataService(DataServiceType.CustomerManagementDataService);
		userManagementDataService = (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		customer=new Customer(customerManagementDataService);
	}
	
	
	/**
	 * ��ѯ���˻�����Ϣ
	 * @param userid
	 * @return ���˻�����Ϣ
	 */
	public CustomerInfoVO individualInfolnq(String userid){
		try {
			return customer.individualInfolnq(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	/**
	 * �޸ĸ��˻�����Ϣ
	 * @param userid
	 * @param �ͻ�������Ϣ
	 * @return �޸Ľ��
	 */
	public ResultMsg individualInfoMod(String userid,CustomerInfoVO vo2){
		try {
			return customer.individualInfoMod(userid, vo2);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMsg.FAIL;
		}
	}
			
	/**
	 * ��ѯ���˶�����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> individualOrderInq(String userid){
		try {
			return customer.individualOrderInq(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ��ѯ����δִ�ж�����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> unfinishedOrderInq(String userid){
		try {
			return customer.specialOrderInq(userid,OrderState.UNEXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ��ѯ������ִ�ж�����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> finishedOrderInq(String userid){
		try {
			return customer.specialOrderInq(userid,OrderState.EXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ��ѯ������������Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> cancelOrderInq(String userid){
		try {
			return customer.specialOrderInq(userid,OrderState.CANCELLED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ��ѯ�����쳣������Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> abnormalOrderInq(String userid){
		try {
			return customer.specialOrderInq(userid,OrderState.ABNORMAL);
		} catch (RemoteException e) {
			return null;
		}
	}
			
	/**
	 * ��ѯ���˾Ƶ���Ϣ
	 * @param userid
	 * @return ���˾Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> individualHotelInq(String userid){
		try {
			return customer.individualHotelInq(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ��ѯ����δִ�оƵ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> unfinishedHotelInq(String userid){
		try {
			return customer.specialHotelInq(userid,OrderState.UNEXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ��ѯ������ִ�оƵ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> finishedHotelInq(String userid){
		try {
			return customer.specialHotelInq(userid,OrderState.EXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ��ѯ�����쳣�Ƶ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> abnormalHotelInq(String userid){
		try {
			return customer.specialHotelInq(userid,OrderState.ABNORMAL);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ��ѯ�������Ƶ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> cancelHotelInq(String userid){
		try {
			return customer.specialHotelInq(userid,OrderState.CANCELLED);
		} catch (RemoteException e) {
			return null;
		}
	}
			
	/**
	 * ��ѯ��������
	 * @param userid
	 * @return ����������Ϣ
	 */
	public int individualCredictInq(String userid){
		try {
			int result= customer.individualCredictInq(userid);
			return result;
		} catch (RemoteException e) {
			return -1;
		}
	}


	/**
	 * ��ѯ�������ü�¼
	 * @param userid
	 * @return ����������Ϣ
	 */
	public ArrayList<CreditVO> individualCredictRecord(String userid) {
		try {
			return customer.individualCredictRecord(userid);
		} catch (RemoteException e) {
			return null;
		}
	}


	/**
	 * �������˶���
	 * @param orderVO
	 * @return
	 */
	public ResultMsg orderCancel(OrderVO orderVO){
		try {
			return customer.orderCancel(orderVO);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}


	@Override
	public CustomerInfoPO getCustomerInfo(String userID) {
		try {
			return userManagementDataService.getCustomerInfo(userID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void setCustomerInfo(String userID, CustomerInfoPO customerInfoPO) {
		try {
			userManagementDataService.setCustomerInfo(userID, customerInfoPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void reinitDataService(Remote dataService) {
		customerManagementDataService = (CustomerManagementDataService)dataService;
		customer = new Customer(customerManagementDataService);
	}


	
			
}
