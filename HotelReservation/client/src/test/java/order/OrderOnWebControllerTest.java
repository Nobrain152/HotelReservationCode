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
		web1 = new OrderVO("201612062014",new CustomerInfoVO("19954722", "ÌÆöÎ", 
				new ContactVO("18805156300", "151250132@smail.nju.edu.cn"), 300, true, VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 99.9, "014", false, 
				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
		webList.add(web1);
		r1 = ResultMsg.SUCCESS;
		msg1 = new OrderVO("201612062014",new CustomerInfoVO("19954722", "ÌÆöÎ", 
				new ContactVO("18805156300", "151250132@smail.nju.edu.cn"), 300, true, VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 99.9, "014", false, 
				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
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
