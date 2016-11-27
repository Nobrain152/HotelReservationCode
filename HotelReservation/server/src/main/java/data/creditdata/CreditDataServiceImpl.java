package data.creditdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;
import util.ResultMsg;

public class CreditDataServiceImpl implements CreditDataService{

	@Override
	public ResultMsg insert(CreditPO creditPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CreditPO> findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditPO findByID(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CreditPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
