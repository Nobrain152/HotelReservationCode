package credit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.creditbl.CreditController;
import vo.ContactVO;
import vo.CreditVO;
import vo.CustomerInfoVO;

public class CreditControllerTest {
	
	private CreditController credit;
	CustomerInfoVO user1 ;
	CustomerInfoVO user2 ;
	
	@Before
	public void setUp() throws Exception {
		user1 = new CustomerInfoVO("10101010", "»Æ¿­ÎÄ", new ContactVO("13270898633", null),100);
		user2 = new CustomerInfoVO("20202020", "»Æ¿­ÎÄ", new ContactVO("13270898633", null),100);
	}
	
	@Test
	public void testChangeCredit() {
		credit = new CreditController();
		credit.changeCredit(user1,100);
		CreditVO user1Ans = new CreditVO(user1.getUserID(),100);
		int user1Int ;
		user1Int = credit.getCredit(user1);
		assertEquals(user1Int,user1Ans);
		
		credit = new CreditController();
		credit.changeCredit(user2,500);
		CreditVO user2Ans = new CreditVO(user1.getUserID(),100);
		int user2Int ;
		user2Int = credit.getCredit(user1);
		assertEquals(user2Int,user2Ans);
		
	}
}


