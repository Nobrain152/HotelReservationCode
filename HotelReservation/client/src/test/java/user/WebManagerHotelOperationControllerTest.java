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
	public void testscan(){
	    assertEquals(impl.HotelScan(),null);
	}


}
