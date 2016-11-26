package user;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.LoginInput;
import vo.LoginInVO;

public class LoginInputControllerTest {

	LoginInVO vo;
	LoginInput im;
		
	@Before
	public void setUp() {
		vo=new LoginInVO("Tom","123456789");
		im=new LoginInput();
	}

	@Test
	public void testLogin() {
		boolean result=im.LogIn(vo);
		assertEquals(result,false);
	}
		
	@Test
	public void testLogout(){
		boolean result=im.LogOut(true);
		assertEquals(result,true);
	}
		
	@Test
	public void testregister(){
	    String result=im.Register(vo);
	    assertEquals(result,"000000001");
	}

}
