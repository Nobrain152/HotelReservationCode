package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.HotelSearchController;
import util.ResultMsg;
import vo.HotelInfoVO;

public class HotelSearchControllerTest {

	HotelSearchController impl;
	ArrayList<HotelInfoVO> hotelList;
	HotelInfoVO hotel1;
	HotelInfoVO hotel2;
	HotelInfoVO hotel3;
	
	ResultMsg hotelMsg;
	
	
	
	@Before
	public void setUp() {
		hotel1=new HotelInfoVO("StarHotel","StarRoad","StarArea",5,"It's a wonderful hotel","cafe, garden and so on",
				true,"3453");
		hotel2=new HotelInfoVO("SunHotel","SunRoad","SunArea",4,"It's a nice hotel","cafe",
				false,"546");
		hotel3=new HotelInfoVO("MoonHotel","MoonRoad","MoonArea",-1,"It's a terrible hotel","nothing",
				true,"4536");
				
				
		impl = new HotelSearchController();
		
		hotelList = impl.hotelList;
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		
		
		hotelMsg = ResultMsg.SUCCESS;
	}
	
	@Test
	public void testselectCondition(){
		ArrayList<HotelInfoVO> msg1 = impl.selectCondition(hotel1);
		assertEquals(msg1.get(0).getName(), hotelMsg);
	}
	
	@Test
	public void showList(){
		ArrayList<HotelInfoVO> hotels =impl. selectCondition(hotel1);
		assertEquals(hotels, hotelList);
    }

}
