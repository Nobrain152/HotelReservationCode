package order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.orderbl.OrderOnUserController;
import blservice.orderblservice.OrderOnUserBLService;
import util.OrderState;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;
import util.VipType;
import vo.CustomerInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;

public class OrderOnUserControllerTest {

	private OrderOnUserBLService onUserBLService;
	OrderVO order1;
	OrderVO order2;
	OrderVO order3;
	OrderVO order4;
	ResultMsg resultMsg;
	ResultMsg r22;
	ResultMsg r33;
	ResultMsg r44;
	
	@Before
	public void setUp() throws RemoteException {
		order1 = new OrderVO("201612162014",new CustomerInfoVO("19954722", "ÌÆöÎ", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 99.9, "014", false, 
				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
		order2 = new OrderVO("201612262014",new CustomerInfoVO("19954722", "ÌÆöÎ", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.ABNORMAL, 99.9, "014", false, 
				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
		order3 = new OrderVO("201612362014",new CustomerInfoVO("19954722", "ÌÆöÎ", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.CANCELLED, 99.9, "014", false, 
				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
		order4 = new OrderVO("201612462014",new CustomerInfoVO("19954722", "ÌÆöÎ", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.EXECUTED, 99.9, "014", false, 
				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
	
		onUserBLService = new OrderOnUserController();
		onUserBLService.createOrder(order1);
		onUserBLService.createOrder(order2);
		onUserBLService.createOrder(order3);
		onUserBLService.createOrder(order4);
		resultMsg = ResultMsg.SUCCESS;
		r22 = ResultMsg.FAIL;
		r33 = ResultMsg.FAIL;
		r44 = ResultMsg.FAIL;
	}
	
	@Test
	public void testPersonalOrderScan() throws RemoteException{
		ArrayList<OrderVO> userList = onUserBLService.personalOrderScan("19954722");
		assertEquals(order1,userList.get(0));
		assertEquals(order2,userList.get(1));
		assertEquals(order3,userList.get(2));
		assertEquals(order4,userList.get(3));
	}
	
	@Test
	public void testPersonalOrderCancel() throws RemoteException{
		ResultMsg r1 = onUserBLService.personalOrderCancel(order1);
		ResultMsg r2 = onUserBLService.personalOrderCancel(order2);
		ResultMsg r3 = onUserBLService.personalOrderCancel(order3);
		ResultMsg r4 = onUserBLService.personalOrderCancel(order4);
		assertSame(resultMsg, r1);
		assertSame(r22, r2);
		assertSame(r33, r3);
		assertSame(r44, r4);
		assertSame(resultMsg, r1);
		assertSame(r22, r2);
		assertSame(r33, r3);
		assertSame(r44, r4);
	}
	
	@Test
	public void testPersonalOrderDetail() throws RemoteException{
		OrderVO msg1 = onUserBLService.personalOrderDetail("201612162014");
		assertEquals(msg1, order1);
	}
	
	@Test
	public void testCreateOrder() throws RemoteException{
		ResultMsg result = onUserBLService.createOrder(order1);
		assertEquals(resultMsg, result);
	}
	
}
