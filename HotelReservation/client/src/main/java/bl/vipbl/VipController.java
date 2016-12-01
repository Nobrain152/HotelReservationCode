package bl.vipbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.vipblservice.VipLevelBLService;
import datafactory.DataFactory;
import dataservice.vipdataservice.VipDataService;
import util.ResultMsg;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;
import vo.VipVO;

public class VipController implements VipLevelBLService{
	
	private Vip vip;
	private VipDataService vipDataService;
	
	public VipController() throws RemoteException {
		vipDataService = DataFactory.getVipDataService();
		vip = new Vip(vipDataService);
	}

	@Override
	public ArrayList<VipVO> showLevelNeed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchLevel(CustomerInfoVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMsg registerVip(CustomerInfoVO customerInfoVO, String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg createLevelSystem(LevelSystemVO levelSystemVO) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
