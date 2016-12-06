package data;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthStyle;

import org.junit.Before;
import org.junit.Test;

import datafactory.DataFactory;
import dataservice.orderdataservice.OrderDataService;
import po.ContactPO;
import po.CustomerInfoPO;
import po.OrderPO;
import po.RoomInfoPO;
import util.MyDate;
import util.OrderState;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;
import util.VipType;

public class OrderDataServiceImplTest {

	OrderDataService dataServiceImpl;
	ArrayList<OrderPO> list;
	OrderPO order1;
	OrderPO order2;
	OrderPO order3;
	OrderPO order4;
	
	@Before
	public void setUp() throws RemoteException{
		dataServiceImpl = DataFactory.getDataFactory().getOrderDataServiceImpl();
		
		order1 = new OrderPO("100001", new CustomerInfoPO("151250058","hkw", 
				new ContactPO("13270898633", "814335296@qq.com"), 200, true,
				VipType.COMPANY_VIP), OrderState.UNEXECUTED,
				666.66, "151250", false, MyDate.toString(MyDate.getNowTime()),
				MyDate.toString(MyDate.getNowTime()), MyDate.toString(MyDate.getNowTime()),
				MyDate.toString(MyDate.getNowTime()),
				1, 1, new RoomInfoPO(RoomState.USABLE, RoomType.ROOM_BIGBED, 
				"3B323", 1000, "151250"));
		
		order2 = new OrderPO("100010", new CustomerInfoPO("151250058","hkw", 
				new ContactPO("13270898633", "814335296@qq.com"), 200, true,
				VipType.COMPANY_VIP), OrderState.UNEXECUTED,
				666.66, "151250", false, MyDate.toString(MyDate.getNowTime()),
				MyDate.toString(MyDate.getNowTime()), MyDate.toString(MyDate.getNowTime()),
				MyDate.toString(MyDate.getNowTime()),
				1, 1, new RoomInfoPO(RoomState.USABLE, RoomType.ROOM_BIGBED, 
				"3B323", 1000, "151250"));
		/*order1 = new OrderPO("100001", new CustomerInfoPO("151250058", "withoutBrain",
				new CreditPO("2016-11-11", "151250058", Action.Executed, 
				"creditChange", 200),100, false, VipType.COMMON_VIP), orderState, price, "1512500", false, 
				latestExecutionTime, checkInTime, checkOutTime, cancelledTime, 
				roomNumber, peopleNumber, roomInfoPO);
		*/
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
	/*
	@Test
	public void testInsert() throws RemoteException{
		ResultMsg b = dataServiceImpl.insert(order1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testInsert2() throws RemoteException{
		ResultMsg b = dataServiceImpl.insert(order2);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	/*
	@Test
	public void testDelete() throws RemoteException{
		dataServiceImpl.insert(order1);
		dataServiceImpl.insert(order2);
		ResultMsg b = dataServiceImpl.delete(order1.getOrderID());
		assertEquals(b, ResultMsg.SUCCESS);
	}
	*/
	@Test
	public void testUpdate() throws RemoteException{
		dataServiceImpl.insert(order1);
		order1.setCheckOutTime("456123456");
		ResultMsg b = dataServiceImpl.update(order1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	/*
	public void testFindByOrderID() throws RemoteException{
		dataServiceImpl.insert(order1);
		dataServiceImpl.insert(order2);
		OrderPO order = dataServiceImpl.findByOrderID("100010");
	}
	*/
	/*
	@Test
	public void testFindByOrderID() throws RemoteException{
		dataServiceImpl.insert(order1);
		dataServiceImpl.insert(order2);
		System.out.println("³É¹¦");
		OrderPO arrayList = dataServiceImpl.findByOrderID(order1.getOrderID());
		System.out.println(arrayList.getHotelID());
		dataServiceImpl.delete(order1.getOrderID());
		dataServiceImpl.delete(order2.getOrderID());
		assertEquals(arrayList.getHotelID(), order1.getHotelID());
	}
	
	/*
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
	*/
}
