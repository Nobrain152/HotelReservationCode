package dataservice.userdataservice;

import po.LoginInPO;
import po.UserInfoPO;

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
		public String GetLoginInfo(LoginInPO po);
		
		/**
		 * ע��
		 * @param ��¼��ϢPO
		 * @return �˺�
		 */
		public String AddUser(LoginInPO po);
		
		/**
		 * h��ȡ�û�������Ϣ
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
		public boolean SetUserBaseInfo(String userid,UserInfoPO po2);
		
}