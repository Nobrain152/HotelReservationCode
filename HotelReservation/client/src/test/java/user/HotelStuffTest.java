package user;


import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import bl.userbl.HotelStuff;
import data.userdata.UserManagementDataServiceImpl;
import dataservice.userdataservice.UserManagementDataService;
import vo.ContactVO;
import vo.StuffInfoVO;
import vo.UserInfoVO;

public class HotelStuffTest {
	private HotelStuff stuff;
	private UserManagementDataService service;
	
	public void setup(){
		service=new UserManagementDataServiceImpl();
		stuff=new HotelStuff(service);
		
	}
	
	public void testinquiry(){
		UserInfoVO po = null;
		try {
			po = stuff.IndividualBaseInfolnquiry("1234567");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(po.getUserID(),"7654321");
		assertEquals(po.getUsername(),"Tim");
		assertEquals(po.getContact(),"18192345782");
	}
	
	public void testmodify(){
		StuffInfoVO vo1=new StuffInfoVO("1234567","Tom",new ContactVO("13067893451",null),"1234567");
		boolean cantest = false;
		try {
			cantest = stuff.IndividualBaseInfoModification("1234567",vo1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfoVO po = null;
		try {
			po = stuff.IndividualBaseInfolnquiry("1234567");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cantest){
			assertEquals(po.getUserID(),"1234567");
			assertEquals(po.getUsername(),"Tom");
			assertEquals(po.getContact(),"13067893451");
			
		}
	}

}
