package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import bl.hotelbl.HotelReserveController;
import util.Adress;
import util.Area;
import util.OrderState;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;
import util.VipType;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;

public class HotelReserveControllerTest {
	HotelReserveController impl;
	
	HotelInfoVO hotel1;
	HotelInfoVO hotel2;
	
	OrderVO order1;
	OrderVO order2;
	
	OrderVO orderMsg1;
	OrderVO orderMsg2;
	
	ResultMsg reMsg;
	
	
	@Before
	public void setUp() {
		impl = new HotelReserveController();
		
		hotel1=new HotelInfoVO("StarHotel",Adress.NANJING,Area.EAST,5,"It's a wonderful hotel","cafe, garden and so on",
				true,"431543263",1.1,120);
		hotel2=new HotelInfoVO("SunHotel",Adress.NANJING,Area.WEST,4,"It's a nice hotel","cafe",
				false,"452346236",1.1,120);
		
		/*order1 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order2 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);*/
		RoomInfoVO room=new RoomInfoVO(RoomState.UNUSABLE,RoomType.ROOM_STANDARD,"453",1435.0,"5000");
		
		
		ArrayList<String> ro=new ArrayList<String>();
		ro.add("456");
		orderMsg1=new OrderVO("60000004",new CustomerInfoVO("12345678","Jerry","13067893451","12345678",100,false,VipType.COMMON_VIP),OrderState.UNEXECUTED,99.9, "5000",false,"2016-10-02 24:00","2016-10-03 12:00","2016-10-02 12:00",null,1,ro,1,RoomType.ROOM_STANDARD);
		
		//reMsg = new ResultMsg(true, "Ô¤¶¨³É¹¦");
		reMsg = ResultMsg.SUCCESS;
	}
	
	@Test
	public void testreserveHotel(){
		ResultMsg msg = impl.reserveHotel(orderMsg1); 
		//assertEquals(msg.getMessage(), reMsg.getMessage());
		assertEquals(msg, reMsg);
	}
	
	

}
