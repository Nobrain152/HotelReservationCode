package dataservice.vipdataservice;

import java.rmi.RemoteException;

import util.ResultMsg;

public class VipDataService_Driver {
	
	public VipDataService_Driver(){

	}


	public void drive(VipDataService vipDataService) throws RemoteException {
		ResultMsg resultMsg = vipDataService.delete("");
		if(resultMsg == ResultMsg.SUCCESS)
        	System.out.println("�ɹ�");
        else
        	System.out.println("ʧ��");
	}

	public static void main(String[] args) throws RemoteException {
        VipDataService stub = new VipDataService_Stub();
        VipDataService_Driver driver = new VipDataService_Driver();
        driver.drive(stub);
    }
	
	
}