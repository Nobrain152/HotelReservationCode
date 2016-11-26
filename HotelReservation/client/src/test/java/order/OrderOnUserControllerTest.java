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
import util.User;
import vo.OrderOnUserVO;

public class OrderOnUserControllerTest {

	private OrderOnUserController userBLServiceImpl;
	OrderOnUserVO order1;
	OrderOnUserVO order2;
	OrderOnUserVO order3;
	OrderOnUserVO order4;
	ResultMsg r11;
	ResultMsg r22;
	ResultMsg r33;
	ResultMsg r44;
	
	@Before
	public void setUp() throws RemoteException {
		order1 = new OrderOnUserVO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.UNEXECUTED,105, "2016-10-15 24:00",RoomType.ROOM_STANDARD,1,1,false);
		order2 = new OrderOnUserVO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.ABNORMAL,105, "2016-10-16 24:00",RoomType.ROOM_STANDARD,1,1,false);
		order3 = new OrderOnUserVO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.CANCELLED,105, "2016-10-17 24:00",RoomType.ROOM_STANDARD,1,1,false);
		order4 = new OrderOnUserVO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.EXECUTED,105, "2016-10-15 24:00",RoomType.ROOM_STANDARD,1,1,false);
		userBLServiceImpl = new OrderOnUserController();
		userBLServiceImpl.createOrder(order1);
		userBLServiceImpl.createOrder(order2);
		userBLServiceImpl.createOrder(order3);
		userBLServiceImpl.createOrder(order4);
		//r11 = new ResultMsg(true, "撤销成功!");
		//r22 = new ResultMsg(false, "异常订单，不可撤销！");
		//r33 = new ResultMsg(false, "请勿重复操作！");
		//r44 = new ResultMsg(false, "该订单已经执行，不可撤销！");
		r11 = ResultMsg.SUCCESS;
		r22 = ResultMsg.FAIL;
		r33 = ResultMsg.FAIL;
		r44 = ResultMsg.FAIL;
	}
	
	@Test
	public void testPersonalOrderScan() throws RemoteException{
		ArrayList<OrderOnUserVO> userList = userBLServiceImpl.personalOrderScan();
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
		OrderOnUserVO msg1 = userBLServiceImpl.personalOrderDetail("42654645437");
		assertEquals(msg1, order1);
	}
	
}
