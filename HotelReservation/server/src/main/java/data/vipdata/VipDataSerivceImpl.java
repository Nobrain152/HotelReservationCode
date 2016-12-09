package data.vipdata;

import java.awt.Window.Type;
import java.rmi.RemoteException;
import java.util.ArrayList;


import dataSuper.DataSuperClass;
import dataservice.vipdataservice.VipDataService;
import po.BusinessVipPO;
import po.CommonVipPO;
import po.CustomerInfoPO;
import po.LevelSystemPO;
import po.CustomerInfoPO;
import util.ResultMsg;

public class VipDataSerivceImpl extends DataSuperClass implements VipDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VipDataSerivceImpl() throws RemoteException {
		super();
	}
	@Override
	public ResultMsg insertC(CommonVipPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg deleteC(CommonVipPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg updateC(CommonVipPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonVipPO findByLevelC(int level, Type type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonVipPO findByUserIDC(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CommonVipPO> showC(Type type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg insertB(BusinessVipPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg deleteB(BusinessVipPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg updateB(BusinessVipPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessVipPO findByLevelB(int level, Type type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessVipPO findByUserIDB(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BusinessVipPO> showB(Type type) throws RemoteException {
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
