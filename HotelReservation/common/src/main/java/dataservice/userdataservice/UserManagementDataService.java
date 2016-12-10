package dataservice.userdataservice;

import java.util.ArrayList;

import po.CustomerInfoPO;
import po.StuffInfoPO;
import po.UserInfoPO;
import util.ResultMsg;

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
		public String GetLoginInfo(String userid);
		
		/**
		 * 注册的四种情况
		 * @param 登录信息PO
		 * @return 账号
		 */
		public String AddWebStuff(UserInfoPO po);
		
		public String AddWebManager(UserInfoPO po);
		
		public String AddCustomer(CustomerInfoPO po);
		
		public String AddHotelStuff(StuffInfoPO po);
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
		public ResultMsg SetUserBaseInfo(String userid,UserInfoPO po2);
		
		/**
		 * 增加酒店工作人员
		 * @param hotelid
		 * @param userid
		 * @return
		 */
		public boolean addHotelStuff(String hotelid,String userid);
		
		/**
		 * 增加网站营销人员
		 * @param userid
		 * @return
		 */
		public boolean addWebStuff(String userid);
		
		
		/**
		 * 浏览网站营销人员名单
		 * @return
		 */
		public ArrayList<UserInfoPO> WebStuffScan();
		
		/**
		 * 查找酒店管理人员信息
		 * @param userid
		 * @return
		 */
		public StuffInfoPO FindStuffInfo(String userid);
		
		/**
		 * 修改酒店管理人员信息
		 * @param userid
		 * @param po
		 * @return
		 */
		public boolean ModStuffInfo(String userid,StuffInfoPO po);
		
		
}