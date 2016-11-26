package credit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.creditbl.Credit;
import vo.ContactVO;
import vo.CreditVO;
import vo.UserInfoVO;

public class CreditControllerTest {
	
	private Credit integral;
	UserInfoVO user1 ;
	UserInfoVO user2 ;
	
	@Before
	public void setUp() throws Exception {
		user1 = new UserInfoVO("10101010", "»Æ¿­ÎÄ", new ContactVO("13270898633", null));
		user2 = new UserInfoVO("20202020", "»Æ¿­ÎÄ", new ContactVO("13270898633", null));
	}
	
	@Test
	public void testChangeIntegral() {
		integral = new Credit();
		integral.changeIntegral(user1,100);
		CreditVO user1Ans = new CreditVO(user1.getUserID(),100,null);
		CreditVO user1Int ;
		user1Int = integral.getIntegral(user1);
		assertEquals(user1Int,user1Ans);
		
		integral = new Credit();
		integral.changeIntegral(user2,500);
		CreditVO user2Ans = new CreditVO(user1.getUserID(),100,null);
		CreditVO user2Int ;
		user2Int = integral.getIntegral(user1);
		assertEquals(user2Int,user2Ans);
		
	}
}


