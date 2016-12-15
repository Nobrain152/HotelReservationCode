package data.userdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import dataservice.userdataservice.CustomerManagementDataService;
import po.CustomerInfoPO;
import po.StuffInfoPO;
import po.UserInfoPO;
import util.ResultMsg;
import util.UserType;

public class CustomerManagementDataServiceImpl extends UserManagementDataServiceImpl implements CustomerManagementDataService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String tableName = "user-hotel";
	
	public CustomerManagementDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<String> GetCustomerOrders(String userid) {
		try {
			sql = "SELECT * FROM order WHERE customerInfoPO = \'" + userid + "\'" ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				if(result.getString(5).equals(UserType.WebStuff.toString())){
					findMes.add(result.getString(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("从数据库中获取所有的webStuff信息错误");
			return null;
		}
		
		return findMes.size()==0?null:findMes;
	}

	@Override
	public ResultMsg addCustomerOrders(String userid, String i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> GetCustomerHotel(String userid) {
		try {
			sql = "SELECT * FROM " + tableName + " WHERE userID = \'" + userid + "\'" ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				if(result.getString(5).equals(UserType.WebStuff.toString())){
					findMes.add(result.getString(2));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("从数据库中获取所有的webStuff信息错误");
			return null;
		}
		
		return findMes.size()==0?null:findMes;
	}

	@Override
	public ResultMsg addCustomerHotel(String userid, String idh) {
		return addToSQL(tableName, userid,idh);
	}

	

}
