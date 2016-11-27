package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.RoomAddController;
import util.ResultMsg;
import util.RoomMsg;
import util.RoomState;
import util.RoomType;
import vo.RoomInfoVO;

public class RoomAddControllerTest {

	RoomAddController impl;
	ArrayList<RoomInfoVO> roomList;
	RoomInfoVO room1;
	RoomInfoVO room2;
	RoomInfoVO room3;
	RoomInfoVO room4;
	
	RoomMsg roomMsg;
	ResultMsg reMsg1;
	ResultMsg reMsg2;
	
	
	
	@Before
	public void setUp() {
		room1=new RoomInfoVO(RoomState.USABLE,RoomType.ROOM_STANDARD,"5",1599);
		room2=new RoomInfoVO(RoomState.UNUSABLE,RoomType.ROOM_STANDARD,"10",1435);
		room3=new RoomInfoVO(RoomState.USABLE,RoomType.ROOM_BIGBED,"02",233);
		room4=new RoomInfoVO(RoomState.USABLE,RoomType.ROOM_PRESIDENTIAL,"22",159999);
				
				
		impl = new RoomAddController();
		
		roomList = impl.roomList;
		roomList.add(room1);
		roomList.add(room2);
		roomList.add(room3);
		roomList.add(room4);
		
		
		roomMsg = new RoomMsg(RoomState.USABLE,RoomType.ROOM_STANDARD,5,1599);
		//reMsg1=new ResultMsg(true,"添加成功");
		//reMsg2=new ResultMsg(false,"添加失败");
		reMsg1 = ResultMsg.SUCCESS;
		reMsg2 = ResultMsg.FAIL;
	}

	@Test
	public  void  testaddRoom(){
		ResultMsg msg1 = impl.addRoom(room1);
		assertEquals(msg1, roomMsg);
		
	}
	
	@Test
	public void testupdateRoom(){
		ResultMsg msg1 = impl.updateRoom(room1); 
		//assertEquals(msg1.getMessage(), reMsg1.getMessage());
		assertEquals(msg1, reMsg1);
		ResultMsg msg2 = impl.updateRoom(room2); 
		//assertEquals(msg2.getMessage(), reMsg2.getMessage());
		assertEquals(msg2, reMsg2);
    }
}
