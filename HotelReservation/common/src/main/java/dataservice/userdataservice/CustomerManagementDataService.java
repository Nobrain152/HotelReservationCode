package dataservice.userdataservice;

import java.util.ArrayList;


import util.ResultMsg;



/**
 * 客户信息数据管理
 * @author 曹畅
 *
 */
public interface CustomerManagementDataService extends UserManagementDataService{
        
		
		
		
		
		/**
		 * 获取用户订单ID列表
		 * @param 用户ID
		 * @return 订单ID列表 
		 */
		public ArrayList<String> GetCustomerOrders(String userid);
		
		/**
		 * 更新订单
		 * @param 用户ID
		 * @param 订单ID
		 * @return 更新结果
		 */
		public ResultMsg addCustomerOrders(String userid,String i);
		
		/**
		 * 获取用户预定过的酒店ID
		 * @param 用户ID
		 * @return 用户预定过的酒店ID列表
		 */
		public ArrayList<String> GetCustomerHotel(String userid);
		
		/**
		 * 增加用户居住过的酒店信息
		 * @param 用户ID
		 * @param 酒店ID
		 * @return 更新结果
		 */
		public ResultMsg addCustomerHotel (String userid,String idh);
		
		
		
		
		
}