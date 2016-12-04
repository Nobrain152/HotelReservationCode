package bl.promotionbl;


import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.promotiondataservice.PromotionWebDataService;
import po.PromotionWebPO;
import util.PromotionWebType;
import util.ResultMsg;
import vo.PromotionWebVO;


public class PromotionWeb{

	private PromotionWebDataService promotionWebDataService;
	private ResultMsg resultMsg = ResultMsg.FAIL;
	
	public PromotionWeb(PromotionWebDataService promotionWebDataService) {
		this.promotionWebDataService = promotionWebDataService;
	}
	
	/**
	 * �޸Ļ�Ա�ȼ����ƶ�����ֵ����������һ�ȼ��������ۿ�
	 * @param level
	 * @param radio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeLevelCut(int level, double ratio ,String hotelID) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_LEVEL_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type,hotelID);
		for(PromotionWebPO po : promotion) {
			if(po.getLevel() == level) {
				po.setRatio(ratio);
				resultMsg = promotionWebDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * �޸�˫11��ۿۣ����ض����ڼ�Ԥ�����ۿۣ�
	 * @param timeBegin
	 * @param timeOver
	 * @param radio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeWebCustomCut(String timeBegin, String timeOver, double ratio,String hotelID) throws RemoteException {
		PromotionWebType type = PromotionWebType.WEB_CUSTOM_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type,hotelID);
		for(PromotionWebPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) && po.getTimeOver().equals(timeOver)) {
				po.setRatio(ratio);
				resultMsg = promotionWebDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * �޸�VIP��Ա�ض���Ȧר���ۿۣ���ͬ�ȼ���ͬ��Ȧ�ۿ۲�һ����
	 * @param location
	 * @param radio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeCircleCut(String location, double ratio,String hotelID) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_CIRCLE_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type,hotelID);
		for(PromotionWebPO po : promotion) {
			if(po.getLocation().equals(location)) {
				po.setRatio(ratio);
				resultMsg = promotionWebDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * ��ӻ�Ա�ȼ����ƶ�����ֵ����������һ�ȼ��������ۿ�
	 * @param level
	 * @param d
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addLevelCut(int level, double ratio,String hotelID) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_LEVEL_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type,hotelID);
		for(PromotionWebPO po : promotion) {
			if(po.getLevel() == level) {
				return resultMsg;
			}
		}
		PromotionWebPO po = new PromotionWebPO(type, hotelID, level, ratio);
		resultMsg = promotionWebDataService.insert(po);
		return resultMsg;
	}

	/**
	 * ���VIP��Ա�ض���Ȧר���ۿۣ���ͬ�ȼ���ͬ��Ȧ�ۿ۲�һ����
	 * @param location
	 * @param radio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addCircleCut(String location, double radio,String hotelID) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_CIRCLE_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type,hotelID);
		for(PromotionWebPO po : promotion) {
			if(po.getLocation().equals(location)) {
				return resultMsg;
			}
		}
		PromotionWebPO po = new PromotionWebPO(type, hotelID, location, radio);
		resultMsg = promotionWebDataService.insert(po);
		return resultMsg;
	}

	/**
	 * ���˫11��ۿۣ����ض����ڼ�Ԥ�����ۿۣ�
	 * @param timeBegin
	 * @param timeOver
	 * @param radio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addWebCustomCut(String timeBegin, String timeOver, double ratio,String hotelID) throws RemoteException {
		PromotionWebType type = PromotionWebType.WEB_CUSTOM_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type,hotelID);
		for(PromotionWebPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) && po.getTimeOver().equals(timeOver)) {
				return resultMsg;
			}
		}
		PromotionWebPO po = new PromotionWebPO(type, hotelID, timeBegin,timeOver, ratio);
		resultMsg = promotionWebDataService.insert(po);
		return resultMsg;
	}

	/**
	 * ��ø���վ�Ĵ�������
	 * @param type
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<PromotionWebVO> getWebPromotion(PromotionWebType type,String hotelID) throws RemoteException {
		ArrayList<PromotionWebPO> list = promotionWebDataService.findByType(type,hotelID);
		ArrayList<PromotionWebVO> voList = new ArrayList<PromotionWebVO>();
		PromotionWebVO vo;
		for(PromotionWebPO po : list) {
			vo = (PromotionWebVO)VOPOchange.POtoVO(po);
			voList.add(vo);
		}
		return voList;	}
	
}
