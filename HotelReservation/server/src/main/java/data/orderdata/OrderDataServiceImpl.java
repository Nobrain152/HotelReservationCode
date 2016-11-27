package data.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import util.ResultMsg;

public class OrderDataServiceImpl implements OrderDataService{

	@Override
	public ResultMsg insert(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg delete(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderPO findByOrderID(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderPO> findByUserID(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderPO> findByHotelID(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderPO> showList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
}

