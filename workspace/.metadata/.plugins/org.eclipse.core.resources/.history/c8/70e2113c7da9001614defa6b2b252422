package dataserviceimpl.orderdataserviceimpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.util.User;
import businesslogic.util.OrderState;
import businesslogic.util.RoomType;
import po.OrderOnUserPO;

public class OrderOnUserDataServiceImplTest {

	OrderOnUserDataServiceImpl userDataServiceImpl;
	ArrayList<OrderOnUserPO> list;
	OrderOnUserPO order1;
	OrderOnUserPO order2;
	OrderOnUserPO order3;
	OrderOnUserPO order4;
	
	@Before
	public void setUp(){
		userDataServiceImpl = new OrderOnUserDataServiceImpl();
		order1 = new OrderOnUserPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),
				OrderState.UNEXECUTED,105,"2016-10-15 24:00",RoomType.ROOM_STANDARD,1,1,false);
		order2 = new OrderOnUserPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),
				OrderState.ABNORMAL,105, "2016-10-16 24:00",RoomType.ROOM_STANDARD,1,1,false);
		order3 = new OrderOnUserPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),
				OrderState.CANCELLED,105,"2016-10-17 24:00",RoomType.ROOM_STANDARD,1,1,false);
		order4 = new OrderOnUserPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),
				OrderState.EXECUTED,105,"2016-10-18 24:00",RoomType.ROOM_STANDARD,1,1,false);
		list = new ArrayList<>();
	}
	
	@Test
	public void testInsert() throws RemoteException{
		boolean b = userDataServiceImpl.insert(order1);
		assertTrue(b);
	}
	
	@Test
	public void testDelete() throws RemoteException{
		userDataServiceImpl.insert(order1);
		boolean b = userDataServiceImpl.delete(order1);
		assertTrue(b);
	}
	
	@Test
	public void testUpdate() throws RemoteException{
		userDataServiceImpl.insert(order1);
		boolean b = userDataServiceImpl.update(order1);
		assertTrue(b);
	}
	
	@Test
	public void testFind() throws RemoteException{
		userDataServiceImpl.insert(order1);
		userDataServiceImpl.insert(order2);
		ArrayList<OrderOnUserPO> arrayList = userDataServiceImpl.find(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"));
		list.add(order1);
		list.add(order2);
		assertEquals(list.get(0), arrayList.get(0));
		assertEquals(list.get(1), arrayList.get(1));
	}

	@Test
	public void testShow() throws RemoteException{
		userDataServiceImpl.insert(order1);
		userDataServiceImpl.insert(order2);
		userDataServiceImpl.insert(order3);
		userDataServiceImpl.insert(order4);
		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);
		ArrayList<OrderOnUserPO> arrayList = userDataServiceImpl.show();
		assertEquals(list, arrayList);
	}
}
