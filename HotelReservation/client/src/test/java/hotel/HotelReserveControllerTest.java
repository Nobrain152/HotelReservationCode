package hotel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.HotelReserveController;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderVO;

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
		
		hotel1=new HotelInfoVO("StarHotel","StarRoad","StarArea",5,"It's a wonderful hotel","cafe, garden and so on",
				true,"587",1.1,121);
		hotel2=new HotelInfoVO("SunHotel","SunRoad","SunArea",4,"It's a nice hotel","cafe",
				false,"7868",1.1,121);
		
		/*order1 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order2 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		orderMsg1=new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		orderMsg2 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		*/
		
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
