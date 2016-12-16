package data.userdata;

import java.rmi.RemoteException;

import dataSuper.DataSuperClass;
import po.ContactPO;
import util.ResultMsg;

public class ContactPOData extends DataSuperClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String tableName = "contact";
	
	public ContactPOData() throws RemoteException {
		super();
	}
	
	public ResultMsg addToSQL(ContactPO po) {
		return addToSQL(tableName, po.getPhoneNumber(), po.getEmailAddress());
	}
	
	//不知道要通过什么来查找contectPO
	/*
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
	*/
}
