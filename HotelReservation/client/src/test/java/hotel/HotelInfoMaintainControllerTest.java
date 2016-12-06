package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.HotelInfoMaintainController;
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
		hotel1=new HotelInfoVO("StarHotel","StarRoad","StarArea",5,"It's a wonderful hotel","cafe, garden and so on",
				true,"565547657",1.1);
		hotel2=new HotelInfoVO("SunHotel","SunRoad","SunArea",4,"It's a nice hotel","cafe",
				false,"567858756",1.1);
		hotel3=new HotelInfoVO("MoonHotel","MoonRoad","MoonArea",-1,"It's a terrible hotel","nothing",
				true,"56875875456",1.1);
				
				
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
