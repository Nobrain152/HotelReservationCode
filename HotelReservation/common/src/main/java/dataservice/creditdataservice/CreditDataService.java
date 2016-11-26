package dataservice.creditdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CreditPO;
import util.ResultMsg;



public interface CreditDataService {
	public ResultMsg insert(CreditPO integral) throws RemoteException;
	
	public ResultMsg delete(CreditPO integral) throws RemoteException;
	
	public ResultMsg update(CreditPO Integral) throws RemoteException;
	
	public CreditPO findByName(String name) throws RemoteException;
	
	public ArrayList<CreditPO> show() throws RemoteException;
}
