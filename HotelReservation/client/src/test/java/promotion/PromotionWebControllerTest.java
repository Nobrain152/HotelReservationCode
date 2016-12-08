package promotion;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionWebController;
import vo.PromotionWebVO;
import util.PromotionWebType;

public class PromotionWebControllerTest {

	PromotionWebController web;
	PromotionWebVO web1,web2,web3;
	
	
	@Before
	public void setUp() throws Exception {
//		web1 = new PromotionWebVO(PromotionWebType.VIP_CIRCLE_PROMOTION,"12345678", "œ…¡÷¥Ûµ¿163∫≈", 0.8);
//		web2 = new PromotionWebVO(PromotionWebType.VIP_LEVEL_PROMOTION,"12345678",1,0.8);
//		web3 = new PromotionWebVO(PromotionWebType.WEB_CUSTOM_PROMOTION,"12345678","2016/12/02","2016/12/09", 0.7);
//		web.addLevelCut(1, web1.getRatio(),"12345678");
//		web.addCircleCut("xianlin", web2.getRatio(),"12345678");
//		web.addWebCustomCut(web3.getTimeBegin(), web3.getTimeOver(), web3.getRatio(),"12345678");
	}

	@Test
	public void testgetwebPromotion() throws RemoteException {
//		ArrayList<PromotionWebVO> webProList1 = web.getWebPromotion(PromotionWebType.VIP_CIRCLE_PROMOTION,"12345678");
//		ArrayList<PromotionWebVO> webProAnsList1 = new ArrayList<PromotionWebVO>();
//		webProAnsList1.add(web1);
//		assertEquals(webProList1,webProAnsList1);
//		
//		ArrayList<PromotionWebVO> webProList2 = web.getWebPromotion(PromotionWebType.VIP_LEVEL_PROMOTION,"12345678");
//		ArrayList<PromotionWebVO> webProAnsList2 = new ArrayList<PromotionWebVO>();
//		webProAnsList2.add(web2);
//		assertEquals(webProList2,webProAnsList2);
//		
//		ArrayList<PromotionWebVO> webProList3 = web.getWebPromotion(PromotionWebType.WEB_CUSTOM_PROMOTION,"12345678");
//		ArrayList<PromotionWebVO> webProAnsList3 = new ArrayList<PromotionWebVO>();
//		webProAnsList3.add(web3);
//		assertEquals(webProList3,webProAnsList3);
	}
}
