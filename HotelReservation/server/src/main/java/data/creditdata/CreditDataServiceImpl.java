package data.creditdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;
import util.ResultMsg;

public class CreditDataServiceImpl implements CreditDataService{

	@Override
	public ResultMsg insert(CreditPO integral) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
	}

	@Override
	public ResultMsg delete(CreditPO integral) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
	}

	@Override
	public ResultMsg update(CreditPO Integral) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
	}

	@Override
	public CreditPO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CreditPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
