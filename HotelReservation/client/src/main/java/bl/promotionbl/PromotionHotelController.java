package bl.promotionbl;

import java.util.ArrayList;

import blservice.promotionservice.PromotionHotelBLService;
import po.PromotionHotelPO;
import util.PromotionMsg;
import vo.PromotionHotelVO;

public class PromotionHotelController implements PromotionHotelBLService{

	@Override
	public PromotionMsg changeBirthCut(int level,double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg changeOverCut(int number,double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg changeHotelCustomCut(String timeBegin, String timeOver, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg changeJoin(String businessName, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionHotelVO> getHotelPromotion(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg addBirthCut(int level, double radio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg addOverCut(int number, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg addJoin(String businessName, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionMsg addHotelCustomCut(String timeBegin, String timeOver, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

}
