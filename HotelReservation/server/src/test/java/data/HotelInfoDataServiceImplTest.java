package data;

import static org.junit.Assert.assertEquals;

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
	public void setUp() throws RemoteException{
		impl = new HotelInfoDataServiceImpl();
		/*hotel1=new HotelInfoPO("1343","StarHotel","StarRoad","StarArea",5,"It's a wonderful hotel","cafe, garden and so on",
				true,66.6,200);
		hotel2=new HotelInfoPO("2352","SunHotel","SunRoad","SunArea",4,"It's a nice hotel","cafe",
				false,77.77,100);
		hotel3=new HotelInfoPO("4353","MoonHotel","MoonRoad","MoonArea",-1,"It's a terrible hotel","nothing",
				true,88.88,300);
				*/
		
		list = new ArrayList<HotelInfoPO>();
	}
	/*
	@Test
	public void testInsert() throws RemoteException{
		ResultMsg b = impl.insert(hotel2);
		ResultMsg c = impl.insert(hotel3);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	/*
	@Test
	public void testDelete() throws RemoteException{
		impl.insert(hotel1);
		ResultMsg b = impl.delete(hotel1.getHotelID());
		assertEquals(b, ResultMsg.SUCCESS);
		}
	/*
	@Test
	public void testUpdate() throws RemoteException{
		impl.insert(hotel1);
		hotel1.setName("adsfklasjfl ");;
		ResultMsg b = impl.update(hotel1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testFind() throws RemoteException{
		//impl.insert(hotel1);
		//impl.insert(hotel2);
		HotelInfoPO arrayList = impl.find("1343");
		list.add(hotel1);
		list.add(hotel2);
		assertEquals(hotel1.getIsReserved(), arrayList.getIsReserved());
		//HotelInfoPO arrayList2 = impl.find("2352");
		//assertEquals(list.get(1), arrayList2);
	}
*/
	@Test
	public void testShow() throws RemoteException{
		//impl.insert(hotel1);
		//impl.insert(hotel2);
		//impl.insert(hotel3);
		list.add(hotel1);
		list.add(hotel2);
		list.add(hotel3);
		ArrayList<HotelInfoPO> arrayList = impl.show();
		System.out.println(arrayList.get(0).getAddress());
		assertEquals(list.get(0).getName(), arrayList.get(0).getName());
	}

}
