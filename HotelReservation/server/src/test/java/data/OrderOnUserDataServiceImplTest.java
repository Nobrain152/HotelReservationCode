package data;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.orderdata.OrderOnUserDataServiceImpl;
import po.OrderOnUserPO;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;
import util.User;

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
		order1 = new OrderOnUserPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.UNEXECUTED,105,"2016-10-15 24:00",RoomType.ROOM_STANDARD,1,1,false);
		order2 = new OrderOnUserPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.ABNORMAL,105, "2016-10-16 24:00",RoomType.ROOM_STANDARD,1,1,false);
		order3 = new OrderOnUserPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.CANCELLED,105,"2016-10-17 24:00",RoomType.ROOM_STANDARD,1,1,false);
		order4 = new OrderOnUserPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.EXECUTED,105,"2016-10-18 24:00",RoomType.ROOM_STANDARD,1,1,false);
		list = new ArrayList<OrderOnUserPO>();
	}
	
	@Test
	public void testInsert() throws RemoteException{
		ResultMsg b = userDataServiceImpl.insert(order1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testDelete() throws RemoteException{
		userDataServiceImpl.insert(order1);
		ResultMsg b = userDataServiceImpl.delete(order1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testUpdate() throws RemoteException{
		userDataServiceImpl.insert(order1);
		ResultMsg b = userDataServiceImpl.update(order1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testFindByName() throws RemoteException{
		userDataServiceImpl.insert(order1);
		userDataServiceImpl.insert(order2);
		ArrayList<OrderOnUserPO> arrayList = userDataServiceImpl.findByName("txin");
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
