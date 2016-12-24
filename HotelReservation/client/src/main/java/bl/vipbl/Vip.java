
package bl.vipbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.userbl.CustomerInfoManagementController;
import dataservice.vipdataservice.VipDataService;
import po.BusinessVipPO;
import po.CommonVipPO;
import po.CustomerInfoPO;
import po.LevelSystemPO;
import util.ResultMsg;
import util.VipType;
import vo.BusinessVipVO;
import vo.CommonVipVO;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

/**
 * ��Ա
 * @author txin15
 *
 */
public class Vip {
	
	private VipDataService vipDataService;
	private CustomerInfoManagementController customer;
	
	public Vip(VipDataService vipDataService) {
		this.vipDataService = vipDataService;
	}

	/**
	 * ����û���ǰ����ֵ��Ӧ�ĵȼ�
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
			if(credit > levelSystemPOs.get(i).getCredits()){
				continue;
			}else{
				break;
			}
		}
		
		return i;
	}
	
	/**
	 * ע���Ա
	 * @param customerInfoVO
	 * @param str
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg registerVip(String userID, VipType type, String str) throws RemoteException {
		ResultMsg resultMsg = ResultMsg.FAIL;
		customer = (CustomerInfoManagementController)BusinessLogicDataFactory.getFactory().getCustomerIndividualInformationManagementBLService();
		CustomerInfoPO customerInfoPO = customer.getCustomerInfo(userID);
		CustomerInfoVO customerInfoVO = (CustomerInfoVO)VOPOchange.POtoVO(customerInfoPO);
	
		if(type == VipType.COMMON_VIP) {
			CommonVipVO commonVipVO = new CommonVipVO(customerInfoVO.getUserID(), customerInfoVO.getUsername()
					, customerInfoVO.getPassword(),customerInfoVO.getContact(), 300, str, VipType.COMMON_VIP);
			CommonVipPO commonVipPO = (CommonVipPO)VOPOchange.VOtoPO(commonVipVO);
			if(vipDataService.findByUserIDC(userID) == null)
				resultMsg = vipDataService.insertC(commonVipPO);
		} else if(type == VipType.COMPANY_VIP) {
			BusinessVipVO businessVipVO = new BusinessVipVO(customerInfoVO.getUserID(), customerInfoVO.getUsername()
					, customerInfoVO.getPassword(),customerInfoVO.getContact(), 300, str, VipType.COMPANY_VIP);
			BusinessVipPO businessVipPO = (BusinessVipPO)VOPOchange.VOtoPO(businessVipVO);
			if(vipDataService.findByUserIDB(userID) == null)
				resultMsg = vipDataService.insertB(businessVipPO);
		}
		return resultMsg;
	}

	/**
	 * �ƶ��ȼ��ƶ�
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
