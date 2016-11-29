package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.HotelInfoCheckController;
import util.HotelMsg;
import vo.HotelInfoVO;

public class HotelInfoCheckControllerTest {

	HotelInfoCheckController impl;
	ArrayList<HotelInfoVO> hotelList;
	HotelInfoVO hotel1;
	HotelInfoVO hotel2;
	HotelInfoVO hotel3;
	
	HotelMsg hotelMsg;
	
	
	
	@Before
	public void setUp() {
		hotel1=new HotelInfoVO("StarHotel","StarRoad","StarArea",5,"It's a wonderful hotel","cafe, garden and so on",
				true,"431543263");
		hotel2=new HotelInfoVO("SunHotel","SunRoad","SunArea",4,"It's a nice hotel","cafe",
				false,"452346236");
		hotel3=new HotelInfoVO("MoonHotel","MoonRoad","MoonArea",-1,"It's a terrible hotel","nothing",
				true,"234655754634");
				
				
		impl = new HotelInfoCheckController();
		
		hotelList = impl.hotelList;
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		
		
		hotelMsg = new HotelMsg(hotel1.getName(),hotel1.getAddress(),hotel1.getArea(),hotel1.getLevel(),
				hotel1.getIntroduction(),hotel1.getFacility(),hotel1.getIsReserved());
	}
	
	@Test
	public void testcheckHotelInfo(){
		HotelInfoVO msg1 = impl.checkHotelInfo(hotel1.getHotelID());
		assertEquals(msg1, hotelMsg.getName());
		
    }

}
