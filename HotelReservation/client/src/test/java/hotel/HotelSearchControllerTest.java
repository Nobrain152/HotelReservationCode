package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.HotelSearchController;
import util.Adress;
import util.Area;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.RoomInfoVO;

public class HotelSearchControllerTest {

	HotelSearchController impl;
	ArrayList<HotelInfoVO> hotelList;
	HotelInfoVO hotel1;
	HotelInfoVO hotel2;
	HotelInfoVO hotel3;
	RoomInfoVO roomInfoVO;
	
	ResultMsg hotelMsg;
	
	
	
	@Before
	public void setUp() {
		hotel1=new HotelInfoVO("StarHotel",Adress.NANJING,Area.EAST,5,"It's a wonderful hotel","cafe, garden and so on",
				true,"431543263",1.1,120);
		hotel2=new HotelInfoVO("SunHotel",Adress.NANJING,Area.WEST,4,"It's a nice hotel","cafe",
				false,"452346236",1.1,120);
		hotel3=new HotelInfoVO("MoonHotel",Adress.NANJING,Area.NORTH,-1,"It's a terrible hotel","nothing",
				true,"234655754634",1.1,120);
				
				
		impl = new HotelSearchController();
		
		hotelList = impl.hotelList;
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		
		
		hotelMsg = ResultMsg.SUCCESS;
	}
	
	@Test
	public void testselectCondition(){
		ArrayList<HotelInfoVO> msg1 = impl.selectCondition(hotel1,roomInfoVO);
		assertEquals(msg1.get(0).getName(), hotelMsg);
	}
	
	@Test
	public void showList(){
		ArrayList<HotelInfoVO> hotels =impl. selectCondition(hotel1,roomInfoVO);
		assertEquals(hotels, hotelList);
    }

}
