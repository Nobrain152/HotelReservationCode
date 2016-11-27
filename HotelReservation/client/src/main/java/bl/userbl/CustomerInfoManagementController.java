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
	 * ���췽��
	 * @param �û�ID
	 */
	public CustomerInfoManagementController(String userid){
		customer=new Customer(userid);
		
	}
	
	
	/**
	 * ��ѯ���˻�����Ϣ
	 * @param userid
	 * @return ���˻�����Ϣ
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
		return customer.IndividualBaseInfolnquiry(userid);
	}
			
	/**
	 * �޸ĸ��˻�����Ϣ
	 * @param userid
	 * @param �ͻ�������Ϣ
	 * @return �޸Ľ��
	 */
	public boolean IndividualBaseInfoModification(String userid,CustomerInfoVO vo2){
		return customer.IndividualBaseInfoModification(userid, vo2);
	}
			
	/**
	 * ��ѯ���˶�����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid){
		return customer.IndividualOrderInquiry(userid);
	}
			
	/**
	 * ��ѯ���˾Ƶ���Ϣ
	 * @param userid
	 * @return ���˾Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(String userid){
		return customer.IndividualHotelInquiry(userid);
	}
			
	/**
	 * ��ѯ��������
	 * @param userid
	 * @return ����������Ϣ
	 */
	public CreditVO IndividualCredictInquiry(String userid){
		return 	customer.IndividualCredictInquiry(userid);
	}
			
}
