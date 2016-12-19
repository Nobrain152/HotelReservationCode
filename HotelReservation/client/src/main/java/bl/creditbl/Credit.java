package bl.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.creditdataservice.CreditDataService;
import dataservice.userdataservice.CustomerManagementDataService;
import dataservice.vipdataservice.VipDataService;
import po.CommonVipPO;
import po.CreditPO;
import po.CustomerInfoPO;
import util.ResultMsg;
import util.Today;
import vo.CreditVO;
import vo.CustomerInfoVO;

public class Credit {

	private CreditDataService creditDataService;
	private CustomerManagementDataService customerManagementDataService;
	private VipDataService vipDataService;
	ResultMsg resultMsg;
	
	public Credit(CreditDataService creditDataService,
			CustomerManagementDataService customerManagementDataService,
			VipDataService vipDataService) {
		this.creditDataService = creditDataService;
		this.customerManagementDataService = customerManagementDataService;
		this.vipDataService = vipDataService;
	}
	
	public int getCredit(CustomerInfoVO client) throws RemoteException {
		ArrayList<CreditPO> creditPOs = creditDataService.getListByUserID(client.getUserID());
		return creditPOs.get(0).getCreditResult();
	}

	public ResultMsg addCredit(CustomerInfoVO client, int value) throws RemoteException {
		ArrayList<CreditPO> creditPOs = creditDataService.getListByUserID(client.getUserID());
		CreditPO creditPO = creditPOs.get(0);
		if(creditPO == null){
			resultMsg = ResultMsg.NOT_EXIST;
		}else{
			creditPO.setCreditResult(creditPO.getCreditResult() + value);
			creditPO.setCreditChange("+" + value);
			creditPO.setTime(new Today().getToday());
			CustomerInfoPO customerInfoPO = customerManagementDataService.GetCustomerInfo(client.getUserID());
			customerInfoPO.setCredit(creditPO.getCreditResult());
			customerManagementDataService.SetCustomerInfo(client.getUserID(), customerInfoPO);
			//CommonVipPO commonVipPO = vipDataService.findByUserIDC(client.getUserID());
			//commonVipPO.setCredit(creditPO.getCreditResult());
			//vipDataService.updateC(commonVipPO);
			resultMsg = creditDataService.insert(creditPO);
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
			resultMsg = creditDataService.insert(creditPO);
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
			resultMsg = creditDataService.insert(creditPO);
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
