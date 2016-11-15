package dataservice.userdataservice;

import vo.LoginInputVO;
import vo.UserIDVO;
import vo.UserInfoVO;

/**
 * 用户信息管理
 * @author 曹畅
 *
 */
public interface UserManagementDataService{
        
		
		/**
		 * 获取密码
		 * @param 登录信息VO
		 * @return 密码
		 */
		public String GetLoginInfo(LoginInputVO vo);
		
		/**
		 * 注册
		 * @param 登录信息VO
		 * @return 账号
		 */
		public String AddUser(LoginInputVO vo);
		
		/**
		 * h获取用户基本信息
		 * @param 用户IDVO
		 * @return 用户基本信息
		 */
		public UserInfoVO GetUserBaseInfo(UserIDVO vo);
		
		/**
		 * 设置用户基本信息
		 * @param 用户IDVO
		 * @param 用户信息VO
		 * @return 设置结果
		 */
		public boolean SetUserBaseInfo(UserIDVO vo1,UserInfoVO vo2);
		
}