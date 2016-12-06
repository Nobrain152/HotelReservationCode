package data.userdata;

import java.util.ArrayList;


import dataservice.userdataservice.UserManagementDataService;
import po.LoginInPO;
import po.StuffInfoPO;
import po.UserInfoPO;
import util.ResultMsg;

public class UserManagementDataServiceImpl implements UserManagementDataService {

	@Override
	public String GetLoginInfo(LoginInPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String AddUser(LoginInPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoPO GetUserBaseInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg SetUserBaseInfo(String userid, UserInfoPO po2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addHotelStuff(String hotelid, String userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addWebStuff(String userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<UserInfoPO> WebStuffScan() {
		// TODO Auto-generated method stub
		return null;
	}

	

}	