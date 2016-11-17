package dataservice.userdataservice;

import java.util.ArrayList;

import po.UserIDPO;

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
		public boolean AddMembers(UserIDPO po);
		
		/**
		 * ��ȡ�û�����ID�б�
		 * @param �û�ID
		 * @return ����ID�б� 
		 */
		public ArrayList<String> GetCustomerOrders(UserIDPO po);
		
		/**
		 * ���¶���
		 * @param �û�ID
		 * @param ����VO
		 * @return ���½��
		 */
		public boolean addCustomerOrders(UserIDPO po,String i);
		
		/**
		 * ��ȡ�û�Ԥ�����ľƵ�ID
		 * @param �û�ID
		 * @return �û�Ԥ�����ľƵ�ID�б�
		 */
		public ArrayList<String> GetCustomerHotel(UserIDPO po);
		
		/**
		 * �����û���ס���ľƵ���Ϣ
		 * @param �û�ID
		 * @param �Ƶ���Ϣ
		 * @return ���½��
		 */
		public boolean addCustomerHotel (UserIDPO po,String idh);
		
		
		
}