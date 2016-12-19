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
import vo.CustomerInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;

public class OrderOnHotelControllerTest {

	private OrderOnHotelBLService onHotelBLService;
	private OrderOnUserBLService onUserBLService;
	ArrayList<OrderVO> hotelList;
	OrderVO order1;
	OrderVO order2;
	OrderVO order3;
	OrderVO order4;
	OrderVO testOrder;
	ResultMsg resultMsg;
	
	
	@Before
	public void setUp() throws RemoteException {
		order1 = new OrderVO("201612162014", new CustomerInfoVO("19954722", "����", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 99.9, "014", false, 
				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
		order2 = new OrderVO("201612112014", new CustomerInfoVO("19954722", "����", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.CANCELLED, 99.9, "014", false, 
				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
		order3 = new OrderVO("201612262014", new CustomerInfoVO("19954722", "����", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.ABNORMAL, 99.9, "014", false, 
				"2016-12-09 24:00", "2016-12-09 12:00", "2016-12-10 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
		order4 = new OrderVO("201612462014", new CustomerInfoVO("19954722", "����", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.EXECUTED, 99.9, "014", false, 
				"2016-12-10 24:00", "2016-12-10 12:00", "2016-12-11 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
		onHotelBLService = new OrderOnHotelController();
		onUserBLService = new OrderOnUserController();
		onUserBLService.createOrder(order1);
		
		resultMsg = ResultMsg.SUCCESS;
		
		hotelList = new ArrayList<OrderVO>();
		hotelList.add(order1);
		hotelList.add(order2);
		hotelList.add(order3);
		hotelList.add(order4);
		
		testOrder = new OrderVO("201612062014",new CustomerInfoVO("19954722", "����","sdf", 
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 99.9, "014", false, 
				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
	}

	@Test
	public void testHotelOrderScan() throws RemoteException {
		ArrayList<OrderVO> hotels = onHotelBLService.hotelOrderScan("014");
		assertEquals(hotels, hotelList);
	}
	
	@Test
	public void testHotelOrderDetail() throws RemoteException{
		OrderVO order = onHotelBLService.hotelOrderDetail("201612162014");
		assertEquals(order, order1);
	}
	
	@Test
	public void testHotelOrderModify() throws RemoteException{
		onHotelBLService.hotelOrderModify(order1);
		assertEquals(order1.getOrderState(), OrderState.EXECUTED);
	}

}
