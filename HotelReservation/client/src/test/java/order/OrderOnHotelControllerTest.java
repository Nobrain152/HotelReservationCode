package order;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.orderbl.OrderOnHotelController;
import util.OrderOnHotelMsg;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;
import util.User;
import vo.OrderOnHotelVO;

public class OrderOnHotelControllerTest {

	private OrderOnHotelController hotelBLServiceImpl;
	ArrayList<OrderOnHotelVO> hotelList;
	OrderOnHotelVO order1;
	OrderOnHotelVO order2;
	OrderOnHotelVO order3;
	OrderOnHotelVO order4;
	OrderOnHotelMsg r11;
	ResultMsg r1;
	
	
	@Before
	public void setUp() {
		order1 = new OrderOnHotelVO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.UNEXECUTED,105,"2016-10-15 12:00","2016-10-16 12:00", "2016-10-15 24:00",
				RoomType.ROOM_STANDARD,1,1,false);
		order2 = new OrderOnHotelVO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.ABNORMAL,105, "2016-10-16 12:00","2016-10-17 12:00","2016-10-16 24:00",
				RoomType.ROOM_STANDARD,1,1,false);
		order3 = new OrderOnHotelVO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.CANCELLED,105, "2016-10-17 12:00","2016-10-18 12:00","2016-10-17 24:00",
				RoomType.ROOM_STANDARD,1,1,false);
		order4 = new OrderOnHotelVO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.EXECUTED,105, "2016-10-18 12:00","2016-10-19 12:00","2016-10-18 24:00",
				RoomType.ROOM_STANDARD,1,1,false);
		hotelBLServiceImpl = new OrderOnHotelController();
		r1 = new ResultMsg(true, "Ö´ÐÐ³É¹¦£¡");
		hotelList = OrderOnHotelController.hotelList;
		hotelList.add(order1);
		hotelList.add(order2);
		hotelList.add(order3);
		hotelList.add(order4);
		
		r11 = new OrderOnHotelMsg(order1.getInitiator(), order1.getOrderID(),order1.getOrderState(), order1.getPrice(), 
				order1.getCheckInTime(), order1.getCheckOutTime(), order1.getLatestExecutionTime(), 
				order1.getRoomType(), order1.getRoomNumber(), order1.getPeopleNumber(), order1.getHasChild());
	}

	@Test
	public void testHotelOrderScan() {
		ArrayList<OrderOnHotelVO> hotels = hotelBLServiceImpl.hotelOrderScan();
		assertEquals(hotels, hotelList);
	}
	
	@Test
	public void testHotelOrderDetail(){
		OrderOnHotelMsg msg1 = hotelBLServiceImpl.hotelOrderDetail(order1);
		assertEquals(msg1.getCheckInTime(), r11.getCheckInTime());
		assertEquals(msg1.getCheckOutTime(), r11.getCheckOutTime());
		assertEquals(msg1.getHasChild(), r11.getHasChild());
		assertEquals(msg1.getInitiator(), r11.getInitiator());
		assertEquals(msg1.getLatestExecutionTime(), r11.getLatestExecutionTime());
		assertEquals(msg1.getOrderState(), r11.getOrderState());
		assertEquals(msg1.getPeopleNumber(), r11.getPeopleNumber());
		assertEquals(msg1.getPrice() , r11.getPrice());
		assertEquals(msg1.getRoomNumber(), r11.getRoomNumber());
		assertEquals(msg1.getRoomType(), r11.getRoomType());
	}
	
	@Test
	public void testHotelOrderModify(){
		ResultMsg msg1 = hotelBLServiceImpl.hotelOrderModify(order1);
		assertEquals(msg1.getMessage(), r1.getMessage());
	}
}
