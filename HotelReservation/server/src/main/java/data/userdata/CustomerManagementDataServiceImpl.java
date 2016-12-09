package data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.userdataservice.CustomerManagementDataService;
import po.CustomerInfoPO;

public class CustomerManagementDataServiceImpl extends UserManagementDataServiceImpl implements CustomerManagementDataService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomerManagementDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public boolean AddMembers(String userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> GetCustomerOrders(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCustomerOrders(String userid, String i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> GetCustomerHotel(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCustomerHotel(String userid, String idh) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CustomerInfoPO FindByID(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
