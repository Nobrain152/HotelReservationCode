package data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.creatID.CreateID;
import dataSuper.DataSuperClass;
import dataservice.userdataservice.UserManagementDataService;
import po.CustomerInfoPO;
import po.LoginInPO;
import po.StuffInfoPO;
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
	public String GetLoginInfo(String userid) throws RemoteException {
		LoginInpoData login = new LoginInpoData();
		LoginInPO po =login.findLoginPO(userid);
		return po.getPassword();
	}
	
	@Override
	public String AddCustomer(CustomerInfoPO po) {
		ResultMsg bMsg = addToSQL(tableName, po.getHotelID(),po.getName(),
				po.getAddress().toString(),po.getArea().toString(),
				""+po.getLevel(),po.getIntroduction(),po.getFacility(),
				Boolean.toString(po.getIsReserved()),""+po.getScore(),""+po.getSP());
		if(bMsg == ResultMsg.SUCCESS){
			return CreateID.getCreateID().getNewCustomerID();
		}else{
			return null;
		}
	}
	
	@Override
	public String AddHotelStuff(StuffInfoPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String AddWebStuff(UserInfoPO po) throws RemoteException {
		String newID = CreateID.getCreateID().getNewWebStuffID();
		ResultMsg bMsg = addToSQL(tableName, newID,po.getUsername(),po.getPassword(),
									po.getContact(),po.getType().toString());
		if(bMsg == ResultMsg.SUCCESS){
			return newID;
		}else{
			return null;
		}
	}

	@Override
	public String AddWebManager(UserInfoPO po) throws RemoteException {
		String newID = CreateID.getCreateID().getNewWebManagerID();
		ResultMsg bMsg = addToSQL(tableName, newID,po.getUsername(),po.getPassword(),
									po.getContact(),po.getType().toString());
		if(bMsg == ResultMsg.SUCCESS){
			return newID;
		}else{
			return null;
		}
	}


	@Override
	public StuffInfoPO GetHotelStuffInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoPO GetWebManagerInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoPO GetWebStuffInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerInfoPO GetCustomerInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg SetHotelStuffInfo(String userid, StuffInfoPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg SetWebManagerInfo(String userid, UserInfoPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg SetWebStuffInfo(String userid, UserInfoPO po2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg SetCustomerInfo(String userid, CustomerInfoPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg addHotelStuff(String hotelid, String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserInfoPO> WebStuffScan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StuffInfoPO> HotelStuffScan() {
		// TODO Auto-generated method stub
		return null;
	}

	

}	