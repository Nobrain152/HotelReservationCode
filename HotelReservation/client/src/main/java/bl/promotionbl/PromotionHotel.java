package bl.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.PromotionHotelDataService;
import po.PromotionHotelPO;
import util.ResultMsg;
import vo.PromotionHotelVO;

/**
 * �Ƶ��������
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
	 * �޸Ĵ������ԣ������Ƿ��޸ĳɹ�����Ϣ
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
