package dataservice.userdataservice;

import java.util.ArrayList;

import po.UserIDPO;
import util.ResultMsg;

/**
 * 客户信息数据管理
 * @author 曹畅
 *
 */
public interface CustomerManagementDataService{
        
		/**
		 * 增加会员
		 * @param 会员ID
		 * @return 增加结果
		 */
		public ResultMsg AddMembers(UserIDPO po);
		
		/**
		 * 获取用户订单ID列表
		 * @param 用户ID
		 * @return 订单ID列表 
		 */
		public ArrayList<String> GetCustomerOrders(UserIDPO po);
		
		/**
		 * 更新订单
		 * @param 用户ID
		 * @param 订单VO
		 * @return 更新结果
		 */
		public ResultMsg addCustomerOrders(UserIDPO po,String i);
		
		/**
		 * 获取用户预定过的酒店ID
		 * @param 用户ID
		 * @return 用户预定过的酒店ID列表
		 */
		public ArrayList<String> GetCustomerHotel(UserIDPO po);
		
		/**
		 * 增加用户居住过的酒店信息
		 * @param 用户ID
		 * @param 酒店信息
		 * @return 更新结果
		 */
		public ResultMsg addCustomerHotel (UserIDPO po,String idh);
		
		
		
}