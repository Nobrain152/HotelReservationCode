package user;


import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import bl.userbl.HotelStuff;
import dataservice.userdataservice.UserManagementDataService;
import util.ResultMsg;
import vo.StuffInfoVO;
import vo.UserInfoVO;

public class HotelStuffTest {
	private HotelStuff stuff;
	private UserManagementDataService service;
	
	public void setup(){
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
		StuffInfoVO vo1=new StuffInfoVO("1234567","Tom","13067893451","66666","1234567");
		ResultMsg cantest = ResultMsg.FAIL;
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
		if(cantest==ResultMsg.SUCCESS){
			assertEquals(po.getUserID(),"1234567");
			assertEquals(po.getUsername(),"Tom");
			assertEquals(po.getContact(),"13067893451");
			
		}
	}

}
