package data.vipdata;

import java.rmi.RemoteException;
import java.util.ArrayList;


import dataSuper.DataSuperClass;
import dataservice.vipdataservice.VipDataService;
import po.CustomerInfoPO;
import po.LevelSystemPO;
import po.CustomerInfoPO;
import util.ResultMsg;

public class VipDataSerivceImpl extends DataSuperClass implements VipDataService{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String tableName = "vip";
	
	public VipDataSerivceImpl() throws RemoteException {
		super();
	}

	@Override
	public ResultMsg insert(CustomerInfoPO vip) throws RemoteException {
		//���ø���ķ���
		return addToSQL(tableName, vip.getUsername());
	}
	
	public void initial() throws RemoteException{
		//��ʼ����ʱ�򲢲���Ҫ���Ĭ�ϵĻ�Ա
		initialFromSQL(tableName);
		
	}

	@Override
	public ResultMsg delete(CustomerInfoPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return delFromSQL(tableName, vip.getUsername());
	}

	@Override
	public ResultMsg update(CustomerInfoPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
	}

	@Override
	public CustomerInfoPO findByLevel(int level) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CustomerInfoPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerInfoPO findByUserID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg update(LevelSystemPO levelSystemPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LevelSystemPO getLevelSystemPO() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
