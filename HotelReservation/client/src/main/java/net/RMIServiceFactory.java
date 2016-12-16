package net;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.userdataservice.UserManagementDataService;
import util.DataServiceType;

public class RMIServiceFactory {
	public static UserManagementDataService userDataService;
	
	private static RMIServiceFactory rmiServiceFactory;
	
	
	private RMIServiceFactory() {
		try {
			userDataService = (UserManagementDataService) RMIManage.mygetDataService(DataServiceType.UserManagementDataService);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			
		}
	}
	static{
		try {
			userDataService = (UserManagementDataService) RMIManage.mygetDataService(DataServiceType.UserManagementDataService);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void getServiceAgain(){
		getAgain();
	}
	
	private static void getAgain(){
		try {
			userDataService = (UserManagementDataService) RMIManage.mygetDataService(DataServiceType.UserManagementDataService);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			getAgain();
		}
	}
}
