package dataservice.creditdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class CreditDataService_Driver {
	private ArrayList<String> integralRecord;
	
	public CreditDataService_Driver(){
		integralRecord = new ArrayList<String>();
		integralRecord.add("50/增加");
	}
	
	 public void drive(CreditDataService IntegralDataService) throws RemoteException {
        	System.out.println("update succeed");
    }

	public static void main(String[] args) throws RemoteException {
        CreditDataService_Stub stub = new CreditDataService_Stub();
        CreditDataService_Driver driver = new CreditDataService_Driver();
        driver.drive(stub);
    }
	
	
}