package data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataSuper.DataSuperClass;
import dataservice.userdataservice.UserManagementDataService;
import po.LoginInPO;
import po.UserInfoPO;
import util.ResultMsg;

public class UserManagementDataServiceImpl extends DataSuperClass implements UserManagementDataService {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static String tableName = "userInfo";
	
	public UserManagementDataServiceImpl() throws RemoteException {
		super();
	}

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
		UserInfoPO po = findMes(userid);
		return null;
	}
	
	public UserInfoPO findMes(String userID){
		findMes = findFromSQL(tableName, userID);
		UserInfoPO po = null;
		if(findMes != null){
			/*po = new UserInfoPO(findMes.get(0),findMes.get(1),
							findMes.get(2));*/
		}
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