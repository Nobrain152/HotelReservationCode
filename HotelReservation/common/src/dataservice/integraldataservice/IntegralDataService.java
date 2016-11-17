package dataservice.IntegralDataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.IntegralPO;

/**
 * ����ֵ���ݲ�Ľӿ�
 * @author T5-SK
 *
 */

public interface IntegralDataService {
	public boolean insert(IntegralPO integral) throws RemoteException;
	
	public boolean delete(IntegralPO integral) throws RemoteException;
	
	public boolean update(IntegralPO Integral) throws RemoteException;
	//���û�����ѯ����ֵ
	public IntegralPO findByName(String name) throws RemoteException;
	
	public ArrayList<IntegralPO> show() throws RemoteException;
}
