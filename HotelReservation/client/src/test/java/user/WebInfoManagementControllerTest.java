package user;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.WebInfoManagement;
import vo.UserIDVO;
import vo.UserInfoVO;

public class WebInfoManagementControllerTest {

	WebInfoManagement impl;
	UserIDVO vo;
	
	@Before
	public void setUp() {
		vo=new UserIDVO("123456789");
		impl=new WebInfoManagement(vo);
	}

	@Test
	public void testinquiry() {
		assertEquals(impl.IndividualBaseInfolnquiry(vo),null);
	}
	
	@Test
	public void testmodify(){
		UserInfoVO v=new UserInfoVO("123456789","LILY","15160897654");
		assertEquals(impl.IndividualBaseInfoModification(vo, v),v);
	}
	
	

}
