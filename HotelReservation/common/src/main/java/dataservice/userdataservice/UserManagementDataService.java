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
		public String GetLoginInfo(String userid) throws RemoteException;
		
		/**
		 * ע����������
		 * @param ��¼��ϢPO
		 * @return �˺�
		 */
		public String AddWebStuff(UserInfoPO po) throws RemoteException;
		
		public String AddWebManager(UserInfoPO po) throws RemoteException;
		
		public String AddCustomer(CustomerInfoPO po) throws RemoteException;
		
		public String AddHotelStuff(StuffInfoPO po) throws RemoteException;
		/**
		 * ��ȡ�����û�����Ϣ
		 * @param �û�IDPO
		 * @return �û�������Ϣ
		 */
		public StuffInfoPO GetHotelStuffInfo(String userid) throws RemoteException;
		
		public UserInfoPO GetWebManagerInfo(String userid) throws RemoteException;
		
		public UserInfoPO GetWebStuffInfo(String userid) throws RemoteException;
		
		public CustomerInfoPO GetCustomerInfo(String userid) throws RemoteException;
		
		
		
		/**
		 * ���������û�������Ϣ
		 * @param �û�IDPO
		 * @param �û���ϢPO
		 * @return ���ý��
		 */
        public ResultMsg SetHotelStuffInfo(String userid,StuffInfoPO po) throws RemoteException;
		
		public ResultMsg SetWebManagerInfo(String userid,UserInfoPO po) throws RemoteException;
		
		public ResultMsg SetWebStuffInfo(String userid,UserInfoPO po2) throws RemoteException;
		
		public ResultMsg SetCustomerInfo(String userid,CustomerInfoPO po) throws RemoteException;
		/**
		 * ���ӾƵ깤����Ա
		 * @param hotelid
		 * @param userid
		 * @return
		 */
		public ResultMsg addHotelStuff(String hotelid,String userid) throws RemoteException;
		
		
		/**
		 * �����վӪ����Ա����
		 * @return
		 */
		public ArrayList<UserInfoPO> WebStuffScan() throws RemoteException;
		
		
		
		/**
		 * �鿴�Ƶ������Ա��Ϣ
		 * @return
		 */
		public ArrayList<StuffInfoPO> HotelStuffScan() throws RemoteException;
}