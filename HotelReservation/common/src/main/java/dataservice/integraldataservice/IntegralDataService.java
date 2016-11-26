package dataservice.integraldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.IntegralPO;
import util.ResultMsg;



public interface IntegralDataService {
	public ResultMsg insert(IntegralPO integral) throws RemoteException;
	
	public ResultMsg delete(IntegralPO integral) throws RemoteException;
	
	public ResultMsg update(IntegralPO Integral) throws RemoteException;
	
	public IntegralPO findByName(String name) throws RemoteException;
	
	public ArrayList<IntegralPO> show() throws RemoteException;
}
