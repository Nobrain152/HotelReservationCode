package data;


import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.userdata.CustomerManagementDataServiceImpl;
import po.CustomerInfoPO;
import util.VipType;

public class CustomerManagementDataServiceImplTest {

	CustomerManagementDataServiceImpl impl;
	String id;
	CustomerInfoPO po ;
	
	@Before
	public void setUp(){
		//impl=new CustomerManagementDataServiceImpl();
		po = new CustomerInfoPO("19954722", "ÌÆöÎ", "18805156300", "sfd", 300, true, VipType.COMMON_VIP);
	}
	
	
	
	@Test
	public void testAddMember() throws RemoteException{
		//assertEquals(impl.AddMembers(id),true);
	}
	
	@Test
	public void testGetCustomerOrders() throws RemoteException{
		
	}
	
	
	

	@Test
	public void testGetCustomerHotel() throws RemoteException{
	}
}
