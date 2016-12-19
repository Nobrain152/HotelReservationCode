package data;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;
import org.omg.PortableServer.IMPLICIT_ACTIVATION_POLICY_ID;

import data.creatID.CreateID;

public class CreatIDTest {
	CreateID impl;
	
	
	@Before
	public void setup() throws RemoteException{
		impl = CreateID.getCreateID();
	}
	
	@Test
	public void testGetNewCustomerID() throws RemoteException{
		String ans = "10000024";
		assertEquals(impl.getNewCustomerID(),ans);
	}
}
