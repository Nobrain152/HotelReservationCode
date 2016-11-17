package dataservice.userdataservice;

import po.LoginInputPO;
import po.UserIDPO;
import po.UserInfoPO;

/**
 * 用户信息管理
 * @author 曹畅
 *
 */
public interface UserManagementDataService{
        
		
		/**
		 * 获取密码
		 * @param 登录信息PO
		 * @return 密码
		 */
		public String GetLoginInfo(LoginInputPO po);
		
		/**
		 * 注册
		 * @param 登录信息PO
		 * @return 账号
		 */
		public String AddUser(LoginInputPO po);
		
		/**
		 * h获取用户基本信息
		 * @param 用户IDPO
		 * @return 用户基本信息
		 */
		public UserInfoPO GetUserBaseInfo(UserIDPO po);
		
		/**
		 * 设置用户基本信息
		 * @param 用户IDPO
		 * @param 用户信息PO
		 * @return 设置结果
		 */
		public boolean SetUserBaseInfo(UserIDPO po1,UserInfoPO po2);
		
}