package credit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.creditbl.CreditController;
import util.VipType;
import vo.ContactVO;
import vo.CustomerInfoVO;

public class CreditControllerTest {
	
	private CreditController creditController;
	CustomerInfoVO user;
	
	@Before
	public void setUp() throws Exception {
		creditController = new CreditController();
		user = new CustomerInfoVO("09954722", "ÌÆöÎ", new ContactVO("18805156300", "151250132@smail.nju.edu.cn"),300,true,VipType.COMMON_VIP);
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


