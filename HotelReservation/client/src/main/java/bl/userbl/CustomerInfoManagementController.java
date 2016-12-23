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
 * �ͻ��Ը�����Ϣ�Ĳ���
 * @author �ܳ�
 *
 */
public class CustomerInfoManagementController
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
	public CustomerInfoVO IndividualBaseInfolnquiry(String userid){
		try {
			return customer.IndividualBaseInfolnquiry(userid);
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
	public ResultMsg IndividualBaseInfoModification(String userid,CustomerInfoVO vo2){
		try {
			return customer.IndividualBaseInfoModification(userid, vo2);
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
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid){
		try {
			return customer.IndividualOrderInquiry(userid);
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
	public ArrayList<OrderVO> UnfinishedOrderInquiry(String userid){
		try {
			return customer.SpecialOrderInquiry(userid,OrderState.UNEXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ��ѯ������ִ�ж�����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> finishedOrderInquiry(String userid){
		try {
			return customer.SpecialOrderInquiry(userid,OrderState.EXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ��ѯ������������Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> CancelOrderInquiry(String userid){
		try {
			return customer.SpecialOrderInquiry(userid,OrderState.CANCELLED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ��ѯ�����쳣������Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> AbnormalOrderInquiry(String userid){
		try {
			return customer.SpecialOrderInquiry(userid,OrderState.ABNORMAL);
		} catch (RemoteException e) {
			return null;
		}
	}
			
	/**
	 * ��ѯ���˾Ƶ���Ϣ
	 * @param userid
	 * @return ���˾Ƶ���Ϣ�б�
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
	 * ��ѯ����δִ�оƵ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> UnfinishedHotelInquiry(String userid){
		try {
			return customer.SpecialHotelInquiry(userid,OrderState.UNEXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ��ѯ������ִ�оƵ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> finishedHotelInquiry(String userid){
		try {
			return customer.SpecialHotelInquiry(userid,OrderState.EXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ��ѯ�����쳣�Ƶ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> AbnormalHotelInquiry(String userid){
		try {
			return customer.SpecialHotelInquiry(userid,OrderState.ABNORMAL);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ��ѯ�������Ƶ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> CancelHotelInquiry(String userid){
		try {
			return customer.SpecialHotelInquiry(userid,OrderState.CANCELLED);
		} catch (RemoteException e) {
			return null;
		}
	}
			
	/**
	 * ��ѯ��������
	 * @param userid
	 * @return ����������Ϣ
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
	 * ��ѯ�������ü�¼
	 * @param userid
	 * @return ����������Ϣ
	 */
	public ArrayList<CreditVO> IndividualCredictRecord(String userid) {
		try {
			return customer.IndividualCredictRecord(userid);
		} catch (RemoteException e) {
			return null;
		}
	}


	/**
	 * �������˶���
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
