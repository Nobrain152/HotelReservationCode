package data.vipdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import dataSuper.DataServiceHelper;
import dataSuper.DataSuperClass;
import dataservice.vipdataservice.VipDataService;
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
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMsg insert(VipPO vip) throws RemoteException {
		//���ø���ķ���
		return addToSQL(tableName, vip.getName());
	}
	
	public void initial() throws RemoteException{
		//��ʼ����ʱ�򲢲���Ҫ���Ĭ�ϵĻ�Ա
		initialFromSQL(tableName);
		
	}

	@Override
	public ResultMsg delete(VipPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return delFromSQL(tableName, vip.getName());
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

}
