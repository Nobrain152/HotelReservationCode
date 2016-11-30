package dataservice.userdataservice;

import java.util.ArrayList;

import po.LoginInPO;
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
		public String GetLoginInfo(LoginInPO po);
		
		/**
		 * 注册
		 * @param 登录信息PO
		 * @return 账号
		 */
		public String AddUser(LoginInPO po);
		
		/**
		 * 获取用户基本信息
		 * @param 用户IDPO
		 * @return 用户基本信息
		 */
		public UserInfoPO GetUserBaseInfo(String userid);
		
		/**
		 * 设置用户基本信息
		 * @param 用户IDPO
		 * @param 用户信息PO
		 * @return 设置结果
		 */
		public boolean SetUserBaseInfo(String userid,UserInfoPO po2);
		
		public boolean addHotelStuff(String hotelid,String userid);
		
		public boolean addWebStuff(String userid);
		
		public ArrayList<UserInfoPO> WebStuffScan();
		
		
		
}