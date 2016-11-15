/**
 * 处理异常订单
 * @author txin
 * @date 2016/10/15
 */
package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.util.User;
import po.OrderOnWebPO;


public interface OrderOnWebDataService {
	/**
	 * 在数据库中插入单一持久化对象
	 */
	public boolean insert(OrderOnWebPO po) throws RemoteException;
	/**
	 * 在数据库中删除单一持久化对象
	 */
	public boolean delete(OrderOnWebPO po) throws RemoteException;
	/**
	 * 在数据库中更新单一持久化对象
	 */
	public boolean update(OrderOnWebPO po) throws RemoteException;
	/**
	 * 按名字进行查找返回相应的OrderOnWebPO结果
	 */
	public ArrayList<OrderOnWebPO> find(User initiatior) throws RemoteException;
	/**
	 * 返回所有异常订单PO
	 */
	public ArrayList<OrderOnWebPO> show() throws RemoteException;
}
