package credit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.creditbl.CreditController;
import bl.vipbl.VipController;
import util.VipType;
import vo.CommonVipVO;
import vo.ContactVO;
import vo.CustomerInfoVO;

public class CreditControllerTest {
	
	private CreditController creditController;
	CustomerInfoVO user;
	VipController vipController;
	CommonVipVO common;
	
	@Before
	public void setUp() throws Exception {
		creditController = new CreditController();
		vipController = new VipController();
		user = new CustomerInfoVO("09954722", "ÌÆöÎ", "18805156300","sfd",300,true,VipType.COMMON_VIP);
		vipController.registerVip(user.getUserID(), user.getVipType(), "1997-05-13");
	}
	
	@Test
	public void testGetCredit() {
		int credit = creditController.getCredit(user);
		assertEquals(300, credit);
	}
	
	@Test
	public void testAddCredit() {
		creditController.addCredit(user,100);
		assertEquals(400,user.getCredit());
	}
}


