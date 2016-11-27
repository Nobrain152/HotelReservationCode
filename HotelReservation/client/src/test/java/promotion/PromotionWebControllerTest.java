package promotion;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionWeb;
import vo.PromotionWebVO;
import util.CustomerType;
import util.PromotionWebType;
import util.VipType;

public class PromotionWebControllerTest {

	PromotionWeb web;
	PromotionWebVO web1,web2,web3;
	
	
	@Before
	public void setUp() throws Exception {
		web1 = new PromotionWebVO("七天",PromotionWebType.VIP_LEVEL_PROMOTION,VipType.COMMON_VIP, null, null, 0.8);
		web2 = new PromotionWebVO("七天",PromotionWebType.VIP_CIRCLE_PROMOTION,VipType.COMMON_VIP, null, null, 0.7);
		web3 = new PromotionWebVO("七天",PromotionWebType.WEB_CUSTOM_PROMOTION,VipType.COMMON_VIP,"2016/11/05", "2016/11/11", 0.5);
		//web要添加增加方法
		web.addLevelCut(1, web1.getRatio());
		web.addCircleCut("xianlin", web2.getRatio());
		web.addWebCustomCut(web3.getTimeBegin(), web3.getTimeOver(), web3.getRatio());
	}

	@Test
	public void testgetwebPromotion() {
		ArrayList<PromotionWebVO> webProList1 = web.getWebPromotion(0);
		ArrayList<PromotionWebVO> webProAnsList1 = new ArrayList<PromotionWebVO>();
		webProAnsList1.add(web1);
		assertEquals(webProList1,webProAnsList1);
		
		ArrayList<PromotionWebVO> webProList2 = web.getWebPromotion(1);
		ArrayList<PromotionWebVO> webProAnsList2 = new ArrayList<PromotionWebVO>();
		webProAnsList2.add(web2);
		assertEquals(webProList2,webProAnsList2);
		
		ArrayList<PromotionWebVO> webProList3 = web.getWebPromotion(1);
		ArrayList<PromotionWebVO> webProAnsList3 = new ArrayList<PromotionWebVO>();
		webProAnsList3.add(web3);
		assertEquals(webProList3,webProAnsList3);
	}
}
