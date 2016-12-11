package dataservice.creditdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CreditPO;
import util.ResultMsg;


public interface CreditDataService extends Remote {
	
	/**
	 * ����һ������ֵ��¼
	 * @param creditPO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg insert(CreditPO creditPO) throws RemoteException;
	
	/**
	 * ��ȡ���û�������ֵ��¼�б�
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<CreditPO> getListByUserID(String userID) throws RemoteException;
	
	/**
	 * ��ȡ�ö���������ֵ��¼
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<CreditPO> getListByOrderID(String orderID) throws RemoteException;
	
	/**
	 * ��ʾ���м�¼
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<CreditPO> show() throws RemoteException;
	
}
