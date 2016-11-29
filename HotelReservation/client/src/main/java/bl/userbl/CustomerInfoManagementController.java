package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.CustomerIndividualInformationManagementBLService;
import dataservice.userdataservice.CustomerManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import vo.CreditVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.UserInfoVO;
import vo.VipVO;

public class CustomerInfoManagementController
		implements CustomerIndividualInformationManagementBLService {
	
	private Customer customer;
	private CustomerManagementDataService customerManagementDataService;
	
	/**
	 * ���췽��
	 * @param �û�ID
	 */
	public CustomerInfoManagementController(){
		customerManagementDataService = (CustomerManagementDataService)RMIManage.
				getDataService(DataServiceType.CustomerManagementDataService);
		customer=new Customer(customerManagementDataService);
	}
	
	
	/**
	 * ��ѯ���˻�����Ϣ
	 * @param userid
	 * @return ���˻�����Ϣ
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
		try {
			return customer.IndividualBaseInfolnquiry(userid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
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
	public boolean IndividualBaseInfoModification(String userid,CustomerInfoVO vo2){
		try {
			return customer.IndividualBaseInfoModification(userid, vo2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
			
	/**
	 * ��ѯ��������
	 * @param userid
	 * @return ����������Ϣ
	 */
	public CreditVO IndividualCredictInquiry(String userid){
		try {
			return 	customer.IndividualCredictInquiry(userid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public void HotelMemberRegisterApply(String hotelID, VipVO vo2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void WebMemberRegisterApply(VipVO vo2) {
		// TODO Auto-generated method stub
		
	}
			
}
