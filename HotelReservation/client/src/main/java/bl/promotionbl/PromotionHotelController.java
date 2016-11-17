package bl.promotionbl;

import java.util.ArrayList;

import blservice.promotionservice.PromotionHoelBLService;
import po.PromotionHotelPO;
import util.PromotionMsg;

public class PromotionHotelController implements PromotionHoelBLService{

	@Override
	public PromotionMsg changeBirthCut(int level,String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg changeOverCut(int number,String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg changeHotelCustomCut(String timeBegin, String timeOver, String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg changeJoin(String businessName, String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionHotelPO> getHotelPromotion(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg addBirthCut(int level, String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg addOverCut(int number, String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg addJoin(String businessName, String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg addHotelCustomCut(String timeBegin, String timeOver, String ratio) {
		// TODO Auto-generated method stub
		return null;
	}

}
