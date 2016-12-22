package order;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.orderbl.OrderOnUserController;
import blservice.orderblservice.OrderOnUserBLService;
import util.OrderState;
import util.ResultMsg;
//import util.RoomState;
//import util.RoomType;
import util.VipType;
import vo.CustomerInfoVO;
import vo.OrderVO;
//import vo.RoomInfoVO;

public class OrderOnUserControllerTest {

	private OrderOnUserBLService onUserBLService;
	OrderVO order1;
	OrderVO order2;
	OrderVO order3;
	OrderVO order4;
//	ResultMsg resultMsg;
//	ResultMsg r22;
//	ResultMsg r33;
//	ResultMsg r44;
	
	@Before
	public void setUp() throws RemoteException {
		order1 = new OrderVO("20161002", new CustomerInfoVO("19954722", "ÌÆöÎ", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 99.9, "5000", false, 
				"2016-12-20 15:00", "2016-12-20 12:00", "2016-12-21 12:00", null,
				1, null,1);
		order2 = new OrderVO("20161005", new CustomerInfoVO("19954722", "ÌÆöÎ", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 99.9, "5000", false, 
				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
				1, null,1);
		order3 = new OrderVO("20161004", new CustomerInfoVO("19954722", "ÌÆöÎ", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.ABNORMAL, 99.9, "014", false, 
				"2016-10-04 24:00", "2016-10-03 12:00", "2016-10-04 12:00", null,
				1, null,1);
		order4 = new OrderVO("20161003", new CustomerInfoVO("19954722", "ÌÆöÎ", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.EXECUTED, 99.9, "5000", false, 
				"2016-10-03 24:00", "2016-10-03 12:00", "2016-10-04 12:00", null,
				1, null,1);
	
		onUserBLService = new OrderOnUserController();
//		onUserBLService.createOrder(order1);
//		onUserBLService.createOrder(order2);
//		onUserBLService.createOrder(order3);
//		onUserBLService.createOrder(order4);
//		resultMsg = ResultMsg.SUCCESS;
//		r22 = ResultMsg.FAIL;
//		r33 = ResultMsg.FAIL;
//		r44 = ResultMsg.FAIL;
	}
	
	@Test
	public void testPersonalOrderScan() throws RemoteException{
		ArrayList<OrderVO> userList = onUserBLService.personalOrderScan("19954722");
		assertEquals(order1.getCheckInTime(),userList.get(0).getCheckInTime());
//		assertEquals(order2,userList.get(1));
//		assertEquals(order3,userList.get(3));
//		assertEquals(order4,userList.get(4));
	}
	
	@Test
	public void testPersonalOrderCancel() throws RemoteException{
		ResultMsg r1 = onUserBLService.personalOrderCancel(order1);
		assertEquals(ResultMsg.SUCCESS, r1);
//		ResultMsg r2 = onUserBLService.personalOrderCancel(order2);
		ResultMsg r3 = onUserBLService.personalOrderCancel(order3);
		assertEquals(ResultMsg.FAIL, r3);
		ResultMsg r4 = onUserBLService.personalOrderCancel(order4);
		assertEquals(ResultMsg.FAIL, r4);
//		assertSame(resultMsg, r1);
//		assertSame(r22, r2);
//		assertSame(r33, r3);
//		assertSame(r44, r4);
//		assertSame(resultMsg, r1);
//		assertSame(r22, r2);
//		assertSame(r33, r3);
//		assertSame(r44, r4);
	}
	
	@Test
	public void testPersonalOrderDetail() throws RemoteException{
		OrderVO msg1 = onUserBLService.personalOrderDetail("20161002");
		assertEquals(msg1.getCheckInTime(), order1.getCheckInTime());
	}
	
//	@Test
//	public void testCreateOrder() throws RemoteException{
//		ResultMsg result = onUserBLService.createOrder(order2);
//		assertEquals(ResultMsg.SUCCESS, result);
//	}
	
}
