package bl.vipbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import dataservice.vipdataservice.VipDataService;
import po.BusinessVipPO;
import po.CommonVipPO;
import po.LevelSystemPO;
import util.ResultMsg;
import util.VipType;
import vo.BusinessVipVO;
import vo.CommonVipVO;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public class Vip {
	
	private VipDataService vipDataService;
	
	public Vip(VipDataService vipDataService) {
		this.vipDataService = vipDataService;
	}

	/**
	 * 获得用户当前信用值对应的等级
	 * @param user
	 * @return
	 * @throws RemoteException
	 */
	public int searchLevel(CustomerInfoVO user) throws RemoteException {
		LevelSystemPO levelSystemPO = vipDataService.getLevelSystemPO();
		int credit = 0;
		if(user.getIsMember()) {
			credit = user.getCredit();
		}
		
		if(credit <= 0) {
			return 0;
		}
		
		int[] credits = levelSystemPO.getCredits();
		for(int i = 0; i < credits.length-1; i++) {
			if(credit > credits[i] && credit <= credits[i+1]) {
				return i+1;
			}
		}
		
		return credits.length;
	}
	
	/**
	 * 注册会员
	 * @param customerInfoVO
	 * @param str
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg registerVip(CustomerInfoVO customerInfoVO,String str) throws RemoteException {
		ResultMsg resultMsg = ResultMsg.FAIL;
		if(customerInfoVO.getIsMember() && customerInfoVO.getVipType() == VipType.COMMON_VIP) {
			CommonVipVO commonVipVO = new CommonVipVO(customerInfoVO.getUserID(), customerInfoVO.getUsername()
					, customerInfoVO.getContact(), customerInfoVO.getCredit(), str, VipType.COMMON_VIP);
			CommonVipPO commonVipPO = (CommonVipPO)VOPOchange.VOtoPO(commonVipVO);
			resultMsg = vipDataService.insert(commonVipPO);
		} else if(customerInfoVO.getIsMember() && customerInfoVO.getVipType() == VipType.COMPANY_VIP) {
			BusinessVipVO businessVipVO = new BusinessVipVO(customerInfoVO.getUserID(), customerInfoVO.getUsername()
					, customerInfoVO.getContact(), customerInfoVO.getCredit(), str, VipType.COMPANY_VIP);
			BusinessVipPO businessVipPO = (BusinessVipPO)VOPOchange.VOtoPO(businessVipVO);
			resultMsg = vipDataService.insert(businessVipPO);
		}
		return resultMsg;
	}

	/**
	 * 制定等级制度
	 * @param levelSystemVO
	 * @throws RemoteException 
	 */
	public ResultMsg createLevelSystem(LevelSystemVO levelSystemVO) throws RemoteException {
		LevelSystemPO levelSystemPO = (LevelSystemPO)VOPOchange.VOtoPO(levelSystemVO);
		ResultMsg resultMsg = vipDataService.update(levelSystemPO);
		return resultMsg;
	}

}
