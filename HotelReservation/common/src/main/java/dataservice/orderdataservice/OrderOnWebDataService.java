/**
 * �����쳣����
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
	 * �����ݿ��в��뵥һ�־û�����
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean insert(OrderOnWebPO po) throws RemoteException;

	/**
	 * �����ݿ���ɾ����һ�־û�����
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean delete(OrderOnWebPO po) throws RemoteException;

	/**
	 * �����ݿ��и��µ�һ�־û�����
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg update(OrderOnWebPO po) throws RemoteException;

	/**
	 * �����ֽ��в��ҷ�����Ӧ��OrderOnWebPO���
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnWebPO> findByName(String name) throws RemoteException;
	
	/**
	 * ������ID���в��ҷ�����Ӧ��OrderOnWebPO���
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public OrderOnWebPO findByID(String ID) throws RemoteException;
	
	/**
	 * �����������߶���PO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnWebPO> getComplaintList() throws RemoteException;
	/**
	 * ���������쳣����PO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnWebPO> getAbnormalList() throws RemoteException;
}
