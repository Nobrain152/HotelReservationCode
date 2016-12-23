package bl.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import bl.vipbl.VipController;
import blservice.vipblservice.VipLevelBLService;
import dataservice.creditdataservice.CreditDataService;
import dataservice.userdataservice.CustomerManagementDataService;
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
	private VipLevelBLService vip = new VipController();
	private CustomerManagementDataService customerManagementDataService;
	ResultMsg resultMsg;
	
	public Credit(CreditDataService creditDataService,
			CustomerManagementDataService customerManagementDataService) {
		this.creditDataService = creditDataService;
		this.customerManagementDataService = customerManagementDataService;
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
			
			CustomerInfoPO customerInfoPO = customerManagementDataService.GetCustomerInfo(client.getUserID());
			customerInfoPO.setCredit(creditPO.getCreditResult());
			customerManagementDataService.SetCustomerInfo(client.getUserID(), customerInfoPO);
			
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
