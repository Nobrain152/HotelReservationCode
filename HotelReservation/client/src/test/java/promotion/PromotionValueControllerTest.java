package promotion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionValueController;
import util.OrderState;
import util.PromotionHotelType;
import util.RoomType;
import util.VipType;
import vo.ContactVO;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class PromotionValueControllerTest {
	PromotionValueController promotionImpl;
	CustomerInfoVO customerInfoVO;
	OrderVO orderVO;
	
	
	@Before
	public void setUp() throws Exception {
		promotionImpl = new PromotionValueController();
		customerInfoVO = new CustomerInfoVO("0513", "txin", new ContactVO("18805156300", null), 100, true, VipType.COMMON_VIP);
		orderVO = new OrderVO(customerInfoVO, OrderState.UNEXECUTED, 100, "2016/12/02", "18805156300", false, "2016/12/02", "2016/12/02", "2016/12/03", 1, 1, RoomType.ROOM_STANDARD);
	}

	@Test
	public void testGetValue() {
		orderVO = promotionImpl.getValue(customerInfoVO, orderVO,PromotionHotelType.BIRTH_PROMOTION);
		assertEquals(orderVO.getPrice(), 100*0.9,0.01);
	}

}
