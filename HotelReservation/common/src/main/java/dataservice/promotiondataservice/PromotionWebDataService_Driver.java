package dataservice.promotiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionWebPO;

public class PromotionWebDataService_Driver {
	private PromotionWebPO PromotionWebPO1;
	private PromotionWebPO PromotionWebPO2;
	private ArrayList<PromotionWebPO> PromotionWebPOs;
	
	public PromotionWebDataService_Driver(){
		
		PromotionWebPOs = new ArrayList<PromotionWebPO>();
		PromotionWebPOs.add(PromotionWebPO1);
		PromotionWebPOs.add(PromotionWebPO2);
	}


	public void drive(PromotionWebDataService PromotionWebDataService) throws RemoteException {

	}

	public static void main(String[] args) throws RemoteException {
        PromotionWebDataService stub = new PromotionWebDataService_Stub();
        PromotionWebDataService_Driver driver = new PromotionWebDataService_Driver();
        driver.drive(stub);
    }
	
	
}