package data;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.orderdata.OrderDataServiceImpl;
import po.ContactPO;
import po.CustomerInfoPO;
import po.OrderPO;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;

public class OrderDataServiceImplTest {

	OrderDataServiceImpl dataServiceImpl;
	ArrayList<OrderPO> list;
	OrderPO order1;
	OrderPO order2;
	OrderPO order3;
	OrderPO order4;
	
	@Before
	public void setUp(){
		dataServiceImpl = new OrderDataServiceImpl();
		/*order1 = new OrderPO(new CustomerInfoPO("123", "txin", 
				new ContactPO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order2 = new OrderPO(new CustomerInfoPO("123", "txin", 
				new ContactPO("18805156300", null), 100), 
				OrderState.ABNORMAL, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order3 = new OrderPO(new CustomerInfoPO("123", "txin", 
				new ContactPO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order4 = new OrderPO(new CustomerInfoPO("123", "txin", 
				new ContactPO("18805156300", null), 100), 
				OrderState.CANCELLED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);*/
		list = new ArrayList<OrderPO>();
	}
	
	@Test
	public void testInsert() throws RemoteException{
		ResultMsg b = dataServiceImpl.insert(order1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testDelete() throws RemoteException{
		dataServiceImpl.insert(order1);
		ResultMsg b = dataServiceImpl.delete(order1.getHotelID());
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testUpdate() throws RemoteException{
		dataServiceImpl.insert(order1);
		ResultMsg b = dataServiceImpl.update(order1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testFindByOrderID() throws RemoteException{
		dataServiceImpl.insert(order1);
		dataServiceImpl.insert(order2);
		ArrayList<OrderPO> arrayList = dataServiceImpl.findByUserID("45234");
		list.add(order1);
		list.add(order2);
		assertEquals(list.get(0), arrayList.get(0));
		assertEquals(list.get(1), arrayList.get(1));
	}

	@Test
	public void testFindByUserID() throws RemoteException{
		dataServiceImpl.insert(order1);
		dataServiceImpl.insert(order2);
		ArrayList<OrderPO> arrayList = dataServiceImpl.findByUserID("45234");
		list.add(order1);
		list.add(order2);
		assertEquals(list.get(0), arrayList.get(0));
		assertEquals(list.get(1), arrayList.get(1));
	}
	
	@Test
	public void testFindByHotelID() throws RemoteException{
		dataServiceImpl.insert(order1);
		dataServiceImpl.insert(order2);
		ArrayList<OrderPO> arrayList = dataServiceImpl.findByUserID("45234");
		list.add(order1);
		list.add(order2);
		assertEquals(list.get(0), arrayList.get(0));
		assertEquals(list.get(1), arrayList.get(1));
	}
	
	@Test
	public void testShowList() throws RemoteException{
		dataServiceImpl.insert(order1);
		dataServiceImpl.insert(order2);
		dataServiceImpl.insert(order3);
		dataServiceImpl.insert(order4);
		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);
		ArrayList<OrderPO> arrayList = dataServiceImpl.showList();
		assertEquals(list, arrayList);
	}
}
