package promotion;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionHotelController;
import dataservice.promotiondataservice.PromotionHotelDataService;
import po.PromotionHotelPO;
import vo.PromotionHotelVO;
import util.PromotionHotelType;
import util.ResultMsg;

public class PromotionHotelControllerTest {
	
	PromotionHotelController hotel;
	PromotionHotelDataService promotionHotelDataService;
	PromotionHotelVO hotel1,hotel2,hotel3,hotel4;
	ResultMsg resultMsg;
	
	
	@Before
	public void setUp() throws Exception {
		hotel1 = new PromotionHotelVO(PromotionHotelType.BIRTH_PROMOTION, "12345678", 1, 0.9);
		hotel2 = new PromotionHotelVO(PromotionHotelType.JOIN_PROMOTION, "12345678", "wr", 0.95);
		hotel3 = new PromotionHotelVO(PromotionHotelType.HOTEL_CUSTOM_PROMOTION, "12345678", "2016/12/02", "2016/12/09", 0.88);
		hotel4 = new PromotionHotelVO(PromotionHotelType.OVERTHREE_PROMOTION, "12345678", 3, 0.98);
//		hotel.addBirthCut(1, hotel1.getRatio(),"12345678");
//		hotel.addOverCut(3, hotel2.getRatio(),"12345678");
//		hotel.addHotelCustomCut(hotel3.getTimeBegin(), hotel3.getTimeOver(), hotel3.getRatio(),"12345678");
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
	public void testChangeBirthCut() throws RemoteException{
		resultMsg = hotel.changeBirthCut(1, 0.95, "12345678");
		double ratio = 1.00;
		ArrayList<PromotionHotelPO> pos = promotionHotelDataService.findByType(PromotionHotelType.BIRTH_PROMOTION, "12345678");
		for(PromotionHotelPO po : pos){
			if(po.getLevel() == 1){
				ratio = po.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.95, 0.01);
	}
	
	@Test 
	public void testAddBirthCut() throws RemoteException{
		resultMsg = hotel.addBirthCut(2, 0.9, "12345678");
		double ratio = 1.00;
		ArrayList<PromotionHotelPO> pos = promotionHotelDataService.findByType(PromotionHotelType.BIRTH_PROMOTION, "12345678");
		for(PromotionHotelPO po : pos){
			if(po.getLevel() == 2){
				ratio = po.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.9, 0.01);
	}
	
	@Test
	public void testDeleteBirthCut() throws RemoteException{
		resultMsg = hotel.deleteBirthCut(1, "12345678");
		ArrayList<PromotionHotelPO> pos = promotionHotelDataService.findByType(PromotionHotelType.BIRTH_PROMOTION, "12345678");
		assertEquals(pos.get(0), null);
	}

}
