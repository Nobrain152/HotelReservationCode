package bl.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
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
	ResultMsg resultMsg = ResultMsg.FAIL;
	
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
	public ResultMsg changeBirthCut(int level,double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.BIRTH_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getLevel() == level) {
				po.setRatio(ratio);
				resultMsg = promotionHotelDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * �޸����估����Ԥ���ػ�
	 * @param number
	 * @param ratio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeOverCut(int number,double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.BIRTH_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getNumber() == number) {
				po.setRatio(ratio);
				resultMsg = promotionHotelDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * �޸�˫11��ۿۣ����ض����ڼ�ס�����ۿۣ�
	 * @param timeBegin
	 * @param timeOver
	 * @param ratio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeHotelCustomCut(String timeBegin, String timeOver, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.BIRTH_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) && po.getTimeOver().equals(timeOver)) {
				po.setRatio(ratio);
				resultMsg = promotionHotelDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * �޸ĺ�����ҵ�ͻ��ۿ�
	 * @param businessName
	 * @param ratio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeJoin(String businessName, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.BIRTH_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getBusinessName().equals(businessName)) {
				po.setRatio(ratio);
				resultMsg = promotionHotelDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * ��ȡ�þƵ��ĳ������
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<PromotionHotelVO> getHotelPromotion(PromotionHotelType type,String hotelID) throws RemoteException {
		ArrayList<PromotionHotelPO> list = promotionHotelDataService.findByType(type,hotelID);
		ArrayList<PromotionHotelVO> voList = new ArrayList<>();
		PromotionHotelVO vo;
		for(PromotionHotelPO po : list) {
			vo = (PromotionHotelVO)VOPOchange.POtoVO(po);
			voList.add(vo);
		}
		return voList;
	}

	/**
	 * ��������ػ��ۿ�
	 * @param level
	 * @param radio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addBirthCut(int level, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.BIRTH_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getLevel() == level) {
				return resultMsg;
			}
		}
		PromotionHotelPO po = new PromotionHotelPO(type, hotelID, level, ratio);
		resultMsg = promotionHotelDataService.insert(po);
		return resultMsg;
	}

	/**
	 * ������估����Ԥ���ػ�
	 * @param number
	 * @param ratio
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addOverCut(int number, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.OVERTHREE_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getNumber() == number) {
				return resultMsg;
			}
		}
		PromotionHotelPO po = new PromotionHotelPO(type, hotelID, number, ratio);
		resultMsg = promotionHotelDataService.insert(po);
		return resultMsg;
	}

	/**
	 * 
	 * @param businessName
	 * @param ratio
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addJoin(String businessName, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.JOIN_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getBusinessName().equals(businessName)) {
				return resultMsg;
			}
		}
		PromotionHotelPO po = new PromotionHotelPO(type, hotelID, businessName, ratio);
		resultMsg = promotionHotelDataService.insert(po);
		return resultMsg;
	}

	/**
	 * ���˫11��ۿۣ����ض����ڼ�ס�����ۿۣ�
	 * @param timeBegin
	 * @param timeOver
	 * @param ratio
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addHotelCustomCut(String timeBegin, String timeOver, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.HOTEL_CUSTOM_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) && po.getTimeOver().equals(timeOver)) {
				return resultMsg;
			}
		}
		PromotionHotelPO po = new PromotionHotelPO(type, hotelID, timeBegin, timeOver, ratio);
		resultMsg = promotionHotelDataService.insert(po);
		return resultMsg;
	}

}
