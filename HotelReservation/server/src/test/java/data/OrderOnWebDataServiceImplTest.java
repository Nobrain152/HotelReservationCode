package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.orderdata.OrderOnWebDataServiceImpl;
import po.OrderOnWebPO;
import util.OrderState;
import util.User;

public class OrderOnWebDataServiceImplTest {

	OrderOnWebDataServiceImpl webDataServiceImpl;
	ArrayList<OrderOnWebPO> list;
	OrderOnWebPO order1;
	OrderOnWebPO order2;
	OrderOnWebPO order3;
	OrderOnWebPO order4;
	
	@Before
	public void setUp(){
		webDataServiceImpl = new OrderOnWebDataServiceImpl();
		order1 = new OrderOnWebPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.UNEXECUTED,105,"火车晚点");
		order2 = new OrderOnWebPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.ABNORMAL,105, "");
		order3 = new OrderOnWebPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.CANCELLED,105, "");
		order4 = new OrderOnWebPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.EXECUTED,105, "");
		list = new ArrayList<OrderOnWebPO>();
	}
	
	@Test
	public void testInsert() throws RemoteException{
		boolean b = webDataServiceImpl.insert(order1);
		assertTrue(b);
	}
	
	@Test
	public void testDelete() throws RemoteException{
		webDataServiceImpl.insert(order1);
		boolean b = webDataServiceImpl.delete(order1);
		assertTrue(b);
	}
	
	@Test
	public void testUpdate() throws RemoteException{
		webDataServiceImpl.insert(order1);
		boolean b = webDataServiceImpl.update(order1);
		assertTrue(b);
	}
	
	@Test
	public void testFind() throws RemoteException{
		webDataServiceImpl.insert(order1);
		webDataServiceImpl.insert(order2);
		ArrayList<OrderOnWebPO> arrayList = webDataServiceImpl.find(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"));
		list.add(order1);
		list.add(order2);
		assertEquals(list.get(0), arrayList.get(0));
		assertEquals(list.get(1), arrayList.get(1));
	}

	@Test
	public void testShow() throws RemoteException{
		webDataServiceImpl.insert(order1);
		webDataServiceImpl.insert(order2);
		webDataServiceImpl.insert(order3);
		webDataServiceImpl.insert(order4);
		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);
		ArrayList<OrderOnWebPO> arrayList = webDataServiceImpl.show();
		assertEquals(list, arrayList);
	}
}
