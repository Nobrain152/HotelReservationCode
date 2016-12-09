package data.vipdata;

import java.rmi.RemoteException;
import java.util.ArrayList;


import dataSuper.DataSuperClass;
import dataservice.vipdataservice.VipDataService;
import po.CustomerInfoPO;
import po.LevelSystemPO;
import po.VipPO;
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
	public ResultMsg insert(VipPO vip) throws RemoteException {
		//���ø���ķ���
		return addToSQL(tableName, vip.getUsername());
	}
	
	public void initial() throws RemoteException{
		//��ʼ����ʱ�򲢲���Ҫ���Ĭ�ϵĻ�Ա
		initialFromSQL(tableName);
		
	}

	@Override
	public ResultMsg delete(VipPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return delFromSQL(tableName, vip.getUsername());
	}

	@Override
	public ResultMsg update(VipPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
	}

	@Override
	public VipPO findByLevel(int level) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VipPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VipPO findByUserID(String id) throws RemoteException {
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
