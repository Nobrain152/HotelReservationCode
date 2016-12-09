package data.userdata;

import java.rmi.RemoteException;

import dataSuper.DataSuperClass;
import po.HotelInfoPO;
import po.LoginInPO;
import util.ResultMsg;

public class LoginInpoData extends DataSuperClass{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String tableName = "loginIn";
	
	public LoginInpoData() throws RemoteException {
		super();
	}
	
	public ResultMsg addToSQL(LoginInPO po) {
		return addToSQL(tableName, po.getUsername(), po.getPassword());
	}
	
	public LoginInPO findLoginPO(String userID) {
		LoginInPO po = findMes(userID);
		return po;
	}
	
	public LoginInPO findMes(String userID){
		findMes = findFromSQL(tableName,userID);
		LoginInPO po = null;
		
		if(findMes != null){
			po = new LoginInPO(findMes.get(0), findMes.get(1));
		}
		return po;
	}
	
}
