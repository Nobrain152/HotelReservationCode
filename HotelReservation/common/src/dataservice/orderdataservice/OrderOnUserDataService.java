/**
 * 处理客户订单
 * @author txin
 * @date 2016/10/15
 */
package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.util.User;
import po.OrderOnUserPO;


public interface OrderOnUserDataService {
	/**
	 * 在数据库中插入单一持久化对象
	 */
	public boolean insert(OrderOnUserPO po) throws RemoteException;
	/**
	 * 在数据库中删除单一持久化对象
	 */
	public boolean delete(OrderOnUserPO po) throws RemoteException;
	/**
	 * 在数据库中更新单一持久化对象
	 */
	public boolean update(OrderOnUserPO po) throws RemoteException;
	/**
	 * 按名字进行查找返回相应的OrderOnUserPO结果
	 */
	public ArrayList<OrderOnUserPO> find(User initiator) throws RemoteException;

	/**
	 * 返回所有客户订单PO
	 */
	public ArrayList<OrderOnUserPO> show() throws RemoteException;
}
