package data;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.promotiondata.PromotionWebDataServiceImpl;
import po.PromotionWebPO;
import util.PromotionWebType;
import util.ResultMsg;

public class PromotionWebDataServiceImplTest {
	
	PromotionWebDataServiceImpl impl;
	PromotionWebPO po;

	@Before
	public void setUp() throws Exception {
		impl = new PromotionWebDataServiceImpl();
		po = new PromotionWebPO(null, PromotionWebType.VIP_LEVEL_PROMOTION, 1, 0.95);
	}

//	@Test
//	public void testInsert() throws RemoteException{
//		ResultMsg resultMsg = impl.insert(po);
//		assertEquals(ResultMsg.SUCCESS, resultMsg);
//	}
	
	@Test
	public void testGet() throws RemoteException{
		ArrayList<PromotionWebPO> pos = impl.findByType(PromotionWebType.VIP_LEVEL_PROMOTION);
		assertEquals(pos.get(0).getRatio(), 0.95,0.01);
	}

}
