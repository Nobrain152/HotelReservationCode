package bl.promotionbl;


import java.util.ArrayList;

import blservice.promotionservice.PromotionWebBLService;
import util.PromotionMsg;
import vo.PromotionWebVO;


public class PromotionWebController implements PromotionWebBLService{

	@Override
	public PromotionMsg changeLevelCut(int level, double radio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg changeWebCustomCut(String timeBegin, String timeOver, double radio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg changeCircleCut(String location, double radio) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public PromotionMsg addLevelCut(int level, double d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg addCircleCut(String location, double radio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg addWebCustomCut(String timeBegin, String timeOver, double radio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionWebVO> getWebPromotion(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
