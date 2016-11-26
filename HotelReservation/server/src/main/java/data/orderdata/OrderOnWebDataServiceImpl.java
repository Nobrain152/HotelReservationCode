package data.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.orderdataservice.OrderOnWebDataService;
import po.OrderOnWebPO;
import util.ResultMsg;

public class OrderOnWebDataServiceImpl implements OrderOnWebDataService{

	ArrayList<OrderOnWebPO> webPOs;
	
	public OrderOnWebDataServiceImpl(){
		webPOs = new ArrayList<OrderOnWebPO>();
	}
	
	
	/**
	 * 在数据库中插入单一持久化对象
	 */
	public ResultMsg insert(OrderOnWebPO po) throws RemoteException{
		if(webPOs.add(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	
	/**
	 * 在数据库中删除单一持久化对象
	 */
	public ResultMsg delete(OrderOnWebPO po) throws RemoteException{
		if(webPOs.remove(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	
	/**
	 * 在数据库中更新单一持久化对象
	 */
	public ResultMsg update(OrderOnWebPO po) throws RemoteException{
		for (OrderOnWebPO op : webPOs) {
			if(op.getInitiator() == po.getInitiator()){
				op = po;
				return ResultMsg.SUCCESS;
			}
		}
		return ResultMsg.FAIL;
	}

	@Override
	public ArrayList<OrderOnWebPO> findByName(String name) throws RemoteException {
		ArrayList<OrderOnWebPO> arrayList = new ArrayList<OrderOnWebPO>();
		for (OrderOnWebPO op : webPOs) {
			if(op.getInitiator().getName().equals(name)){
				arrayList.add(op);
			}
		}
		return arrayList;
	}


	@Override
	public OrderOnWebPO findByID(String ID) throws RemoteException {
		OrderOnWebPO webPO = null;
		for (OrderOnWebPO op : webPOs) {
			if(op.getInitiator().getName().equals(ID)){
				webPO = op;
			}
		}
		return webPO;
	}


	@Override
	public ArrayList<OrderOnWebPO> getComplaintList() throws RemoteException {
		return webPOs;
	}


	@Override
	public ArrayList<OrderOnWebPO> getAbnormalList() throws RemoteException {
		return webPOs;
	}
	
}
