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
	public void testmodify(){
		UserInfoVO v=new UserInfoVO("42345678","LILY","15160897654","6666");
		impl.IndividualBaseInfoModification("42345678", v);
		assertEquals(v.getUsername(),"LILY");
	}
	
	

}
