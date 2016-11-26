package data.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.orderdataservice.OrderOnUserDataService;
import po.OrderOnUserPO;
import util.ResultMsg;

public class OrderOnUserDataServiceImpl implements OrderOnUserDataService{

	ArrayList<OrderOnUserPO> userPOs;
	
	public OrderOnUserDataServiceImpl(){
		userPOs = new ArrayList<OrderOnUserPO>();
	}
	
	
	/**
	 * 在数据库中插入单一持久化对象
	 */
	public ResultMsg insert(OrderOnUserPO po) throws RemoteException{
		if(userPOs.add(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	
	/**
	 * 在数据库中删除单一持久化对象
	 */
	public ResultMsg delete(OrderOnUserPO po) throws RemoteException{
		if(userPOs.remove(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	
	/**
	 * 在数据库中更新单一持久化对象
	 */
	public ResultMsg update(OrderOnUserPO po) throws RemoteException{
		for (OrderOnUserPO op : userPOs) {
			if(op.getInitiator() == po.getInitiator()){
				op = po;
				return ResultMsg.SUCCESS;
			}
		}
		return ResultMsg.FAIL;
	}
	
	/**
	 * 返回所有酒店订单PO
	 */
	public ArrayList<OrderOnUserPO> show() throws RemoteException{
		return userPOs;
	}


	@Override
	public ArrayList<OrderOnUserPO> findByName(String name) throws RemoteException {
		ArrayList<OrderOnUserPO> arrayList = new ArrayList<OrderOnUserPO>();
		for (OrderOnUserPO op : userPOs) {
			if(op.getInitiator().getName().equals(name)){
				arrayList.add(op);
			}
		}
		return arrayList;
	}


	@Override
	public OrderOnUserPO findByID(String ID) throws RemoteException {
		OrderOnUserPO userPO = null;
		for (OrderOnUserPO op : userPOs) {
			if(op.getOrderID().equals(ID)){
				userPO = op;
			}
		}
		return userPO;
	}
	
}

