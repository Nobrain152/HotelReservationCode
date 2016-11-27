package user;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.WebInfoManagementController;
import vo.UserInfoVO;

public class WebInfoManagementControllerTest {

	WebInfoManagementController impl;
	
	@Before
	public void setUp() {
		impl=new WebInfoManagementController();
	}

	@Test
	public void testinquiry() {
		assertEquals(impl.IndividualBaseInfolnquiry("1234567"),null);
	}
	
	@Test
	public void testmodify(){
		UserInfoVO v=new UserInfoVO("123456789","LILY","15160897654");
		assertEquals(impl.IndividualBaseInfoModification("1234567", v),v);
	}
	
	

}
