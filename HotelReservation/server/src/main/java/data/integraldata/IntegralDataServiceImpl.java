package data.integraldata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.integraldataservice.IntegralDataService;
import po.IntegralPO;
import util.ResultMsg;

public class IntegralDataServiceImpl implements IntegralDataService{

	@Override
	public ResultMsg insert(IntegralPO integral) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
	}

	@Override
	public ResultMsg delete(IntegralPO integral) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
	}

	@Override
	public ResultMsg update(IntegralPO Integral) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
	}

	@Override
	public IntegralPO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<IntegralPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
