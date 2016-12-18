
package bl.vipbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.creditdataservice.CreditDataService;
import dataservice.userdataservice.UserManagementDataService;
import dataservice.vipdataservice.VipDataService;
import net.RMIManage;
import po.BusinessVipPO;
import po.CommonVipPO;
import po.CreditPO;
import po.CustomerInfoPO;
import po.LevelSystemPO;
import util.Action;
import util.DataServiceType;
import util.ResultMsg;
import util.Today;
import util.VipType;
import vo.BusinessVipVO;
import vo.CommonVipVO;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public class Vip {
	
	private VipDataService vipDataService = (VipDataService)RMIManage.getDataService(DataServiceType.VipDataService);
	private UserManagementDataService dataService = (UserManagementDataService)RMIManage.getDataService(DataServiceType.UserManagementDataService);
	private CreditDataService creditDataService = (CreditDataService)RMIManage.getDataService(DataServiceType.CreditDataService);
	
	public Vip(VipDataService vipDataService, UserManagementDataService dataService
			,CreditDataService creditDataService) {
		this.vipDataService = vipDataService;
		this.dataService = dataService;
		this.creditDataService = creditDataService;
	}

	/**
	 * 获得用户当前信用值对应的等级
	 * @param user
	 * @return
	 * @throws RemoteException
	 */
	public int searchLevel(CustomerInfoVO user) throws RemoteException {
		ArrayList<LevelSystemPO> levelSystemPOs = vipDataService.getLevelSystemPO();
		int credit = 0;
		if(user.getIsMember()) {
			credit = user.getCredit();
		}
		
		if(credit <= 0) {
			return 0;
		}
		
		int i;
		
		for(i = 0; i < levelSystemPOs.size(); i++){
			if(credit < levelSystemPOs.get(i).getCredits()){
				continue;
			}else{
				
			}
		}
		
		return i+1;
	}
	
	/**
	 * 注册会员
	 * @param customerInfoVO
	 * @param str
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg registerVip(String userID, VipType type, String str) throws RemoteException {
		ResultMsg resultMsg = ResultMsg.FAIL;
		CustomerInfoPO customerInfoPO = dataService.GetCustomerInfo("19954722");
		CustomerInfoVO customerInfoVO = (CustomerInfoVO)VOPOchange.POtoVO(customerInfoPO);
	
		if(type == VipType.COMMON_VIP) {
			CommonVipVO commonVipVO = new CommonVipVO(customerInfoVO.getUserID(), customerInfoVO.getUsername()
					, customerInfoVO.getPassword(),customerInfoVO.getContact(), 300, str, VipType.COMMON_VIP);
			CommonVipPO commonVipPO = (CommonVipPO)VOPOchange.VOtoPO(commonVipVO);
			resultMsg = vipDataService.insertC(commonVipPO);
		} else if(type == VipType.COMPANY_VIP) {
			BusinessVipVO businessVipVO = new BusinessVipVO(customerInfoVO.getUserID(), customerInfoVO.getUsername()
					, customerInfoVO.getPassword(),customerInfoVO.getContact(), 300, str, VipType.COMPANY_VIP);
			BusinessVipPO businessVipPO = (BusinessVipPO)VOPOchange.VOtoPO(businessVipVO);
			resultMsg = vipDataService.insertB(businessVipPO);
		}
		if(resultMsg != ResultMsg.FAIL) {
			resultMsg = creditDataService.insert(new CreditPO(customerInfoVO.getUserID(), null, new Today().getToday(), Action.Initial, "t300", 300));
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
		ResultMsg resultMsg = ResultMsg.FAIL;
		if(vipDataService.findL(levelSystemVO.getLevels()) == null)
			resultMsg = vipDataService.insertL(levelSystemPO);
		return resultMsg;
	}
}
