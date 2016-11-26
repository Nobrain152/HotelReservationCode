package dataservice.vipdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.VipPO;
import util.ResultMsg;

/**
 * vip数据层接口
 * @author kevin
 *
 */

public interface VipDataService {
	public ResultMsg insert(VipPO vip) throws RemoteException;
	
	public ResultMsg delete(VipPO vip) throws RemoteException;
	
	public ResultMsg update(VipPO vip) throws RemoteException;
	
	public VipPO findByLevel(int level) throws RemoteException;
	
	public ArrayList<VipPO> show() throws RemoteException;
	
}
