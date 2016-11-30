package bl.vipbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.vipblservice.VipLevelBLService;
import datafactory.DataFactory;
import dataservice.vipdataservice.VipDataService;
import po.VipPO;
import vo.UserInfoVO;
import vo.VipVO;

public class VipController implements VipLevelBLService{
	
	private Vip vip;
	private VipDataService vipDataService;
	
	public VipController() {
		vipDataService = DataFactory.getVipDataService();
		vip = new Vip(vipDataService);
	}
	
	@Override
	public ArrayList<VipVO> showLevelNeed() {
		// TODO Auto-generated method stub
		//没有捕获异常
		try {
			return vip.showLevelNeed();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int searchLevel(UserInfoVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void changeLevelNeed(int level, int integral) {
		// TODO Auto-generated method stub
		
	}

}
