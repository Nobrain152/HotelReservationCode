package data.vipdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.vipdataservice.VipDataService;
import po.VipPO;
import util.ResultMsg;

public class VipDataSerivceImpl implements VipDataService{

	@Override
	public ResultMsg insert(VipPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
	}

	@Override
	public ResultMsg delete(VipPO vip) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
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
