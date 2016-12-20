package data;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.promotiondata.PromotionHotelDataServiceImpl;
import po.PromotionHotelPO;
import util.PromotionHotelType;
import util.ResultMsg;

public class PromotionHotelDataServiceImplTest {

	PromotionHotelDataServiceImpl impl;
	PromotionHotelPO po;
	
	@Before
	public void setUp() throws Exception {
		impl = new PromotionHotelDataServiceImpl();
//		po = new PromotionHotelPO(PromotionHotelType.OVERTHREE_PROMOTION, "5004", 3, 2.33);
		po = new PromotionHotelPO(PromotionHotelType.BIRTH_PROMOTION, "5000", 2, 0.95);
	}

//	@Test
//	public void testInsert() throws RemoteException {
//		ResultMsg aMsg = impl.insert(po);
//		assertEquals(aMsg, ResultMsg.SUCCESS);
//	}
//	
	@Test
	public void testFindByType() throws RemoteException{
		ArrayList<PromotionHotelPO> arr = impl.findByType(PromotionHotelType.OVERTHREE_PROMOTION, "5004");
		assertEquals(3, arr.get(0).getNumber());
	}

}
