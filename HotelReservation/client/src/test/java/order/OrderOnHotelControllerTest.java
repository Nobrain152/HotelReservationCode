package order;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.orderbl.OrderOnHotelController;
import po.ContactPO;
import po.CustomerInfoPO;
import po.OrderPO;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;
import vo.ContactVO;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class OrderOnHotelControllerTest {

	private OrderOnHotelController hotelBLServiceImpl;
	ArrayList<OrderVO> hotelList;
	OrderVO order1;
	OrderVO order2;
	OrderVO order3;
	OrderVO order4;
	OrderVO r11;
	ResultMsg r1;
	
	
	@Before
	public void setUp() throws RemoteException {
		order1 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order2 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order3 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order4 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		hotelBLServiceImpl = new OrderOnHotelController();
		//r1 = new ResultMsg(true, "Ö´ÐÐ³É¹¦£¡");
		r1 = ResultMsg.SUCCESS;
		hotelList = new ArrayList<>();
		hotelList.add(order1);
		hotelList.add(order2);
		hotelList.add(order3);
		hotelList.add(order4);
		
		r11 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
	}

	@Test
	public void testHotelOrderScan() throws RemoteException {
		ArrayList<OrderVO> hotels = hotelBLServiceImpl.hotelOrderScan(order1.getHotelID());
		assertEquals(hotels, hotelList);
	}
	
	@Test
	public void testHotelOrderDetail() throws RemoteException{
		OrderVO msg1 = hotelBLServiceImpl.hotelOrderDetail("42654645437");
		assertEquals(msg1, order1);
	}
	
	@Test
	public void testHotelOrderModify() throws RemoteException{
		ResultMsg msg1 = hotelBLServiceImpl.hotelOrderModify(order1);
		//assertEquals(msg1.getMessage(), r1.getMessage());
		assertEquals(msg1, r1);
	}
}
