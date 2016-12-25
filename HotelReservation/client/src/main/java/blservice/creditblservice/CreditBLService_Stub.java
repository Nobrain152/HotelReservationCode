package blservice.creditblservice;

import java.util.ArrayList;

import po.CreditPO;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;


public class CreditBLService_Stub implements CreditBLService{
	String integral;
	ArrayList<String> integralNote;
	public CreditBLService_Stub(){
		integral = "0";
		integralNote = new ArrayList<String>(); 
	}
	
	public CreditBLService_Stub(String integral,ArrayList<String> integralNote){
		this.integral = integral;
		this.integralNote = integralNote;
	}

	@Override
	public int getCredit(CustomerInfoVO client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMsg addCredit(CustomerInfoVO client, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg subCredit(CustomerInfoVO client, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg changeCredit(CustomerInfoVO client, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CreditVO> getCreditList(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg insert(CreditPO creditPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditPO get(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CreditPO> getListByUserID(String userID) {
		// TODO Auto-generated method stub
		return null;
	}
}