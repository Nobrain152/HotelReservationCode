package user;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.WebManagerWebsiteManagementController;
import util.ResultMsg;
import util.UserType;
import vo.UserInfoVO;

//pass
public class WebManagerWebsiteManagementControllerTest {

	WebManagerWebsiteManagementController impl;
	UserInfoVO info;
	
	@Before
	public void setUp() {
		impl=new WebManagerWebsiteManagementController();
		info=new UserInfoVO("32345678","LIly","13124567893","666666");
	}

	@Test
	public void testinquiry() {
		UserInfoVO vo=impl.UserInformationInquiry("42345678");
		assertEquals(vo.getUsername(),"LILY");
	}
	
	@Test
	public void testmodify(){
		info.setType(UserType.WebStuff);
		assertEquals(impl.UserInformationModification("32345678", info),ResultMsg.SUCCESS);
	}
	
	
	
	@Test
	public void testScan(){
		ArrayList<UserInfoVO> stuff=impl.WebStuffScan();
	    assertEquals(stuff.get(0).getUsername(),"LILY");
	}
}
