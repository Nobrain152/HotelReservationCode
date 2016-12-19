package credit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.creditbl.CreditController;
import bl.vipbl.VipController;
import util.ResultMsg;
import util.VipType;
import vo.CommonVipVO;
import vo.CreditVO;
import vo.CustomerInfoVO;

public class CreditControllerTest {
	
	private CreditController creditController;
	CustomerInfoVO user;
	VipController vipController;
	CommonVipVO common;
	ResultMsg resultMsg;
	
	@Before
	public void setUp() throws Exception {
		creditController = new CreditController();
		vipController = new VipController();
		user = new CustomerInfoVO("19954722", "ÌÆöÎ", "18805156300","sfd",300,true,VipType.COMMON_VIP);
		//vipController.registerVip(user.getUserID(), user.getVipType(), "1997-05-13");
	}
	
	@Test
	public void testGetCredit() {
		int credit = creditController.getCredit(user);
		assertEquals(300, credit);
	}
	
	@Test
	public void testAddCredit() {
		resultMsg = creditController.addCredit(user,100);
		assertEquals(resultMsg,ResultMsg.SUCCESS);
	}
//	
//	@Test
//	public void testSubCredit() {
//		creditController.subCredit(user, 100);
//		assertEquals(200, user.getCredit());
//	}
//	
//	@Test
//	public void testChangeCredit() {
//		creditController.changeCredit(user, 100);
//		assertEquals(100, user.getCredit());
//	}
//	
//	@Test
//	public void testGetCreditList() {
//		ArrayList<CreditVO> vos = creditController.getCreditList(user.getUserID());
//		assertEquals(vos.get(0).getCreditResult(), 300);
//	}
}


