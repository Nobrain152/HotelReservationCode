package bl.vipbl;

import java.nio.file.attribute.DosFileAttributes;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.vipdataservice.VipDataService;
import po.VipPO;
import util.ResultMsg;
import vo.UserInfoVO;
import vo.VipVO;

public class Vip {
	
	private VipDataService vipDataService;
	private VipVO vipVO;
	private ResultMsg result;
	
	public Vip(VipDataService vipDataService) {
		this.vipDataService = vipDataService;
	}

	public ArrayList<VipVO> showLevelNeed() throws RemoteException {
		ArrayList<VipVO> vos = null;
		ArrayList<VipPO> pos = vipDataService.show();
		
		if(pos == null){
			return null;
		}
		
		vos = new ArrayList<VipVO>(pos.size());
		for(VipPO vipPO : pos){
			//vo,po×ª»»»¹Ã»Ð´
			vos.add(null);
		}
		
		return vos;
	}

	public int searchLevel(UserInfoVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void changeLevelNeed(int level, int integral) {
		// TODO Auto-generated method stub
		
	}

}
