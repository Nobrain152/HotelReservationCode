package user;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.WebManagerWebsiteManagementController;
import util.ResultMsg;
import util.UserType;
import vo.UserInfoVO;


public class WebManagerWebsiteManagementControllerTest {

	WebManagerWebsiteManagementController impl;
	UserInfoVO info;
	
	@Before
	public void setUp() {
		impl=new WebManagerWebsiteManagementController();
		info=new UserInfoVO("42345678","Lily","13124567893","666666");
	}

	@Test
	public void testinquiry() {
		UserInfoVO vo=impl.UserInformationInquiry("42345678");
		assertEquals(vo.getUsername(),"LILY");
	}
	
	@Test
	public void testmodify(){
		info.setType(UserType.WebManager);
		assertEquals(impl.UserInformationModification("42345678", info),ResultMsg.SUCCESS);
	}
	
	
	
	@Test
	public void testScan(){
		ArrayList<UserInfoVO> stuff=impl.WebStuffScan();
	    assertEquals(stuff.get(0).getUsername(),"Marry");
	}
}
