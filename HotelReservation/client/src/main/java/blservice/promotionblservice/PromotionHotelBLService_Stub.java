package blservice.promotionblservice;
import java.util.ArrayList;

import util.PromotionHotelType;
import util.ResultMsg;
import vo.PromotionHotelVO;


public class PromotionHotelBLService_Stub implements PromotionHotelBLService{
	String ratio;
	String timeBegin;
	String timeOver;
	public PromotionHotelBLService_Stub(){
		ratio = "0";
		timeBegin = "2016/10/10";
		timeOver = "2016/10/16";
	}
	public PromotionHotelBLService_Stub(String ratio,String timeBegin,String timeOver){
		this.ratio = ratio;
		this.timeBegin = timeBegin;
		this.timeOver = timeOver;
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
	public ResultMsg deleteBirthCut(int level, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMsg deleteOverCut(int number, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMsg deleteJoin(String businessName, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMsg deleteHotelCustomCut(String timeBegin, String timeOver, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<PromotionHotelVO> getHotelPromotion(PromotionHotelType type, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}



	
}