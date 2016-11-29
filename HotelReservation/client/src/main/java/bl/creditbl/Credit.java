package bl.creditbl;

import java.rmi.RemoteException;

import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;
import util.ResultMsg;
import vo.CustomerInfoVO;

public class Credit {

	private CreditDataService creditDataService;
	ResultMsg resultMsg;
	
	public Credit(CreditDataService creditDataService) {
		this.creditDataService = creditDataService;
	}
	
	public int getCredit(CustomerInfoVO client) throws RemoteException {
		CreditPO creditPO = creditDataService.findByUserID(client.getUserID());
		return creditPO.getCreditResult();
	}

	public ResultMsg addCredit(CustomerInfoVO client, int value) throws RemoteException {
		CreditPO creditPO = creditDataService.findByUserID(client.getUserID());
		if(creditPO == null){
			resultMsg = ResultMsg.NOT_EXIST;
		}else{
			creditPO.setCreditResult(creditPO.getCreditResult() + value);
			resultMsg = creditDataService.insert(creditPO);
		}
		return resultMsg;
	}
	
	public ResultMsg subCredit(CustomerInfoVO client, int value) throws RemoteException {
		CreditPO creditPO = creditDataService.findByUserID(client.getUserID());
		if(creditPO == null){
			resultMsg = ResultMsg.NOT_EXIST;
		}else{
			creditPO.setCreditResult(creditPO.getCreditResult() - value);
			resultMsg = creditDataService.insert(creditPO);
		}
		return resultMsg;
	}

	public ResultMsg changeCredit(CustomerInfoVO client, int value) throws RemoteException {
		CreditPO creditPO = creditDataService.findByUserID(client.getUserID());
		if(creditPO == null){
			resultMsg = ResultMsg.NOT_EXIST;
		}else{
			creditPO.setCreditResult(value);
			resultMsg = creditDataService.insert(creditPO);
		}
		return resultMsg;
	}
}
