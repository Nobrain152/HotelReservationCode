package data.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderOnHotelPO;
import util.User;

public class OrderOnHotelDataServiceImpl {

	ArrayList<OrderOnHotelPO> hotelPOs;
	
	public OrderOnHotelDataServiceImpl(){
		hotelPOs = new ArrayList<>();
	}
	
	
	/**
	 * 在数据库中插入单一持久化对象
	 */
	public boolean insert(OrderOnHotelPO po) throws RemoteException{
		if(hotelPOs.add(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * 在数据库中删除单一持久化对象
	 */
	public boolean delete(OrderOnHotelPO po) throws RemoteException{
		if(hotelPOs.remove(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * 在数据库中更新单一持久化对象
	 */
	public boolean update(OrderOnHotelPO po) throws RemoteException{
		for (OrderOnHotelPO op : hotelPOs) {
			if(op.getInitiator() == po.getInitiator()){
				op = po;
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 按搜索信息进行查找返回相应的OrderOnHotelPO结果
	 */
	public ArrayList<OrderOnHotelPO> find(User initiator) throws RemoteException{
		ArrayList<OrderOnHotelPO> arrayList = new ArrayList<OrderOnHotelPO>();
		for (OrderOnHotelPO op : hotelPOs) {
			if(op.getInitiator().getName().equals(initiator.getName())){
				arrayList.add(op);
			}
		}
		return arrayList;
	}
	
	
	/**
	 * 返回所有酒店订单PO
	 */
	public ArrayList<OrderOnHotelPO> show() throws RemoteException{
		return hotelPOs;
	}
	
}
