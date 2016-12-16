package user;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.LoginInputController;
import vo.LoginInVO;
import vo.UserInfoVO;

public class LoginInputControllerTest {

	
		
		LoginInVO vo;
		LoginInputController im;
		
		@Before
		public void setUp() {
			vo=new LoginInVO("Tom","123456789");
			im=new LoginInputController();
		}

		@Test
		public void testLogin() {
			boolean result=im.LogIn("12345679","25f9e794323b453885f5181f1b624d0b");
			assertEquals(result,true);
		}
		
		@Test
		public void testLogout(){
			boolean result=im.LogOut(true);
			assertEquals(result,true);
		}
		
		@Test
		public void testregister(){
			UserInfoVO vo=new UserInfoVO();
		    String result=im.Register(vo);
		    //assertEquals(result,"000000001");
		}
	

}
