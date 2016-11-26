package hotel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.HotelReserveController;
import util.OrderOnUserMsg;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;
import util.User;
import vo.HotelInfoVO;
import vo.OrderOnUserVO;

public class HotelReserveControllerTest {
	HotelReserveController impl;
	
	HotelInfoVO hotel1;
	HotelInfoVO hotel2;
	
	OrderOnUserVO order1;
	OrderOnUserVO order2;
	
	OrderOnUserMsg orderMsg1;
	OrderOnUserMsg orderMsg2;
	
	ResultMsg reMsg;
	
	
	@Before
	public void setUp() {
		impl = new HotelReserveController();
		
		hotel1=new HotelInfoVO("StarHotel","StarRoad","StarArea",5,"It's a wonderful hotel","cafe, garden and so on",
				true);
		hotel2=new HotelInfoVO("SunHotel","SunRoad","SunArea",4,"It's a nice hotel","cafe",
				false);
		
		order1 = new OrderOnUserVO(new User("GYF",100,"15150158583","151250047@smail.nju.edu.cn"),"42654645438",
				OrderState.UNEXECUTED,105, "2016-10-15 24:00",RoomType.ROOM_STANDARD,1,1,true);
		order2 = new OrderOnUserVO(new User("GYF",100,"15150158583","151250047@smail.nju.edu.cn"),"42654645438",
				OrderState.ABNORMAL,105, "2016-10-16 24:00",RoomType.ROOM_BUSINESS,1,1,false);
		
		orderMsg1=new OrderOnUserMsg(new User("GYF",100,"15150158583","151250047@smail.nju.edu.cn"),"42654645438",
				OrderState.UNEXECUTED,105, "2016-10-15 24:00",RoomType.ROOM_STANDARD,1,1,true);
		orderMsg2 = new OrderOnUserMsg(new User("GYF",100,"15150158583","151250047@smail.nju.edu.cn"),"42654645438",
				OrderState.ABNORMAL,105, "2016-10-16 24:00",RoomType.ROOM_BUSINESS,1,1,false);
		
		
		//reMsg = new ResultMsg(true, "Ô¤¶¨³É¹¦");
		reMsg = ResultMsg.SUCCESS;
	}
	
	@Test
	public void testreserveHotel(){
		ResultMsg msg = impl.reserveHotel(hotel1); 
		//assertEquals(msg.getMessage(), reMsg.getMessage());
		assertEquals(msg, reMsg);
	}
	
	@Test
	public void testcreateUserOrder(){
		OrderOnUserMsg msg1 = impl.createUserOrder(order1);
		assertEquals(order1.getInitiator(), msg1.getInitiator());
		assertEquals(order1.getOrderState(), msg1.getOrderState());
		assertEquals(order1.getPrice(), msg1.getPrice());
		assertEquals(order1.getLatestExecutionTime(), msg1.getLatestExecutionTime());
		assertEquals(order1.getRoomType(), msg1.getRoomType());
		assertEquals(order1.getRoomNumber(), msg1.getRoomNumber());
		assertEquals(order1.getPeopleNumber(), msg1.getPeopleNumber());
		assertEquals(order1.getHasChild(), msg1.getHasChild());
    }

}
