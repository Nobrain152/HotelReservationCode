package data.creditdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;
import util.ResultMsg;

public class CreditDataServiceImpl extends DataSuperClass implements CreditDataService{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tableName = "credit";
	
	public CreditDataServiceImpl() throws RemoteException{
		super();
	}
	
	
	
	@Override
	public ResultMsg insert(CreditPO creditPO) throws RemoteException {
		
		return null;
	}

	@Override
	public ArrayList<CreditPO> getListByUserID(String userID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditPO findByUserID(String userID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CreditPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditPO getListByOrderID(String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
