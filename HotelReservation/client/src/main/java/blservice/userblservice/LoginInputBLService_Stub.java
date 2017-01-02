package blservice.userblservice;

import util.UserType;
import vo.CustomerInfoVO;

public class LoginInputBLService_Stub implements LoginInputBLService{

	
	@Override
	public boolean logIn(String id, String password) {
		
		return true;
	}

	@Override
	public boolean logOut(boolean ok) {
		
		return true;
	}

	@Override
	public String register(CustomerInfoVO vo) {
		
		return "10000000";
	}

	@Override
	public UserType getType(String userid) {
		
		return UserType.Customer;
	}

}
