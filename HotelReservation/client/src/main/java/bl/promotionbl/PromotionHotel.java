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
 * @author txin15
 *
 */
public class PromotionHotel {
	
	private PromotionHotelDataService promotionHotelDataService;
	ResultMsg resultMsg = ResultMsg.FAIL;
	
	public PromotionHotel(PromotionHotelDataService promotionHotelDataService) {
		this.promotionHotelDataService = promotionHotelDataService;
	}

	/**
	 * �޸������ػ��ۿ�
	 * @param level
	 * @param ratio
	 * @param hotelID
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
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeOverCut(int number,double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.OVERTHREE_PROMOTION;
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
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeHotelCustomCut(String timeBegin, String timeOver, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.HOTEL_CUSTOM_PROMOTION;
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
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeJoin(String businessName, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.JOIN_PROMOTION;
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
	 * @param hotelID
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
	 * @param hotelID
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
		PromotionHotelPO po = new PromotionHotelPO(null, type, hotelID, level, ratio);
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
		PromotionHotelPO po = new PromotionHotelPO(null, type, hotelID, number, ratio);
		resultMsg = promotionHotelDataService.insert(po);
		return resultMsg;
	}

	/**
	 * ��Ӻ�����ҵ�ͻ��ۿ�
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
		PromotionHotelPO po = new PromotionHotelPO(null, type, hotelID, businessName, ratio);
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
		PromotionHotelPO po = new PromotionHotelPO(null, type, hotelID, timeBegin, timeOver, ratio);
		resultMsg = promotionHotelDataService.insert(po);
		return resultMsg;
	}
	
	/**
	 * ɾ�������ػ��ۿ�
	 * @param level
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg deleteBirthCut(int level,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.BIRTH_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getLevel() == level) {
				resultMsg = promotionHotelDataService.deleteBirthCut(po.getLevel(),po.getHotelID());
			}
		}
		return resultMsg;
	}
	
	/**
	 * ɾ�����估����Ԥ���ػ�
	 * @param number
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg deleteOverCut(int number, String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.OVERTHREE_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getNumber() == number) {
				resultMsg = promotionHotelDataService.deleteOverCut(po.getNumber(),po.getHotelID());
			}
		}
		return resultMsg;
	}
	
	/**
	 * ɾ��������ҵ�ͻ��ۿ�
	 * @param businessName
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg deleteJoin(String businessName, String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.JOIN_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getBusinessName().equals(businessName)) {
				resultMsg = promotionHotelDataService.deleteJoin(po.getBusinessName(),po.getHotelID());
			}
		}
		return resultMsg;
	}
	
	/**
	 * ɾ��˫11��ۿۣ����ض����ڼ�ס�����ۿۣ�
	 * @param timeBegin
	 * @param timeOver
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg deleteHotelCustomCut(String timeBegin,String timeOver, String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.HOTEL_CUSTOM_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) 
					&& po.getTimeOver().equals(timeOver)) {
				resultMsg = promotionHotelDataService.deleteHotelCustomCut(po.getTimeBegin(),po.getTimeOver(),po.getHotelID());
			}
		}
		return resultMsg;
	}

}
