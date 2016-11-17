package user;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.WebManagerWebsiteManagementController;
import vo.UserIDVO;
import vo.UserInfoVO;


public class WebManagerWebsiteManagementControllerTest {

	WebManagerWebsiteManagementController impl;
	UserIDVO id;
	UserInfoVO info;
	
	@Before
	public void setUp() {
		impl=new WebManagerWebsiteManagementController();
		id=new UserIDVO("123456789");
		info=new UserInfoVO("123456789","Lily","13124567893");
	}

	@Test
	public void testinquiry() {
		assertEquals(impl.UserInformationInquiry(id),info);
	}
	
	@Test
	public void testmodify(){
		assertEquals(impl.UserInformationModification(id, info),true);
	}
	
	@Test
	public void testaddStuff(){
	    assertEquals(impl.WebsiteStuffAdd(id),true);
	}
	
	@Test
	public void testScan(){
	    assertEquals(impl.WebStuffScan(),null);
	}
}
