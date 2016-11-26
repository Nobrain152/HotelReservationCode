package order;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.orderbl.OrderOnHotel;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;
import util.User;
import vo.OrderOnHotelVO;

public class OrderOnHotelControllerTest {

	private OrderOnHotel hotelBLServiceImpl;
	ArrayList<OrderOnHotelVO> hotelList;
	OrderOnHotelVO order1;
	OrderOnHotelVO order2;
	OrderOnHotelVO order3;
	OrderOnHotelVO order4;
	OrderOnHotelVO r11;
	ResultMsg r1;
	
	
	@Before
	public void setUp() throws RemoteException {
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
		hotelBLServiceImpl = new OrderOnHotel();
		//r1 = new ResultMsg(true, "Ö´ÐÐ³É¹¦£¡");
		r1 = ResultMsg.SUCCESS;
		hotelList = new ArrayList<>();
		hotelList.add(order1);
		hotelList.add(order2);
		hotelList.add(order3);
		hotelList.add(order4);
		
		r11 = new OrderOnHotelVO(order1.getInitiator(), order1.getOrderID(),order1.getOrderState(), order1.getPrice(), 
				order1.getCheckInTime(), order1.getCheckOutTime(), order1.getLatestExecutionTime(), 
				order1.getRoomType(), order1.getRoomNumber(), order1.getPeopleNumber(), order1.getHasChild());
	}

	@Test
	public void testHotelOrderScan() throws RemoteException {
		ArrayList<OrderOnHotelVO> hotels = hotelBLServiceImpl.hotelOrderScan();
		assertEquals(hotels, hotelList);
	}
	
	@Test
	public void testHotelOrderDetail() throws RemoteException{
		OrderOnHotelVO msg1 = hotelBLServiceImpl.hotelOrderDetail("42654645437");
		assertEquals(msg1, order1);
	}
	
	@Test
	public void testHotelOrderModify() throws RemoteException{
		ResultMsg msg1 = hotelBLServiceImpl.hotelOrderModify(order1);
		//assertEquals(msg1.getMessage(), r1.getMessage());
		assertEquals(msg1, r1);
	}
}
