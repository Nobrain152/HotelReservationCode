package promotion;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionHotelController;
import vo.PromotionHotelVO;
import util.PromotionHotelType;

public class PromotionHotelControllerTest {
	
	PromotionHotelController hotel;
	PromotionHotelVO hotel1,hotel2,hotel3;
	
	
	@Before
	public void setUp() throws Exception {
		hotel1 = new PromotionHotelVO(PromotionHotelType.BIRTH_PROMOTION, "12345678", 1, 0.9);
		hotel2 = new PromotionHotelVO(PromotionHotelType.JOIN_PROMOTION, "12345678", "wr", 0.95);
		hotel3 = new PromotionHotelVO(PromotionHotelType.HOTEL_CUSTOM_PROMOTION, "12345678", "2016/12/02", "2016/12/09", 0.88);
		hotel.addBirthCut(1, hotel1.getRatio(),"12345678");
		hotel.addOverCut(3, hotel2.getRatio(),"12345678");
		hotel.addHotelCustomCut(hotel3.getTimeBegin(), hotel3.getTimeOver(), hotel3.getRatio(),"12345678");
	}

	@Test
	public void testgetHotelPromotion() throws RemoteException {
		ArrayList<PromotionHotelVO> hotelProList1 = hotel.getHotelPromotion(PromotionHotelType.BIRTH_PROMOTION,"12345678");
		ArrayList<PromotionHotelVO> hotelProAnsList1 = new ArrayList<PromotionHotelVO>();
		hotelProAnsList1.add(hotel1);
		assertEquals(hotelProList1.get(0).getType(),hotelProAnsList1.get(0).getType());
		
//		ArrayList<PromotionHotelVO> hotelProList2 = hotel.getHotelPromotion(PromotionHotelType.OVERTHREE_PROMOTION,"12345678");
//		ArrayList<PromotionHotelVO> hotelProAnsList2 = new ArrayList<PromotionHotelVO>();
//		hotelProAnsList2.add(hotel2);
//		assertEquals(hotelProList2,hotelProAnsList2);
//		
//		ArrayList<PromotionHotelVO> hotelProList3 = hotel.getHotelPromotion(PromotionHotelType.HOTEL_CUSTOM_PROMOTION,"12345678");
//		ArrayList<PromotionHotelVO> hotelProAnsList3 = new ArrayList<PromotionHotelVO>();
//		hotelProAnsList3.add(hotel3);
//		assertEquals(hotelProList3,hotelProAnsList3);
	}
	
	@Test
	

}
