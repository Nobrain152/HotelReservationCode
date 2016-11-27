package data;


import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.userdata.UserManagementDataServiceImpl;
import po.ContactPO;
import po.LoginInPO;
import po.UserInfoPO;

public class UserManagementDataServiceImplTest {

	UserManagementDataServiceImpl impl;
	LoginInPO log;
	String po;
	
	@Before
	public void setUp(){
		impl=new UserManagementDataServiceImpl();
		log=new LoginInPO("123456789","123456789");
		po="123456798";
	}
	
	@Test
	public void testGetLoginInfo() throws RemoteException{
		assertEquals(impl.GetLoginInfo(log),"123456789");
	}
	
	@Test
	public void testAddUser() throws RemoteException{
		log=new LoginInPO(" ","123456");
		assertEquals(impl.AddUser(log),"000000000");
	}
	
	
	@Test
	public void testGetUserBaseInfo() throws RemoteException{
		assertEquals(impl.GetUserBaseInfo(po),null);
	}

	@Test
	public void testSetUserBaseInfo() throws RemoteException{
		UserInfoPO v=new UserInfoPO("123456798","Lily",new ContactPO("12345678765",null));
		assertEquals(impl.SetUserBaseInfo(po, v),true);
	}
	
	@Test
	public void testaddHotelStuff() throws RemoteException{
		String o="123456";
		assertEquals(impl.addHotelStuff(o,po),true);
	}
	
	public void testaddWebStuff() throws RemoteException{
		po="123546789";
		assertEquals(impl.addWebStuff(po),true);
	}
}
