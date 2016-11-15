package dataservice.userdataservice;

import java.util.ArrayList;

import vo.HotelInfoVO;
import vo.OrderOnUserVO;
import vo.OrderVO;
import vo.UserIDVO;

/**
 * �ͻ���Ϣ���ݹ���
 * @author �ܳ�
 *
 */
public interface CustomerManagementDataService{
        
		
		
		/**
		 * ���ӻ�Ա
		 * @param ��ԱID
		 * @return ���ӽ��
		 */
		public boolean AddMembers(UserIDVO vo);
		
		/**
		 * ��ȡ�û�����ID�б�
		 * @param �û�ID
		 * @return ����ID�б� 
		 */
		public ArrayList<String> GetCustomerOrders(UserIDVO vo);
		
		/**
		 * ���¶���
		 * @param �û�ID
		 * @param ����VO
		 * @return ���½��
		 */
		public boolean addCustomerOrders(UserIDVO vo,String i);
		
		/**
		 * ��ȡ�û�Ԥ�����ľƵ�ID
		 * @param �û�ID
		 * @return �û�Ԥ�����ľƵ�ID�б�
		 */
		public ArrayList<String> GetCustomerHotel(UserIDVO vo);
		
		/**
		 * �����û���ס���ľƵ���Ϣ
		 * @param �û�ID
		 * @param �Ƶ���Ϣ
		 * @return ���½��
		 */
		public boolean addCustomerHotel (UserIDVO vo,String idh);
		
		
		
}