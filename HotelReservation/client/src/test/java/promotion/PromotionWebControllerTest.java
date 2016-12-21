package promotion;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionWebController;
import blservice.promotionblservice.PromotionWebBLService;
import vo.PromotionWebVO;
import util.Area;
import util.PromotionWebType;
import util.ResultMsg;

public class PromotionWebControllerTest {

	PromotionWebBLService web;
	PromotionWebVO web1,web2,web3;
	ResultMsg resultMsg = ResultMsg.FAIL;
	
	@Before
	public void setUp() throws Exception {
		web = new PromotionWebController();
		web1 = new PromotionWebVO(null, PromotionWebType.VIP_CIRCLE_PROMOTION, Area.EAST, 0.8);
		web2 = new PromotionWebVO(null, PromotionWebType.VIP_LEVEL_PROMOTION,1,0.95);
		web3 = new PromotionWebVO(null, PromotionWebType.WEB_CUSTOM_PROMOTION,"2016-12-12 00:00","2016-12-12 24:00", 0.77);
//		web.addCircleCut(Area.EAST, 0.8);
//		web.addLevelCut(1, 0.95);
//		web.addWebCustomCut("2016-12-12 00:00", "2016-12-12 24:00", 0.95);
	}
//
//	@Test
//	public void testgetwebPromotion() throws RemoteException {
//		ArrayList<PromotionWebVO> webProList1 = web.getWebPromotion(PromotionWebType.VIP_CIRCLE_PROMOTION);
//		assertEquals(webProList1.get(0).getRatio(),web1.getRatio(),0.01);
//		
//		ArrayList<PromotionWebVO> webProList2 = web.getWebPromotion(PromotionWebType.VIP_LEVEL_PROMOTION);
//		assertEquals(webProList2.get(0).getRatio(),web2.getRatio(),0.01);
//		
//		ArrayList<PromotionWebVO> webProList3 = web.getWebPromotion(PromotionWebType.WEB_CUSTOM_PROMOTION);
//		assertEquals(webProList3.get(0).getRatio(),web3.getRatio(),0.01);
//	}
//	
//	@Test
//	public void testChangeCircleCut() throws RemoteException{
//		double ratio = 1.00;
//		resultMsg = web.changeCircleCut(Area.EAST, 0.9);
//		ArrayList<PromotionWebVO> vos = web.getWebPromotion(PromotionWebType.VIP_CIRCLE_PROMOTION);
//		for(PromotionWebVO vo : vos){
//			if(vo.getLevel() == 1){
//				ratio = vo.getRatio();
//				break;
//			}
//		}
//		assertEquals(ratio, 0.9, 0.01);
//	}
//	
	@Test
	public void testAddLevelCut() throws RemoteException{
		resultMsg = web.addLevelCut(2, 0.85);
		double ratio = 1.00;
		ArrayList<PromotionWebVO> vos = web.getWebPromotion(PromotionWebType.VIP_LEVEL_PROMOTION);
		for(PromotionWebVO vo : vos){
			if(vo.getLevel() == 2){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.85, 0.01);
	}
//	
//	@Test
//	public void testDeleteLevelCut() throws RemoteException{
//		resultMsg = web.deleteLevelCut(1);
//		ArrayList<PromotionWebVO> vos = web.getWebPromotion(PromotionWebType.VIP_LEVEL_PROMOTION);
//		assertEquals(vos.get(0), null);
//	}
}
