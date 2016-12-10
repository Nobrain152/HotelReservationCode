package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.HotelInfoMaintainController;
import util.Adress;
import util.Area;
import util.ResultMsg;
import vo.HotelInfoVO;

public class HotelInfoMaintainControllerTest {

	HotelInfoMaintainController impl;
	ArrayList<HotelInfoVO> hotelList;
	HotelInfoVO hotel1;
	HotelInfoVO hotel2;
	HotelInfoVO hotel3;
	
	ResultMsg reMsg;
	
	@Before
	public void setUp() {
		hotel1=new HotelInfoVO("StarHotel",Adress.NANJING,Area.EAST,5,"It's a wonderful hotel","cafe, garden and so on",
				true,"431543263",1.1,120);
		hotel2=new HotelInfoVO("SunHotel",Adress.NANJING,Area.WEST,4,"It's a nice hotel","cafe",
				false,"452346236",1.1,120);
		hotel3=new HotelInfoVO("MoonHotel",Adress.NANJING,Area.NORTH,-1,"It's a terrible hotel","nothing",
				true,"234655754634",1.1,120);
				
				
		impl = new HotelInfoMaintainController();
		
		hotelList = impl.hotelList;
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		
		reMsg = ResultMsg.SUCCESS;
	}
	
	@Test
	public void testinputHotelInfo(){
		ResultMsg msg1 = impl.inputHotelInfo(hotel1);
		assertEquals(msg1, reMsg);
    }
	
	@Test
	public void testcheckInfo(){
		ResultMsg msg = impl.checkInfo(hotel1); 
		//assertEquals(msg.getMessage(), reMsg.getMessage());
		assertEquals(msg, reMsg);
    }


}
