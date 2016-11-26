package bl.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;
import vo.CreditVO;
import vo.CustomerInfoVO;

public class Credit {

	private CreditDataService creditDataService;
	private CreditVO creditVO;
	
	public Credit(CreditDataService creditDataService) {
		this.creditDataService = creditDataService;
	}
	
	public CreditVO getCredit(CustomerInfoVO client) {
		// TODO Auto-generated method stub
		return null;
	}

	public CreditVO addCredit(CustomerInfoVO client, int value) throws RemoteException {
		String userID = client.getUserID();
		int credit = client.getCredit() + value;
		ArrayList<String> creditList = client.getCreditList();
		creditList.add("");
		creditVO = new CreditVO(userID, credit, creditList);
		creditDataService.insert((CreditPO)VOPOchange.POtoVO(creditVO));
		return creditVO;
	}

	public CreditVO subCredit(CustomerInfoVO client, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	public CreditVO changeCredit(CustomerInfoVO client, int value) {
		// TODO Auto-generated method stub
		return null;
	}
}
