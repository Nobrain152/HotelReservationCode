package bl.vipbl;

import java.rmi.RemoteException;

import blservice.vipblservice.VipLevelBLService;
import datafactory.DataFactory;
import dataservice.vipdataservice.VipDataService;
import util.ResultMsg;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public class VipController implements VipLevelBLService{
	
	private Vip vip;
	private VipDataService vipDataService;
	
	public VipController() throws RemoteException {
		vipDataService = new DataFactory().getVipDataService();
		vip = new Vip(vipDataService);
	}

	@Override
	public int searchLevel(CustomerInfoVO user) {
		int level = 0;
		try {
			level = vip.searchLevel(user);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return level;
	}

	@Override
	public ResultMsg registerVip(CustomerInfoVO customerInfoVO, String str) {
		ResultMsg resultMsg = ResultMsg.FAIL;
		try {
			resultMsg = vip.registerVip(customerInfoVO, str);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg createLevelSystem(LevelSystemVO levelSystemVO) {
		ResultMsg resultMsg = ResultMsg.FAIL;
		try {
			resultMsg = vip.createLevelSystem(levelSystemVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

}
