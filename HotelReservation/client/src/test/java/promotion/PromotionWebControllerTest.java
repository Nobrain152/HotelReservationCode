package promotion;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionWebController;
import dataservice.promotiondataservice.PromotionWebDataService;
import po.PromotionWebPO;
import vo.PromotionWebVO;
import util.PromotionWebType;
import util.ResultMsg;

public class PromotionWebControllerTest {

	PromotionWebController web;
	PromotionWebVO web1,web2,web3;
	ResultMsg resultMsg;
	PromotionWebDataService promotionWebDataService;
	
	@Before
	public void setUp() throws Exception {
		web1 = new PromotionWebVO(PromotionWebType.VIP_CIRCLE_PROMOTION, "œ…¡÷¥Ûµ¿163∫≈", 0.8);
		web2 = new PromotionWebVO(PromotionWebType.VIP_LEVEL_PROMOTION,1,0.8);
		web3 = new PromotionWebVO(PromotionWebType.WEB_CUSTOM_PROMOTION,"2016/12/02","2016/12/09", 0.7);
//		web.addLevelCut(1, web1.getRatio());
//		web.addCircleCut("xianlin", web2.getRatio());
//		web.addWebCustomCut(web3.getTimeBegin(), web3.getTimeOver(), web3.getRatio());
	}

	@Test
	public void testgetwebPromotion() throws RemoteException {
		ArrayList<PromotionWebVO> webProList1 = web.getWebPromotion(PromotionWebType.VIP_CIRCLE_PROMOTION);
		ArrayList<PromotionWebVO> webProAnsList1 = new ArrayList<PromotionWebVO>();
		webProAnsList1.add(web1);
		assertEquals(webProList1,webProAnsList1);
		
//		ArrayList<PromotionWebVO> webProList2 = web.getWebPromotion(PromotionWebType.VIP_LEVEL_PROMOTION);
//		ArrayList<PromotionWebVO> webProAnsList2 = new ArrayList<PromotionWebVO>();
//		webProAnsList2.add(web2);
//		assertEquals(webProList2,webProAnsList2);
//		
//		ArrayList<PromotionWebVO> webProList3 = web.getWebPromotion(PromotionWebType.WEB_CUSTOM_PROMOTION);
//		ArrayList<PromotionWebVO> webProAnsList3 = new ArrayList<PromotionWebVO>();
//		webProAnsList3.add(web3);
//		assertEquals(webProList3,webProAnsList3);
	}
	
	@Test
	public void testChangeLevelCut() throws RemoteException{
		resultMsg = web.changeLevelCut(1, 0.9);
		double ratio = 1.00;
		ArrayList<PromotionWebPO> pos = promotionWebDataService.findByType(PromotionWebType.VIP_LEVEL_PROMOTION);
		for(PromotionWebPO po : pos){
			if(po.getLevel() == 1){
				ratio = po.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.9, 0.01);
	}
	
	@Test
	public void testAddLevelCut() throws RemoteException{
		resultMsg = web.addLevelCut(2, 0.85);
		double ratio = 1.00;
		ArrayList<PromotionWebPO> pos = promotionWebDataService.findByType(PromotionWebType.VIP_LEVEL_PROMOTION);
		for(PromotionWebPO po : pos){
			if(po.getLevel() == 2){
				ratio = po.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.85, 0.01);
	}
	
	@Test
	public void testDeleteLevelCut() throws RemoteException{
		resultMsg = web.deleteLevelCut(1);
		ArrayList<PromotionWebPO> pos = promotionWebDataService.findByType(PromotionWebType.VIP_LEVEL_PROMOTION);
		assertEquals(pos.get(0), null);
	}
}
