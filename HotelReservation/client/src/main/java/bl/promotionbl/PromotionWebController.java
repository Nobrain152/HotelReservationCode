package bl.promotionbl;


import java.util.ArrayList;

import blservice.promotionservice.PromotionWebBLService;
import po.PromotionWebPO;
import util.PromotionMsg;


public class PromotionWebController implements PromotionWebBLService{

	@Override
	public PromotionMsg changeLevelCut(int level, String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg changeWebCustomCut(String timeBegin, String timeOver, String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg changeCircleCut(String location, String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public PromotionMsg addLevelCut(int level, String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg addCircleCut(String location, String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg addWebCustomCut(String timeBegin, String timeOver, String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionWebPO> getWebPromotion(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
