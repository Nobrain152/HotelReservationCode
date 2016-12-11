package dataservice.userdataservice;

import java.rmi.Remote;
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
		 */
		public String GetLoginInfo(String userid);
		
		/**
		 * ע����������
		 * @param ��¼��ϢPO
		 * @return �˺�
		 */
		public String AddWebStuff(UserInfoPO po);
		
		public String AddWebManager(UserInfoPO po);
		
		public String AddCustomer(CustomerInfoPO po);
		
		public String AddHotelStuff(StuffInfoPO po);
		/**
		 * ��ȡ�����û�����Ϣ
		 * @param �û�IDPO
		 * @return �û�������Ϣ
		 */
		public StuffInfoPO GetHotelStuffInfo(String userid);
		
		public UserInfoPO GetWebManagerInfo(String userid);
		
		public UserInfoPO GetWebStuffInfo(String userid);
		
		public CustomerInfoPO GetCustomerInfo(String userid);
		
		
		
		/**
		 * ���������û�������Ϣ
		 * @param �û�IDPO
		 * @param �û���ϢPO
		 * @return ���ý��
		 */
        public ResultMsg SetHotelStuffInfo(String userid,StuffInfoPO po);
		
		public ResultMsg SetWebManagerInfo(String userid,UserInfoPO po);
		
		public ResultMsg SetWebStuffInfo(String userid,UserInfoPO po2);
		
		public ResultMsg SetCustomerInfo(String userid,CustomerInfoPO po);
		/**
		 * ���ӾƵ깤����Ա
		 * @param hotelid
		 * @param userid
		 * @return
		 */
		public ResultMsg addHotelStuff(String hotelid,String userid);
		
		
		/**
		 * �����վӪ����Ա����
		 * @return
		 */
		public ArrayList<UserInfoPO> WebStuffScan();
		
		
		
		/**
		 * �鿴�Ƶ������Ա��Ϣ
		 * @return
		 */
		public ArrayList<StuffInfoPO> HotelStuffScan();
}