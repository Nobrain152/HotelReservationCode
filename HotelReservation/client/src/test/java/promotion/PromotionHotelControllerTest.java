package promotion;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionHotelController;
import blservice.promotionblservice.PromotionHotelBLService;
import vo.PromotionHotelVO;
import util.PromotionHotelType;
import util.ResultMsg;

public class PromotionHotelControllerTest {
	
	PromotionHotelBLService hotel;
	PromotionHotelVO hotel11,hotel12,hotel2,hotel3,hotel41,hotel42;
	ResultMsg resultMsg;
	
	
	@Before
	public void setUp() throws Exception {
		hotel = new PromotionHotelController();
		hotel11 = new PromotionHotelVO(PromotionHotelType.BIRTH_PROMOTION, "5000", 3, 0.85);
		hotel12 = new PromotionHotelVO(PromotionHotelType.BIRTH_PROMOTION, "5000", 1, 0.95);
		hotel2 = new PromotionHotelVO(PromotionHotelType.JOIN_PROMOTION, "5000", "software", 0.95);
		hotel3 = new PromotionHotelVO(PromotionHotelType.HOTEL_CUSTOM_PROMOTION, "5000", "2016-12-25 00:00", "2016-12-25 24:00", 0.77);
		hotel41 = new PromotionHotelVO(PromotionHotelType.OVERTHREE_PROMOTION, "5000", 3, 0.95);
		hotel42 = new PromotionHotelVO(PromotionHotelType.OVERTHREE_PROMOTION, "5000", 4, 0.9);
	}

	@Test
	public void testgetHotelPromotion() throws RemoteException {
		ArrayList<PromotionHotelVO> hotelProList1 = hotel.getHotelPromotion(PromotionHotelType.BIRTH_PROMOTION,"5000");
		ArrayList<PromotionHotelVO> hotelProAnsList1 = new ArrayList<PromotionHotelVO>();
		hotelProAnsList1.add(hotel12);
		hotelProAnsList1.add(hotel11);
		assertEquals(hotelProList1.get(0).getRatio(),hotelProAnsList1.get(0).getRatio(),0.01);
		assertEquals(hotelProList1.get(1).getRatio(),hotelProAnsList1.get(1).getRatio(),0.01);
		assertEquals(hotelProList1.size(), 2);
		
		ArrayList<PromotionHotelVO> hotelProList2 = hotel.getHotelPromotion(PromotionHotelType.OVERTHREE_PROMOTION,"5000");
		ArrayList<PromotionHotelVO> hotelProAnsList2 = new ArrayList<PromotionHotelVO>();
		hotelProAnsList2.add(hotel41);
		hotelProAnsList2.add(hotel42);
		assertEquals(hotelProList2.get(0).getRatio(),hotelProAnsList2.get(0).getRatio(),0.01);
		assertEquals(hotelProList2.get(1).getRatio(),hotelProAnsList2.get(1).getRatio(),0.01);
		assertEquals(hotelProList2.size(), 2);
		
		ArrayList<PromotionHotelVO> hotelProList3 = hotel.getHotelPromotion(PromotionHotelType.HOTEL_CUSTOM_PROMOTION,"5000");
		assertEquals(hotelProList3.get(0).getTimeBegin(),hotel3.getTimeBegin());
		
		ArrayList<PromotionHotelVO> hotelProList4 = hotel.getHotelPromotion(PromotionHotelType.JOIN_PROMOTION,"5000");
		assertEquals(hotelProList4.get(0).getBusinessName(), hotel2.getBusinessName());
	}
	
	@Test
	public void testChangeBirthCut() throws RemoteException{
		resultMsg = hotel.changeBirthCut(1, 0.99, "5000");
		double ratio = 1.00;
		ArrayList<PromotionHotelVO> vos = hotel.getHotelPromotion(PromotionHotelType.BIRTH_PROMOTION, "5000");
		for(PromotionHotelVO vo : vos){
			if(vo.getLevel() == 1){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.99, 0.01);
	}
	
//	@Test 
//	public void testAddBirthCut() throws RemoteException{
//		resultMsg = hotel.addBirthCut(hotel1.getNumber(), hotel1.getRatio(),hotel1.getHotelID());
//		double ratio = 1.00;
//		ArrayList<PromotionHotelVO> vos = hotel.getHotelPromotion(PromotionHotelType.BIRTH_PROMOTION, "5000");
//		for(PromotionHotelVO vo : vos){
//			if(vo.getLevel() == 3){
//				ratio = vo.getRatio();
//				break;
//			}
//		}
//		assertEquals(ratio, 0.9, 0.01);
//	}
	
//	@Test
//	public void testDeleteBirthCut() throws RemoteException{
//		resultMsg = hotel.deleteBirthCut(2, "5000");
//		ArrayList<PromotionHotelVO> vos = hotel.getHotelPromotion(PromotionHotelType.BIRTH_PROMOTION, "5000");
//		assertEquals(vos.size(), 0);
//	}

}
