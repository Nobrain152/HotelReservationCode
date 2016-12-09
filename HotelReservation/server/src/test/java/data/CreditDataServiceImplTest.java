package data;

import static org.junit.Assert.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import data.creditdata.CreditDataServiceImpl;
import po.CreditPO;
import util.Action;

public class CreditDataServiceImplTest {
	
	CreditDataServiceImpl impl;
	ArrayList<CreditPO> pos;
	CreditPO credit1,credit2,credit3;
	private ArrayList<CreditPO> ans;
	
	@Before
	public void setUp() throws RemoteException{
		impl = new CreditDataServiceImpl();
		credit1 = new CreditPO("151250058", "一百号", "2016-12-09-08-00", Action.Executed,
					"+100", 5000);
		credit2 = new CreditPO("151250059", "一百零一", "2016-12-09-08-00", Action.Executed,
				"+100", 5000);
		credit3 = new CreditPO("151250058", "一百零一", "2016-12-09-08-00", Action.Executed,
				"+100", 5000);
		pos = new ArrayList<CreditPO>();
	}
	
	@Test
	public void testgetListByOrderID() throws RemoteException{
		//impl.insert(credit1);
		//impl.insert(credit2);
		//impl.insert(credit3);
		pos = impl.getListByUserID("151250058");
		ans = null;
		ans.add(credit2);
		ans.add(credit3);
		System.out.println(pos.get(0).getUserID());
		System.out.println(ans.get(0).getUserID());
		assertEquals(pos.get(0).getUserID(), ans.get(0).getUserID());
	}
	/*
	@Test
	public void testshow() throws RemoteException{
		pos = impl.show();
		System.out.println(pos.get(0).getUserID());
		ans= new ArrayList<CreditPO>();
		ans.add(credit1);
		assertEquals(pos.get(0).getUserID(), ans.get(0).getUserID());
	}*/

}
