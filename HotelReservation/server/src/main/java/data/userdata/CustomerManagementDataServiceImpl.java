package data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.userdataservice.CustomerManagementDataService;
import po.CustomerInfoPO;
import po.StuffInfoPO;
import po.UserInfoPO;
import util.ResultMsg;

public class CustomerManagementDataServiceImpl extends UserManagementDataServiceImpl implements CustomerManagementDataService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomerManagementDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<String> GetCustomerOrders(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg addCustomerOrders(String userid, String i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> GetCustomerHotel(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg addCustomerHotel(String userid, String idh) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
