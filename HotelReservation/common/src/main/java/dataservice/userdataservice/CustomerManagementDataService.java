package dataservice.userdataservice;

import java.util.ArrayList;



/**
 * �ͻ���Ϣ���ݹ���
 * @author �ܳ�
 *
 */
public interface CustomerManagementDataService extends UserManagementDataService{
        
		
		
		/**
		 * ���ӻ�Ա
		 * @param ��ԱID
		 * @return ���ӽ��
		 */
		public boolean AddMembers(String userid);
		
		/**
		 * ��ȡ�û�����ID�б�
		 * @param �û�ID
		 * @return ����ID�б� 
		 */
		public ArrayList<String> GetCustomerOrders(String userid);
		
		/**
		 * ���¶���
		 * @param �û�ID
		 * @param ����VO
		 * @return ���½��
		 */
		public boolean addCustomerOrders(String userid,String i);
		
		/**
		 * ��ȡ�û�Ԥ�����ľƵ�ID
		 * @param �û�ID
		 * @return �û�Ԥ�����ľƵ�ID�б�
		 */
		public ArrayList<String> GetCustomerHotel(String userid);
		
		/**
		 * �����û���ס���ľƵ���Ϣ
		 * @param �û�ID
		 * @param �Ƶ���Ϣ
		 * @return ���½��
		 */
		public boolean addCustomerHotel (String userid,String idh);
		
		
		
}