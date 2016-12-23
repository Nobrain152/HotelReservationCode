package bl.vipbl;

import java.rmi.RemoteException;

import blservice.vipblservice.VipLevelBLService;
import net.RMIManage;
import dataservice.userdataservice.UserManagementDataService;
import dataservice.vipdataservice.VipDataService;
import util.DataServiceType;
import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public class VipController implements VipLevelBLService{
	
	private Vip vip;
	private VipDataService vipDataService;
	private UserManagementDataService dataService;
	
	public VipController() {
		vipDataService = (VipDataService)RMIManage.
				getDataService(DataServiceType.VipDataService);
		dataService = (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.CustomerManagementDataService);
		vip = new Vip(vipDataService,dataService);
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
	public ResultMsg registerVip(String userID,VipType type,String str) {
		ResultMsg resultMsg = ResultMsg.FAIL;
		try {
			resultMsg = vip.registerVip(userID, type, str);
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
