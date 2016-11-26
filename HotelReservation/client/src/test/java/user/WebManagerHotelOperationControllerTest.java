package user;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.WebManagerHotelOperation;
import vo.HotelIDVO;
import vo.UserIDVO;

public class WebManagerHotelOperationControllerTest {

	WebManagerHotelOperation impl;
	UserIDVO vo1;
	String vo2;
	
	@Before
	public void setUp() {
		impl=new WebManagerHotelOperation();
		vo1=new UserIDVO("123456789");
		vo2="123456";
	}

	@Test
	public void testHotelAdd() {
		
	}
	
	@Test
	public void testStuffAdd(){
		assertEquals(impl.StuffAdd(vo2, vo1),true);
	}
	
	@Test
	public void testscan(){
	    assertEquals(impl.HotelScan(),null);
	}


}
