package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.hoteldata.HotelInfoDataServiceImpl;
import po.HotelInfoPO;

public class HotelInfoDataServiceImplTest {

	HotelInfoDataServiceImpl impl;
	ArrayList<HotelInfoPO> list;
	HotelInfoPO hotel1;
	HotelInfoPO hotel2;
	HotelInfoPO hotel3;
	HotelInfoPO hotel4;
	
	@Before
	public void setUp(){
		impl = new HotelInfoDataServiceImpl();
		hotel1=new HotelInfoPO("StarHotel","StarRoad","StarArea",5,"It's a wonderful hotel","cafe, garden and so on",
				true);
		hotel2=new HotelInfoPO("SunHotel","SunRoad","SunArea",4,"It's a nice hotel","cafe",
				false);
		hotel3=new HotelInfoPO("MoonHotel","MoonRoad","MoonArea",-1,"It's a terrible hotel","nothing",
				true);
		
		list = new ArrayList<>();
	}
	
	@Test
	public void testInsert() throws RemoteException{
		boolean b = impl.insert(hotel1);
		assertTrue(b);
	}
	
	@Test
	public void testDelete() throws RemoteException{
		impl.insert(hotel1);
		boolean b = impl.delete(hotel1);
		assertTrue(b);
	}
	
	@Test
	public void testUpdate() throws RemoteException{
		impl.insert(hotel1);
		boolean b = impl.update(hotel1);
		assertTrue(b);
	}
	
	@Test
	public void testFind() throws RemoteException{
		impl.insert(hotel1);
		impl.insert(hotel2);
		ArrayList<HotelInfoPO> arrayList = impl.find(new HotelInfoPO("SunHotel","SunRoad","SunArea",4,"It's a nice hotel","cafe",
				false));
		list.add(hotel1);
		list.add(hotel2);
		assertEquals(list.get(0), arrayList.get(0));
		assertEquals(list.get(1), arrayList.get(1));
	}

	@Test
	public void testShow() throws RemoteException{
		impl.insert(hotel1);
		impl.insert(hotel2);
		impl.insert(hotel3);
		list.add(hotel1);
		list.add(hotel2);
		list.add(hotel3);
		ArrayList<HotelInfoPO> arrayList = impl.show();
		assertEquals(list, arrayList);
	}

}
