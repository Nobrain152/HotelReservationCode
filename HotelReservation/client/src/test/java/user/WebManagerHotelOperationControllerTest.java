package user;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.WebManagerHotelOperationController;

public class WebManagerHotelOperationControllerTest {

	WebManagerHotelOperationController impl;
	
	@Before
	public void setUp() {
		impl=new WebManagerHotelOperationController();
	
	}

	@Test
	public void testHotelAdd() {
		
	}
	
	@Test
	public void testStuffAdd(){
		assertEquals(impl.StuffAdd("1234567", "1234567"),true);
	}
	
	@Test
	public void testscan(){
	    assertEquals(impl.HotelScan(),null);
	}


}
