/**
 * 处理酒店订单
 * @author txin
 * @date 2016/10/15
 */
package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderOnHotelPO;

public interface OrderOnHotelDataService {

	/**
	 * 在数据库中插入单一持久化对象
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean insert(OrderOnHotelPO po) throws RemoteException;
	
	/**
	 * 在数据库中删除单一持久化对象
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean delete(OrderOnHotelPO po) throws RemoteException;
	
	/**
	 * 在数据库中更新单一持久化对象
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean update(OrderOnHotelPO po) throws RemoteException;
	
	/**
	 * 按名字进行查找返回相应的OrderOnHotelPO结果
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnHotelPO> findByName(String name) throws RemoteException;

	/**
	 * 按订单ID进行查找返回相应的OrderOnHotelPO结果
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public OrderOnHotelPO findByID(String ID) throws RemoteException;

	/**
	 * 返回所有酒店订单PO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnHotelPO> getTotalHotelOrderList() throws RemoteException;
}
