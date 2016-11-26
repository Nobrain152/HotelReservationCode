/**
 * 处理客户订单
 * @author txin
 * @date 2016/10/15
 */
package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderOnUserPO;
import util.ResultMsg;

public interface OrderOnUserDataService {

	/**
	 * 在数据库中插入单一持久化对象
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean insert(OrderOnUserPO po) throws RemoteException;

	/**
	 * 在数据库中删除单一持久化对象
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean delete(OrderOnUserPO po) throws RemoteException;

	/**
	 * 在数据库中更新单一持久化对象
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg update(OrderOnUserPO po) throws RemoteException;

	/**
	 * 按名字进行查找返回相应的OrderOnUserPO结果
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnUserPO> findByName(String name) throws RemoteException;
	
	/**
	 * 按订单ID进行查找返回相应的OrderOnUserPO结果
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public OrderOnUserPO findByID(String ID) throws RemoteException;

	/**
	 * 返回所有客户订单PO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnUserPO> show() throws RemoteException;
}
