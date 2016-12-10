package dataservice.userdataservice;

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
public interface UserManagementDataService{
        
		
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
		 * ��ȡ�û�������Ϣ
		 * @param �û�IDPO
		 * @return �û�������Ϣ
		 */
		public UserInfoPO GetUserBaseInfo(String userid);
		
		/**
		 * �����û�������Ϣ
		 * @param �û�IDPO
		 * @param �û���ϢPO
		 * @return ���ý��
		 */
		public ResultMsg SetUserBaseInfo(String userid,UserInfoPO po2);
		
		/**
		 * ���ӾƵ깤����Ա
		 * @param hotelid
		 * @param userid
		 * @return
		 */
		public boolean addHotelStuff(String hotelid,String userid);
		
		/**
		 * ������վӪ����Ա
		 * @param userid
		 * @return
		 */
		public boolean addWebStuff(String userid);
		
		
		/**
		 * �����վӪ����Ա����
		 * @return
		 */
		public ArrayList<UserInfoPO> WebStuffScan();
		
		/**
		 * ���ҾƵ������Ա��Ϣ
		 * @param userid
		 * @return
		 */
		public StuffInfoPO FindStuffInfo(String userid);
		
		/**
		 * �޸ľƵ������Ա��Ϣ
		 * @param userid
		 * @param po
		 * @return
		 */
		public boolean ModStuffInfo(String userid,StuffInfoPO po);
		
		
}