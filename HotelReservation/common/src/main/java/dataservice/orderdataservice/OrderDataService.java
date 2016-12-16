/**
 * ����ͻ�����
 * @author txin
 * @date 2016/10/15
 */
package dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderPO;
import util.ResultMsg;

public interface OrderDataService extends Remote{

	/**
	 * �����ݿ��в��뵥һ�־û�����
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public String insert(OrderPO po) throws RemoteException;

	/**
	 * �����ݿ���ɾ����һ�־û�����
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg delete(String ID) throws RemoteException;

	/**
	 * �����ݿ��и��µ�һ�־û�����
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg update(OrderPO po) throws RemoteException;
	
	/**
	 * ������ID���в��ҷ�����Ӧ��OrderPO���
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public OrderPO findByOrderID(String ID) throws RemoteException;

	/**
	 * ���û�ID���в��ҷ�����Ӧ��OrderPO���
	 * @param ID
	 * @return ���û������ж���
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> findByUserID(String ID) throws RemoteException;

	/**
	 * @param ID
	 * @return �þƵ�����ж���
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> findByHotelID(String ID) throws RemoteException;
	
	/**
	 * �������ж���PO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> showList() throws RemoteException;
}
