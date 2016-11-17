/**
 * 处理酒店订单
 * @author txin
 * @date 2016/10/15
 */
package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderOnHotelPO;
import util.User;


public interface OrderOnHotelDataService {
	/**
	 * 在数据库中插入单一持久化对象
	 */
	public boolean insert(OrderOnHotelPO po) throws RemoteException;
	/**
	 * 在数据库中删除单一持久化对象
	 */
	public boolean delete(OrderOnHotelPO po) throws RemoteException;
	/**
	 * 在数据库中更新单一持久化对象
	 */
	public boolean update(OrderOnHotelPO po) throws RemoteException;
	/**
	 * 按搜索信息进行查找返回相应的OrderOnHotelPO结果
	 */
	public ArrayList<OrderOnHotelPO> find(User initiator) throws RemoteException;
	/**
	 * 返回所有酒店订单PO
	 */
	public ArrayList<OrderOnHotelPO> show() throws RemoteException;
}
