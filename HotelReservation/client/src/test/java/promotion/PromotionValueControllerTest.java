package promotion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionValueController;
import util.OrderState;
import util.PromotionHotelType;
import util.RoomState;
import util.RoomType;
import util.VipType;
import vo.ContactVO;
import vo.CustomerInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;

public class PromotionValueControllerTest {
	PromotionValueController promotionImpl;
	CustomerInfoVO customerInfoVO;
	OrderVO orderVO;
	
	
	@Before
	public void setUp() throws Exception {
		promotionImpl = new PromotionValueController();
		customerInfoVO = new CustomerInfoVO("0513", "txin", new ContactVO("18805156300", null), 100, true, VipType.COMMON_VIP);
		orderVO = new OrderVO(new CustomerInfoVO("123", "txin", 
				new ContactVO("18805156300", null), 100,true,VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", null,
				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "212", 100, "1234"),1);
	}

	@Test
	public void testGetValue() {
		orderVO = promotionImpl.getValue(customerInfoVO, orderVO,PromotionHotelType.BIRTH_PROMOTION);
		assertEquals(orderVO.getPrice(), 100*0.9,0.01);
	}

}
