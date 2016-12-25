package dataservice.promotiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionHotelPO;

public class PromotionHotelDataService_Driver {
	private PromotionHotelPO PromotionHotelPO1;
	private PromotionHotelPO PromotionHotelPO2;
	private ArrayList<PromotionHotelPO> PromotionHotelPOs;
	
	
	public PromotionHotelDataService_Driver(){
		
		PromotionHotelPOs = new ArrayList<PromotionHotelPO>();
		PromotionHotelPOs.add(PromotionHotelPO1);
		PromotionHotelPOs.add(PromotionHotelPO2);
	}


	public void drive(PromotionHotelDataService PromotionHotelDataService) throws RemoteException {
        
    }

	public static void main(String[] args) throws RemoteException {
        PromotionHotelDataService stub = new PromotionHotelDataService_Stub();
        PromotionHotelDataService_Driver driver = new PromotionHotelDataService_Driver();
        driver.drive(stub);
    }
	
	
}