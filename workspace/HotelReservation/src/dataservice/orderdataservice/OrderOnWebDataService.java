/**
 * �����쳣����
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
	 * �����ݿ��в��뵥һ�־û�����
	 */
	public boolean insert(OrderOnWebPO po) throws RemoteException;
	/**
	 * �����ݿ���ɾ����һ�־û�����
	 */
	public boolean delete(OrderOnWebPO po) throws RemoteException;
	/**
	 * �����ݿ��и��µ�һ�־û�����
	 */
	public boolean update(OrderOnWebPO po) throws RemoteException;
	/**
	 * �����ֽ��в��ҷ�����Ӧ��OrderOnWebPO���
	 */
	public ArrayList<OrderOnWebPO> find(User initiatior) throws RemoteException;
	/**
	 * ���������쳣����PO
	 */
	public ArrayList<OrderOnWebPO> show() throws RemoteException;
}
