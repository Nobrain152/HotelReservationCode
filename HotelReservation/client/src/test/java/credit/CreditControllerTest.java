package credit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.creditbl.CreditController;
import util.VipType;
import vo.ContactVO;
import vo.CustomerInfoVO;

public class CreditControllerTest {
	
	private CreditController credit;
	CustomerInfoVO user1 ;
	CustomerInfoVO user2 ;
	
	@Before
	public void setUp() throws Exception {
		user1 = new CustomerInfoVO("10101010", "»Æ¿­ÎÄ", new ContactVO("13270898633", null),100,true,VipType.COMMON_VIP);
		user2 = new CustomerInfoVO("20202020", "»Æ¿­ÎÄ", new ContactVO("13270898633", null),100,true,VipType.COMMON_VIP);
	}
	
	@Test
	public void testAddCredit() {
		credit = new CreditController();
		credit.addCredit(user1,100);
		assertEquals(200,user1.getCredit());
		
		credit = new CreditController();
		credit.addCredit(user2,500);
		assertEquals(600,user2.getCredit());
		
	}
}


