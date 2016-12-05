package order;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.orderbl.OrderOnWebController;
import util.OrderState;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;
import util.VipType;
import vo.ContactVO;
import vo.CustomerInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;

public class OrderOnWebControllerTest {

	OrderOnWebController webBLServiceImpl;
	ArrayList<OrderVO> webList;
	OrderVO web1;
	ResultMsg r1;
	OrderVO msg1;
	
	@Before
	public void setUp(){
		webBLServiceImpl = new OrderOnWebController();
		webList = new ArrayList<OrderVO>();
		web1 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100,true,VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "212", 100, "1234"),1);
		webList.add(web1);
		r1 = ResultMsg.SUCCESS;
		msg1 = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100,true,VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "212", 100, "1234"),1);
	}
	
	@Test
	public void testComplaintListScan() throws RemoteException{
		ArrayList<OrderVO> webs = webBLServiceImpl.complaintListScan();
		assertEquals(webs, webList);
	}
	
	@Test
	public void testComplaintHandle() throws RemoteException{
		ResultMsg msg1 = webBLServiceImpl.complaintHandle(web1,1);
		assertEquals(msg1, r1);
		assertEquals(msg1, r1);
	}
	
	@Test
	public void testAbnormalOrderScan() throws RemoteException{
		ArrayList<OrderVO> webs = webBLServiceImpl.abnormalOrderScan();
		assertEquals(webs, webList);
	}
	
	@Test
	public void testAbnormalOrderDetail() throws RemoteException{
		OrderVO m1 = webBLServiceImpl.abnormalOrderDetail("42654645437");
		assertEquals(m1, web1);
	}

}
