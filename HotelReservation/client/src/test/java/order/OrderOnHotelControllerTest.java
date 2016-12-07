package order;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.orderbl.OrderOnHotelController;
import bl.orderbl.OrderOnUserController;
import blservice.orderblservice.OrderOnHotelBLService;
import blservice.orderblservice.OrderOnUserBLService;
import util.OrderState;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;
import util.VipType;
import vo.ContactVO;
import vo.CustomerInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;

public class OrderOnHotelControllerTest {

	private OrderOnHotelBLService onHotelBLService;
	private OrderOnUserBLService onUserBLService;
	ArrayList<OrderVO> hotelList;
	OrderVO order1;
//	OrderVO order2;
//	OrderVO order3;
//	OrderVO order4;
	OrderVO testOrder;
	ResultMsg resultMsg;
	
	
	@Before
	public void setUp() throws RemoteException {
		order1 = new OrderVO("201612062014", new CustomerInfoVO("19954722", "ÌÆöÎ", 
				new ContactVO("18805156300", "151250132@smail.nju.edu.cn"), 300, true, VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 99.9, "014", false, 
				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
//		order2 = new OrderVO(new CustomerInfoVO("19954722", "ÌÆöÎ", 
//				new ContactVO("18805156300", "151250132@smail.nju.edu.cn"), 300, true, VipType.COMMON_VIP), 
//				OrderState.UNEXECUTED, 99.9, "201612062014", "014", false, 
//				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
//				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);		
//		order3 = new OrderVO(new CustomerInfoVO("19954722", "ÌÆöÎ", 
//						new ContactVO("18805156300", "151250132@smail.nju.edu.cn"), 300, true, VipType.COMMON_VIP), 
//						OrderState.UNEXECUTED, 99.9, "201612062014", "014", false, 
//						"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
//						1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);		
//		order4 = new OrderVO(new CustomerInfoVO("19954722", "ÌÆöÎ", 
//								new ContactVO("18805156300", "151250132@smail.nju.edu.cn"), 300, true, VipType.COMMON_VIP), 
//								OrderState.UNEXECUTED, 99.9, "201612062014", "014", false, 
//								"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
//								1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
//		
		onHotelBLService = new OrderOnHotelController();
		onUserBLService = new OrderOnUserController();
		onUserBLService.createOrder(order1);
		resultMsg = ResultMsg.SUCCESS;
		hotelList = new ArrayList<OrderVO>();
		hotelList.add(order1);
//		hotelList.add(order2);
//		hotelList.add(order3);
//		hotelList.add(order4);
		
		testOrder = new OrderVO("201612062014",new CustomerInfoVO("19954722", "ÌÆöÎ", 
				new ContactVO("18805156300", "151250132@smail.nju.edu.cn"), 300, true, VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 99.9, "014", false, 
				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
	}

//	@Test
//	public void testHotelOrderScan() throws RemoteException {
//		ArrayList<OrderVO> hotels = onHotelBLService.hotelOrderScan(order1.getHotelID());
//		assertEquals(hotels, hotelList);
//	}
//	
//	@Test
//	public void testHotelOrderDetail() throws RemoteException{
//		OrderVO msg1 = onHotelBLService.hotelOrderDetail("201612062014");
//		assertEquals(msg1, order1);
//	}
//	
//	@Test
//	public void testHotelOrderModify() throws RemoteException{
//		ResultMsg msg1 = onHotelBLService.hotelOrderModify(order1);
//		assertEquals(msg1, resultMsg);
//	}

}
