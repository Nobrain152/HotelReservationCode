package bl.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.userbl.CustomerInfoManagementController;
import bl.vipbl.VipController;
import dataservice.creditdataservice.CreditDataService;
import po.BusinessVipPO;
import po.CommonVipPO;
import po.CreditPO;
import po.CustomerInfoPO;
import util.ResultMsg;
import util.Today;
import util.VipType;
import vo.CreditVO;
import vo.CustomerInfoVO;

public class Credit {

	private CreditDataService creditDataService;
	private VipController vip;
	private CustomerInfoManagementController customer;
	ResultMsg resultMsg;
	
	public Credit(CreditDataService creditDataService) {
		this.creditDataService = creditDataService;
	}
	
	public int getCredit(CustomerInfoVO client) throws RemoteException {
		ArrayList<CreditPO> creditPOs = creditDataService.getListByUserID(client.getUserID());
		return creditPOs.get(0).getCreditResult();
	}

	public ResultMsg addCredit(CustomerInfoVO client, int value) throws RemoteException {
		ArrayList<CreditPO> creditPOs = creditDataService.getListByUserID(client.getUserID());
		CreditPO creditPO = creditPOs.get(creditPOs.size()-1);
		if(creditPO == null){
			resultMsg = ResultMsg.NOT_EXIST;
		}else{
			creditPO.setCreditResult(creditPO.getCreditResult() + value);
			creditPO.setCreditChange("+" + value);
			creditPO.setTime(new Today().getToday());
			
			customer = (CustomerInfoManagementController)BusinessLogicDataFactory.getFactory().
					getCustomerIndividualInformationManagementBLService();
			CustomerInfoPO customerInfoPO = customer.getCustomerInfo(client.getUserID());
			customerInfoPO.setCredit(creditPO.getCreditResult());
			customer.setCustomerInfo(client.getUserID(), customerInfoPO);
			vip = (VipController)BusinessLogicDataFactory.getFactory().getVipLevelBLService();
			if(client.getVipType() == VipType.COMMON_VIP){
				CommonVipPO commonVipPO = vip.findByUserIDC(client.getUserID());
				commonVipPO.setCredit(creditPO.getCreditResult());
				vip.updateC(commonVipPO);
				resultMsg = ResultMsg.SUCCESS;
			}else if(client.getVipType() == VipType.COMPANY_VIP){
				BusinessVipPO businessVipPO = vip.findByUserIDB(client.getUserID());
				businessVipPO.setCredit(creditPO.getCreditResult());
				vip.updateB(businessVipPO);
				resultMsg = ResultMsg.SUCCESS;
			}
		}
		return resultMsg;
	}
	
	public ResultMsg subCredit(CustomerInfoVO client, int value) throws RemoteException {
		ArrayList<CreditPO> creditPOs = creditDataService.getListByUserID(client.getUserID());
		CreditPO creditPO = creditPOs.get(0);
		if(creditPO == null){
			resultMsg = ResultMsg.NOT_EXIST;
		}else{
			creditPO.setCreditResult(creditPO.getCreditResult() - value);
			creditPO.setCreditChange("-" + value);
			creditPO.setTime(new Today().getToday());
			vip = (VipController)BusinessLogicDataFactory.getFactory().getVipLevelBLService();
			if(client.getVipType() == VipType.COMMON_VIP){
				CommonVipPO commonVipPO = vip.findByUserIDC(client.getUserID());
				commonVipPO.setCredit(creditPO.getCreditResult());
				vip.updateC(commonVipPO);
				resultMsg = ResultMsg.SUCCESS;
			}else if(client.getVipType() == VipType.COMPANY_VIP){
				BusinessVipPO businessVipPO = vip.findByUserIDB(client.getUserID());
				businessVipPO.setCredit(creditPO.getCreditResult());
				vip.updateB(businessVipPO);
				resultMsg = ResultMsg.SUCCESS;
			}
		}
		return resultMsg;
	}

	public ResultMsg changeCredit(CustomerInfoVO client, int value) throws RemoteException {
		ArrayList<CreditPO> creditPOs = creditDataService.getListByUserID(client.getUserID());
		CreditPO creditPO = creditPOs.get(0);
		if(creditPO == null){
			resultMsg = ResultMsg.NOT_EXIST;
		}else{
			creditPO.setCreditResult(value);
			creditPO.setCreditChange("t" + value);
			creditPO.setTime(new Today().getToday());
			vip = (VipController)BusinessLogicDataFactory.getFactory().getVipLevelBLService();
			if(client.getVipType() == VipType.COMMON_VIP){
				CommonVipPO commonVipPO = vip.findByUserIDC(client.getUserID());
				commonVipPO.setCredit(creditPO.getCreditResult());
				vip.updateC(commonVipPO);
				resultMsg = ResultMsg.SUCCESS;
			}else if(client.getVipType() == VipType.COMPANY_VIP){
				BusinessVipPO businessVipPO = vip.findByUserIDB(client.getUserID());
				businessVipPO.setCredit(creditPO.getCreditResult());
				vip.updateB(businessVipPO);
				resultMsg = ResultMsg.SUCCESS;
			}
		}
		return resultMsg;
	}
	
	public ArrayList<CreditVO> getCreditList(String userID) throws RemoteException {
		ArrayList<CreditPO> creditPOs = creditDataService.getListByUserID(userID);
		ArrayList<CreditVO> creditVOs = new ArrayList<>();
		for(CreditPO creditPO : creditPOs) {
			creditVOs.add((CreditVO)VOPOchange.POtoVO(creditPO));
		}
		return creditVOs;
	}
}
