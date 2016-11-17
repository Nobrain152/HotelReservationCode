package businesslogicserviceimpl.userblserviceimpl;


import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import vo.LoginInputVO;

public class LoginInputBLServiceImplTest {

	
		
		LoginInputVO vo;
		LoginInputBLServiceImpl im;
		
		@Before
		public void setUp() {
			vo=new LoginInputVO("Tom","123456789");
			im=new LoginInputBLServiceImpl();
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
