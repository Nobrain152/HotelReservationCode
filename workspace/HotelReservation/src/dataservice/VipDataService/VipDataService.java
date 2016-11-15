package dataservice.VipDataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.VipPO;

/**
 * vip���ݲ�ӿ�
 * @author kevin
 *
 */

public interface VipDataService {
	public void insert(VipPO vip) throws RemoteException;
	
	public void delete(VipPO vip) throws RemoteException;
	
	public void update(VipPO vip) throws RemoteException;
	
	public VipPO findByLevel(int level) throws RemoteException;
	
	public ArrayList<VipPO> show() throws RemoteException;
	
}
