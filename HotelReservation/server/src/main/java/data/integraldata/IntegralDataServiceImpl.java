package data.integraldata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.integraldataservice.IntegralDataService;
import po.IntegralPO;

public class IntegralDataServiceImpl implements IntegralDataService{

	@Override
	public boolean insert(IntegralPO integral) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(IntegralPO integral) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(IntegralPO Integral) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
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
