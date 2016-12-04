package order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.orderbl.OrderOnUserController;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;
import util.VipType;
import vo.ContactVO;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class OrderOnUserControllerTest {

	private OrderOnUserController userBLServiceImpl;
	OrderVO order1;
	OrderVO order2;
	OrderVO order3;
	OrderVO order4;
	ResultMsg r11;
	ResultMsg r22;
	ResultMsg r33;
	ResultMsg r44;
	
	@Before
	public void setUp() throws RemoteException {
		order1 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100,true,VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order2 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100,true,VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order3 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100,true,VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order4 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100,true,VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		userBLServiceImpl = new OrderOnUserController();
		userBLServiceImpl.createOrder(order1);
		userBLServiceImpl.createOrder(order2);
		userBLServiceImpl.createOrder(order3);
		userBLServiceImpl.createOrder(order4);
		r11 = ResultMsg.SUCCESS;
		r22 = ResultMsg.FAIL;
		r33 = ResultMsg.FAIL;
		r44 = ResultMsg.FAIL;
	}
	
	@Test
	public void testPersonalOrderScan() throws RemoteException{
		ArrayList<OrderVO> userList = userBLServiceImpl.personalOrderScan(null);
		assertEquals(order1,userList.get(0));
		assertEquals(order2,userList.get(1));
		assertEquals(order3,userList.get(2));
		assertEquals(order4,userList.get(3));
	}
	
	@Test
	public void testPersonalOrderCancel() throws RemoteException{
		ResultMsg r1 = userBLServiceImpl.personalOrderCancel(order1);
		ResultMsg r2 = userBLServiceImpl.personalOrderCancel(order2);
		ResultMsg r3 = userBLServiceImpl.personalOrderCancel(order3);
		ResultMsg r4 = userBLServiceImpl.personalOrderCancel(order4);
		assertSame(r11, r1);
		assertSame(r22, r2);
		assertSame(r33, r3);
		assertSame(r44, r4);
		assertSame(r11, r1);
		assertSame(r22, r2);
		assertSame(r33, r3);
		assertSame(r44, r4);
	}
	
	@Test
	public void testPersonalOrderDetail() throws RemoteException{
		OrderVO msg1 = userBLServiceImpl.personalOrderDetail("42654645437");
		assertEquals(msg1, order1);
	}
	
}
