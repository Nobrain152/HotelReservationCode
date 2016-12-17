package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMsg;



/**
 * �ͻ���Ϣ���ݹ���
 * @author �ܳ�
 *
 */
public interface CustomerManagementDataService extends UserManagementDataService,Remote{
        
		
		
		
		
		/**
		 * ��ȡ�û�����ID�б�
		 * @param �û�ID
		 * @return ����ID�б� 
		 */
		public ArrayList<String> GetCustomerOrders(String userid) throws RemoteException;
		
		
		
		/**
		 * ��ȡ�û�Ԥ�����ľƵ�ID
		 * @param �û�ID
		 * @return �û�Ԥ�����ľƵ�ID�б�
		 */
		public ArrayList<String> GetCustomerHotel(String userid) throws RemoteException;
		
		/**
		 * �����û���ס���ľƵ���Ϣ
		 * @param �û�ID
		 * @param �Ƶ�ID
		 * @return ���½��
		 */
		public ResultMsg addCustomerHotel (String userid,String idh) throws RemoteException;
		
		
		
		
		
}