package bl.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;
import util.Action;
import util.ResultMsg;
import vo.CreditVO;
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
			//creditPO.setAction(Action.Executed);
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
			//creditPO.setAction(Action.Executed);
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
			creditPO.setAction(Action.Charge);
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
