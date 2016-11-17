package dataservice.userdataservice;

import po.LoginInputPO;
import po.UserIDPO;
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
		public String GetLoginInfo(LoginInputPO po);
		
		/**
		 * ע��
		 * @param ��¼��ϢPO
		 * @return �˺�
		 */
		public String AddUser(LoginInputPO po);
		
		/**
		 * h��ȡ�û�������Ϣ
		 * @param �û�IDPO
		 * @return �û�������Ϣ
		 */
		public UserInfoPO GetUserBaseInfo(UserIDPO po);
		
		/**
		 * �����û�������Ϣ
		 * @param �û�IDPO
		 * @param �û���ϢPO
		 * @return ���ý��
		 */
		public boolean SetUserBaseInfo(UserIDPO po1,UserInfoPO po2);
		
}