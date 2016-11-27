package bl.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.PromotionHotelDataService;
import po.PromotionHotelPO;
import util.ResultMsg;
import vo.PromotionHotelVO;

/**
 * 酒店促销策略
 * @author lenovo
 *
 */
public class PromotionHotel {
	
	PromotionHotelDataService hotelDataService;
	ResultMsg resultMsg;
	
	public PromotionHotel(PromotionHotelDataService hotelDataService) {
		this.hotelDataService = hotelDataService;
	}

	/**
	 * 修改促销策略，返回是否修改成功的信息
	 * @param level
	 * @param ratio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeBirthCut(int level,double ratio) throws RemoteException {
		PromotionHotelPO promotion = null;
		resultMsg = hotelDataService.update(promotion);
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg changeOverCut(int number,double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg changeHotelCustomCut(String timeBegin, String timeOver, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg changeJoin(String businessName, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PromotionHotelVO> getHotelPromotion(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg addBirthCut(int level, double radio) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg addOverCut(int number, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg addJoin(String businessName, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg addHotelCustomCut(String timeBegin, String timeOver, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

}
