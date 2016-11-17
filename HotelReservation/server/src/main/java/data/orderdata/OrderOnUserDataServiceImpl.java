package data.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderOnUserPO;
import util.User;

public class OrderOnUserDataServiceImpl {

	ArrayList<OrderOnUserPO> userPOs;
	
	public OrderOnUserDataServiceImpl(){
		userPOs = new ArrayList<>();
	}
	
	
	/**
	 * 在数据库中插入单一持久化对象
	 */
	public boolean insert(OrderOnUserPO po) throws RemoteException{
		if(userPOs.add(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * 在数据库中删除单一持久化对象
	 */
	public boolean delete(OrderOnUserPO po) throws RemoteException{
		if(userPOs.remove(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * 在数据库中更新单一持久化对象
	 */
	public boolean update(OrderOnUserPO po) throws RemoteException{
		for (OrderOnUserPO op : userPOs) {
			if(op.getInitiator() == po.getInitiator()){
				op = po;
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 按搜索信息进行查找返回相应的OrderOnUserPO结果
	 */
	public ArrayList<OrderOnUserPO> find(User initiator) throws RemoteException{
		ArrayList<OrderOnUserPO> arrayList = new ArrayList<OrderOnUserPO>();
		for (OrderOnUserPO op : userPOs) {
			if(op.getInitiator().getName().equals(initiator.getName())){
				arrayList.add(op);
			}
		}
		return arrayList;
	}
	
	
	/**
	 * 返回所有酒店订单PO
	 */
	public ArrayList<OrderOnUserPO> show() throws RemoteException{
		return userPOs;
	}
	
}

