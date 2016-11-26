/**
 * 处理异常订单
 * @author txin
 * @date 2016/10/15
 */
package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderOnWebPO;
import util.OrderState;
import util.ResultMsg;

public interface OrderOnWebDataService {

	/**
	 * 在数据库中插入单一持久化对象
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean insert(OrderOnWebPO po) throws RemoteException;

	/**
	 * 在数据库中删除单一持久化对象
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean delete(OrderOnWebPO po) throws RemoteException;

	/**
	 * 在数据库中更新单一持久化对象
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg update(OrderOnWebPO po) throws RemoteException;

	/**
	 * 按名字进行查找返回相应的OrderOnWebPO结果
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnWebPO> findByName(String name) throws RemoteException;
	
	/**
	 * 按订单ID进行查找返回相应的OrderOnWebPO结果
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public OrderOnWebPO findByID(String ID) throws RemoteException;
	
	/**
	 * 返回所有申诉订单PO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnWebPO> getComplaintList() throws RemoteException;
	/**
	 * 返回所有异常订单PO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnWebPO> getAbnormalList() throws RemoteException;
}
