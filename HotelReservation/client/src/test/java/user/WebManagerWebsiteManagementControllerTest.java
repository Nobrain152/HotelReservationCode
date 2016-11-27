package user;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.WebManagerWebsiteManagementController;
import vo.ContactVO;
import vo.UserInfoVO;


public class WebManagerWebsiteManagementControllerTest {

	WebManagerWebsiteManagementController impl;
	UserInfoVO info;
	
	@Before
	public void setUp() {
		impl=new WebManagerWebsiteManagementController();
		info=new UserInfoVO("123456789","Lily",new ContactVO("13124567893",null));
	}

	@Test
	public void testinquiry() {
		assertEquals(impl.UserInformationInquiry("1234567"),info);
	}
	
	@Test
	public void testmodify(){
		assertEquals(impl.UserInformationModification("1234567", info),true);
	}
	
	@Test
	public void testaddStuff(){
	    assertEquals(impl.WebsiteStuffAdd("1234567"),true);
	}
	
	@Test
	public void testScan(){
	    assertEquals(impl.WebStuffScan(),null);
	}
}
