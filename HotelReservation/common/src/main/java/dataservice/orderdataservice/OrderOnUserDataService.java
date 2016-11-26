/**
 * ����ͻ�����
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
	 * �����ݿ��в��뵥һ�־û�����
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean insert(OrderOnUserPO po) throws RemoteException;

	/**
	 * �����ݿ���ɾ����һ�־û�����
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean delete(OrderOnUserPO po) throws RemoteException;

	/**
	 * �����ݿ��и��µ�һ�־û�����
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg update(OrderOnUserPO po) throws RemoteException;

	/**
	 * �����ֽ��в��ҷ�����Ӧ��OrderOnUserPO���
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnUserPO> findByName(String name) throws RemoteException;
	
	/**
	 * ������ID���в��ҷ�����Ӧ��OrderOnUserPO���
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public OrderOnUserPO findByID(String ID) throws RemoteException;

	/**
	 * �������пͻ�����PO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnUserPO> show() throws RemoteException;
}
