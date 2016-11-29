package promotion;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionHotel;
import vo.PromotionHotelVO;
import util.PromotionHotelType;
import util.VipType;

public class PromotionHotelControllerTest {
	
	PromotionHotel hotel;
	PromotionHotelVO hotel1,hotel2,hotel3;
	
	
	@Before
	public void setUp() throws Exception {
		//hotel1 = new PromotionHotelVO("七天",PromotionHotelType.BIRTH_PROMOTION,VipType.COMMON_VIP, null, null, 0.8);
		//hotel2 = new PromotionHotelVO("七天",PromotionHotelType.OVERTHREE_PROMOTION,VipType.COMMON_VIP, null, null, 0.7);
		//hotel3 = new PromotionHotelVO("七天",PromotionHotelType.HOTEL_CUSTOM_PROMOTION,VipType.COMMON_VIP,"2016/11/05", "2016/11/11", 0.5);
		//hotel要添加增加方法
		//hotel.addBirthCut(1, hotel1.getRatio());
		//hotel.addOverCut(3, hotel2.getRatio());
		//hotel.addHotelCustomCut(hotel3.getTimeBegin(), hotel3.getTimeOver(), hotel3.getRatio());
	}

	@Test
	public void testgetHotelPromotion() throws RemoteException {
		//ArrayList<PromotionHotelVO> hotelProList1 = hotel.getHotelPromotion(PromotionHotelType.BIRTH_PROMOTION);
		ArrayList<PromotionHotelVO> hotelProAnsList1 = new ArrayList<PromotionHotelVO>();
		hotelProAnsList1.add(hotel1);
		//assertEquals(hotelProList1,hotelProAnsList1);
		
		//ArrayList<PromotionHotelVO> hotelProList2 = hotel.getHotelPromotion(PromotionHotelType.OVERTHREE_PROMOTION);
		ArrayList<PromotionHotelVO> hotelProAnsList2 = new ArrayList<PromotionHotelVO>();
		hotelProAnsList2.add(hotel2);
		//assertEquals(hotelProList2,hotelProAnsList2);
		
		//ArrayList<PromotionHotelVO> hotelProList3 = hotel.getHotelPromotion(PromotionHotelType.HOTEL_CUSTOM_PROMOTION);
		ArrayList<PromotionHotelVO> hotelProAnsList3 = new ArrayList<PromotionHotelVO>();
		hotelProAnsList3.add(hotel3);
		//assertEquals(hotelProList3,hotelProAnsList3);
	}

}
