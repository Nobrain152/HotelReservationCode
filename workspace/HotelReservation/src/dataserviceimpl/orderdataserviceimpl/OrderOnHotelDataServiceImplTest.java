package dataserviceimpl.orderdataserviceimpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.util.User;
import businesslogic.util.OrderState;
import businesslogic.util.RoomType;
import po.OrderOnHotelPO;

public class OrderOnHotelDataServiceImplTest {

	OrderOnHotelDataServiceImpl hotelDataServiceImpl;
	ArrayList<OrderOnHotelPO> list;
	OrderOnHotelPO order1;
	OrderOnHotelPO order2;
	OrderOnHotelPO order3;
	OrderOnHotelPO order4;
	
	@Before
	public void setUp(){
		hotelDataServiceImpl = new OrderOnHotelDataServiceImpl();
		order1 = new OrderOnHotelPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.UNEXECUTED,105,"2016-10-15 12:00","2016-10-16 12:00", "2016-10-15 24:00",
				RoomType.ROOM_STANDARD,1,1,false);
		order2 = new OrderOnHotelPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.ABNORMAL,105, "2016-10-16 12:00","2016-10-17 12:00","2016-10-16 24:00",
				RoomType.ROOM_STANDARD,1,1,false);
		order3 = new OrderOnHotelPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.CANCELLED,105, "2016-10-17 12:00","2016-10-18 12:00","2016-10-17 24:00",
				RoomType.ROOM_STANDARD,1,1,false);
		order4 = new OrderOnHotelPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.EXECUTED,105, "2016-10-18 12:00","2016-10-19 12:00","2016-10-18 24:00",
				RoomType.ROOM_STANDARD,1,1,false);
		list = new ArrayList<>();
	}
	
	@Test
	public void testInsert() throws RemoteException{
		boolean b = hotelDataServiceImpl.insert(order1);
		assertTrue(b);
	}
	
	@Test
	public void testDelete() throws RemoteException{
		hotelDataServiceImpl.insert(order1);
		boolean b = hotelDataServiceImpl.delete(order1);
		assertTrue(b);
	}
	
	@Test
	public void testUpdate() throws RemoteException{
		hotelDataServiceImpl.insert(order1);
		boolean b = hotelDataServiceImpl.update(order1);
		assertTrue(b);
	}
	
	@Test
	public void testFind() throws RemoteException{
		hotelDataServiceImpl.insert(order1);
		hotelDataServiceImpl.insert(order2);
		ArrayList<OrderOnHotelPO> arrayList = hotelDataServiceImpl.find(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"));
		list.add(order1);
		list.add(order2);
		assertEquals(list.get(0), arrayList.get(0));
		assertEquals(list.get(1), arrayList.get(1));
	}

	@Test
	public void testShow() throws RemoteException{
		hotelDataServiceImpl.insert(order1);
		hotelDataServiceImpl.insert(order2);
		hotelDataServiceImpl.insert(order3);
		hotelDataServiceImpl.insert(order4);
		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);
		ArrayList<OrderOnHotelPO> arrayList = hotelDataServiceImpl.show();
		assertEquals(list, arrayList);
	}
}
