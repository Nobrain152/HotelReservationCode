package dataservice.creditdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CreditPO;
import util.ResultMsg;


public interface CreditDataService {
	
	public ResultMsg insert(CreditPO creditPO) throws RemoteException;
	
	public ArrayList<CreditPO> findByName(String name) throws RemoteException;
	
	public CreditPO findByID(String name) throws RemoteException;
	
	public ArrayList<CreditPO> show() throws RemoteException;
	
}
