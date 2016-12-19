package data;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

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
		po = new PromotionHotelPO(PromotionHotelType.OVERTHREE_PROMOTION, "5004", 3, 2.33);
	}

	@Test
	public void testInsert() throws RemoteException {
		ResultMsg aMsg = impl.insert(po);
		assertEquals(aMsg, ResultMsg.SUCCESS);
	}

}
