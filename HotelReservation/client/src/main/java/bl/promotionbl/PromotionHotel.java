package bl.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.PromotionHotelDataService;
import po.PromotionHotelPO;
import util.PromotionHotelType;
import util.ResultMsg;
import vo.PromotionHotelVO;

/**
 * �Ƶ��������
 * @author lenovo
 *
 */
public class PromotionHotel {
	
	PromotionHotelDataService promotionHotelDataService;
	ResultMsg resultMsg;
	
	public PromotionHotel(PromotionHotelDataService promotionHotelDataService) {
		this.promotionHotelDataService = promotionHotelDataService;
	}

	/**
	 * �޸������ػ��ۿ�
	 * @param level
	 * @param ratio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeBirthCut(int level,double ratio) throws RemoteException {
		PromotionHotelPO promotion = null;
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ���估����Ԥ���ػ�
	 * @param number
	 * @param ratio
	 * @return
	 */
	public ResultMsg changeOverCut(int number,double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ˫11��ۿۣ����ض����ڼ�ס�����ۿۣ�
	 * @param timeBegin
	 * @param timeOver
	 * @param ratio
	 * @return
	 */
	public ResultMsg changeHotelCustomCut(String timeBegin, String timeOver, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ������ҵ�ͻ��ۿ�
	 * @param businessName
	 * @param ratio
	 * @return
	 */
	public ResultMsg changeJoin(String businessName, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PromotionHotelVO> getHotelPromotion(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ��������ػ��ۿ�
	 * @param level
	 * @param radio
	 * @return
	 */
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
