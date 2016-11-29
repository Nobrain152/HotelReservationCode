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
