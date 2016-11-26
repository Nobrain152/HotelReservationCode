/**
 * ����Ƶ궩��
 * @author txin
 * @date 2016/10/15
 */
package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderOnHotelPO;

public interface OrderOnHotelDataService {

	/**
	 * �����ݿ��в��뵥һ�־û�����
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean insert(OrderOnHotelPO po) throws RemoteException;
	
	/**
	 * �����ݿ���ɾ����һ�־û�����
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean delete(OrderOnHotelPO po) throws RemoteException;
	
	/**
	 * �����ݿ��и��µ�һ�־û�����
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean update(OrderOnHotelPO po) throws RemoteException;
	
	/**
	 * �����ֽ��в��ҷ�����Ӧ��OrderOnHotelPO���
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnHotelPO> findByName(String name) throws RemoteException;

	/**
	 * ������ID���в��ҷ�����Ӧ��OrderOnHotelPO���
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public OrderOnHotelPO findByID(String ID) throws RemoteException;

	/**
	 * �������оƵ궩��PO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderOnHotelPO> getTotalHotelOrderList() throws RemoteException;
}
