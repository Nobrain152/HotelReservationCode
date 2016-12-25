package dataservice.vipdataservice;

import java.rmi.RemoteException;

public class VipDataService_Driver {
	
	public VipDataService_Driver(){

	}


	public void drive(VipDataService VipDataService) throws RemoteException {

		System.out.println("update succeed");
		
    }

	public static void main(String[] args) throws RemoteException {
        VipDataService stub = new VipDataService_Stub();
        VipDataService_Driver driver = new VipDataService_Driver();
        driver.drive(stub);
    }
	
	
}