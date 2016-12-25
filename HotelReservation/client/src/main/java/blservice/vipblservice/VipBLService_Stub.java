package blservice.vipblservice;

import po.BusinessVipPO;
import po.CommonVipPO;
import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public class VipBLService_Stub implements VipLevelBLService {

	@Override
	public int searchLevel(CustomerInfoVO user) {
		return 3;
	}

	@Override
	public ResultMsg registerVip(String userID, VipType type, String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg createLevelSystem(LevelSystemVO levelSystemVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonVipPO findByUserIDC(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessVipPO findByUserIDB(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg updateC(CommonVipPO commonVipPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg updateB(BusinessVipPO businessVipPO) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}