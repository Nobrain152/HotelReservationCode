package dataservice.IntegralDataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.IntegralPO;

/**
 * 信用值数据层的接口
 * @author T5-SK
 *
 */

public interface IntegralDataService {
	public boolean insert(IntegralPO integral) throws RemoteException;
	
	public boolean delete(IntegralPO integral) throws RemoteException;
	
	public boolean update(IntegralPO Integral) throws RemoteException;
	//按用户名查询信用值
	public IntegralPO findByName(String name) throws RemoteException;
	
	public ArrayList<IntegralPO> show() throws RemoteException;
}
