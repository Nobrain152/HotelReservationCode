package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
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
public interface UserManagementDataService extends Remote{
        
		
		/**
		 * 获取密码
		 * @param 登录信息PO
		 * @return 密码
		 * @throws RemoteException 
		 */
		public String GetLoginInfo(String userid) throws RemoteException;
		
		/**
		 * 注册的四种情况
		 * @param 登录信息PO
		 * @return 账号
		 */
		public String AddWebStuff(UserInfoPO po) throws RemoteException;
		
		public String AddWebManager(UserInfoPO po) throws RemoteException;
		
		public String AddCustomer(CustomerInfoPO po) throws RemoteException;
		
		public String AddHotelStuff(StuffInfoPO po) throws RemoteException;
		/**
		 * 获取四种用户的信息
		 * @param 用户IDPO
		 * @return 用户基本信息
		 */
		public StuffInfoPO GetHotelStuffInfo(String userid) throws RemoteException;
		
		public UserInfoPO GetWebManagerInfo(String userid) throws RemoteException;
		
		public UserInfoPO GetWebStuffInfo(String userid) throws RemoteException;
		
		public CustomerInfoPO GetCustomerInfo(String userid) throws RemoteException;
		
		
		
		/**
		 * 设置四种用户基本信息
		 * @param 用户IDPO
		 * @param 用户信息PO
		 * @return 设置结果
		 */
        public ResultMsg SetHotelStuffInfo(String userid,StuffInfoPO po) throws RemoteException;
		
		public ResultMsg SetWebManagerInfo(String userid,UserInfoPO po) throws RemoteException;
		
		public ResultMsg SetWebStuffInfo(String userid,UserInfoPO po2) throws RemoteException;
		
		public ResultMsg SetCustomerInfo(String userid,CustomerInfoPO po) throws RemoteException;
		/**
		 * 增加酒店工作人员
		 * @param hotelid
		 * @param userid
		 * @return
		 */
		public ResultMsg addHotelStuff(String hotelid,String userid) throws RemoteException;
		
		
		/**
		 * 浏览网站营销人员名单
		 * @return
		 */
		public ArrayList<UserInfoPO> WebStuffScan() throws RemoteException;
		
		
		
		/**
		 * 查看酒店管理人员信息
		 * @return
		 */
		public ArrayList<StuffInfoPO> HotelStuffScan() throws RemoteException;
}