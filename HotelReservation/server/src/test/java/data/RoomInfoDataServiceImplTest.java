package data;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.hoteldata.RoomInfoDataServiceImpl;
import po.RoomInfoPO;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;

public class RoomInfoDataServiceImplTest {

	RoomInfoDataServiceImpl impl;
	ArrayList<RoomInfoPO> list;
	RoomInfoPO room1;
	RoomInfoPO room2;
	RoomInfoPO room3;
	RoomInfoPO room4;
	
	@Before
	public void setUp(){
		impl = new RoomInfoDataServiceImpl();
		room1=new RoomInfoPO(RoomState.USABLE,RoomType.ROOM_STANDARD,"231",1599,"1234567");
		room2=new RoomInfoPO(RoomState.UNUSABLE,RoomType.ROOM_STANDARD,"453",1435,"1234567");
		room3=new RoomInfoPO(RoomState.USABLE,RoomType.ROOM_BIGBED,"455",233,"1234567");
		room4=new RoomInfoPO(RoomState.USABLE,RoomType.ROOM_PRESIDENTIAL,"435",159999,"1234567");
		list = new ArrayList<RoomInfoPO>();
	}
	
	@Test
	public void testInsert() throws RemoteException{
		ResultMsg b = impl.insert(room1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testDelete() throws RemoteException{
		impl.insert(room1);
		ResultMsg b = impl.delete(room1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testUpdate() throws RemoteException{
		impl.insert(room1);
		ResultMsg b = impl.update(room1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testFind() throws RemoteException{
		impl.insert(room1);
		impl.insert(room2);
		ArrayList<RoomInfoPO> arrayList = impl.find(new RoomInfoPO(RoomState.USABLE,RoomType.ROOM_PRESIDENTIAL,"322",159999,"1234567"));
		list.add(room1);
		list.add(room2);
		assertEquals(list.get(0), arrayList.get(0));
		assertEquals(list.get(1), arrayList.get(1));
	}

	@Test
	public void testShow() throws RemoteException{
		impl.insert(room1);
		impl.insert(room2);
		impl.insert(room3);
		impl.insert(room4);
		list.add(room1);
		list.add(room2);
		list.add(room3);
		list.add(room4);
		ArrayList<RoomInfoPO> arrayList = impl.show();
		assertEquals(list, arrayList);
	}
}
