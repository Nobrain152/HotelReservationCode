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
 * �ͻ��Ը�����Ϣ�Ĳ���
 * @author �ܳ�
 *
 */
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
			return customer.UnfinishedOrderInquiry(userid);
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
	 * ��ѯ��������
	 * @param userid
	 * @return ����������Ϣ
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
	 * ɾ�����˶���
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
