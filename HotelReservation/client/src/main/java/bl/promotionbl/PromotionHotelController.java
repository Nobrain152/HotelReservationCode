package bl.promotionbl;

import java.util.ArrayList;

import blservice.promotionservice.PromotionHotelBLService;
import dataservice.promotiondataservice.PromotionHotelDataService;
import net.RMIManage;
import util.DataServiceType;
import util.PromotionHotelType;
import util.ResultMsg;
import vo.PromotionHotelVO;

public class PromotionHotelController implements PromotionHotelBLService{

	PromotionHotel promotionHotel;
	PromotionHotelDataService hotelDataService;
	
	public PromotionHotelController() {
		this.hotelDataService = (PromotionHotelDataService)RMIManage
				.getDataService(DataServiceType.PromotionHotelDataService);
		promotionHotel = new PromotionHotel(hotelDataService);
	}

	@Override
	public ResultMsg changeBirthCut(int level, double ratio, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg changeOverCut(int number, double ratio, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg changeJoin(String businessName, double ratio, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg changeHotelCustomCut(String timeBegin, String timeOver, double ratio, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg addBirthCut(int level, double ratio, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg addOverCut(int number, double ratio, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg addJoin(String businessName, double ratio, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg addHotelCustomCut(String timeBegin, String timeOver, double ratio, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionHotelVO> getHotelPromotion(PromotionHotelType type, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}


}
