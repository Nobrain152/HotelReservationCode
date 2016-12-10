package dataservice.userdataservice;

import java.util.ArrayList;


import util.ResultMsg;



/**
 * �ͻ���Ϣ���ݹ���
 * @author �ܳ�
 *
 */
public interface CustomerManagementDataService extends UserManagementDataService{
        
		
		
		
		
		/**
		 * ��ȡ�û�����ID�б�
		 * @param �û�ID
		 * @return ����ID�б� 
		 */
		public ArrayList<String> GetCustomerOrders(String userid);
		
		/**
		 * ���¶���
		 * @param �û�ID
		 * @param ����ID
		 * @return ���½��
		 */
		public ResultMsg addCustomerOrders(String userid,String i);
		
		/**
		 * ��ȡ�û�Ԥ�����ľƵ�ID
		 * @param �û�ID
		 * @return �û�Ԥ�����ľƵ�ID�б�
		 */
		public ArrayList<String> GetCustomerHotel(String userid);
		
		/**
		 * �����û���ס���ľƵ���Ϣ
		 * @param �û�ID
		 * @param �Ƶ�ID
		 * @return ���½��
		 */
		public ResultMsg addCustomerHotel (String userid,String idh);
		
		
		
		
		
}