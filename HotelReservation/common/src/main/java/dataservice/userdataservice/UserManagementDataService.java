package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CustomerInfoPO;
import po.StuffInfoPO;
import po.UserInfoPO;
import util.ResultMsg;

/**
 * �û���Ϣ����
 * @author �ܳ�
 *
 */
public interface UserManagementDataService extends Remote{
        
		
		/**
		 * ��ȡ����
		 * @param ��¼��ϢPO
		 * @return ����
		 * @throws RemoteException 
		 */
		public String getLoginInfo(String userid) throws RemoteException;
		
		/**
		 * ע����������
		 * @param ��¼��ϢPO
		 * @return �˺�
		 */
		public String addWebStuff(UserInfoPO po) throws RemoteException;
		
		public String addWebManager(UserInfoPO po) throws RemoteException;
		
		public String addCustomer(CustomerInfoPO po) throws RemoteException;
		
		public String addHotelStuff(StuffInfoPO po) throws RemoteException;
		/**
		 * ��ȡ�����û�����Ϣ
		 * @param �û�IDPO
		 * @return �û�������Ϣ
		 */
		public StuffInfoPO getHotelStuffInfo(String userid) throws RemoteException;
		
		public UserInfoPO getWebManagerInfo(String userid) throws RemoteException;
		
		public UserInfoPO getWebStuffInfo(String userid) throws RemoteException;
		
		public CustomerInfoPO getCustomerInfo(String userid) throws RemoteException;
		
		
		
		/**
		 * ���������û�������Ϣ
		 * @param �û�IDPO
		 * @param �û���ϢPO
		 * @return ���ý��
		 */
        public ResultMsg setHotelStuffInfo(String userid,StuffInfoPO po) throws RemoteException;
		
		public ResultMsg setWebManagerInfo(String userid,UserInfoPO po) throws RemoteException;
		
		public ResultMsg setWebStuffInfo(String userid,UserInfoPO po2) throws RemoteException;
		
		public ResultMsg setCustomerInfo(String userid,CustomerInfoPO po) throws RemoteException;
		
		
		
		/**
		 * �����վӪ����Ա����
		 * @return
		 */
		public ArrayList<UserInfoPO> webStuffScan() throws RemoteException;
		
		
		
		/**
		 * �鿴�Ƶ������Ա��Ϣ
		 * @return
		 */
		public ArrayList<StuffInfoPO> hotelStuffScan() throws RemoteException;
}