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
	public ResultMsg changeLevelCut(int level, double ratio) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_LEVEL_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
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
	public ResultMsg changeWebCustomCut(String timeBegin, String timeOver, double ratio) throws RemoteException {
		PromotionWebType type = PromotionWebType.WEB_CUSTOM_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
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
	public ResultMsg changeCircleCut(String location, double ratio) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_CIRCLE_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
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
	public ResultMsg addLevelCut(int level, double ratio) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_LEVEL_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getLevel() == level) {
				return resultMsg;
			}
		}
		PromotionWebPO po = new PromotionWebPO(type, level, ratio);
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
	public ResultMsg addCircleCut(String location, double radio) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_CIRCLE_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getLocation().equals(location)) {
				return resultMsg;
			}
		}
		PromotionWebPO po = new PromotionWebPO(type, location, radio);
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
	public ResultMsg addWebCustomCut(String timeBegin, String timeOver, double ratio) throws RemoteException {
		PromotionWebType type = PromotionWebType.WEB_CUSTOM_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) && po.getTimeOver().equals(timeOver)) {
				return resultMsg;
			}
		}
		PromotionWebPO po = new PromotionWebPO(type, timeBegin,timeOver, ratio);
		resultMsg = promotionWebDataService.insert(po);
		return resultMsg;
	}

	/**
	 * ��ø���վ�Ĵ�������
	 * @param type
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<PromotionWebVO> getWebPromotion(PromotionWebType type) throws RemoteException {
		ArrayList<PromotionWebPO> list = promotionWebDataService.findByType(type);
		ArrayList<PromotionWebVO> voList = new ArrayList<<PromotionWebVO>();
		PromotionWebVO vo;
		for(PromotionWebPO po : list) {
			vo = (PromotionWebVO)VOPOchange.POtoVO(po);
			voList.add(vo);
		}
		return voList;	
	}
	
	public ResultMsg deleteLevelCut(int level) throws RemoteException {
		PromotionWebType type = PromotionWebType.WEB_CUSTOM_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getLevel() == level) {
				resultMsg = promotionWebDataService.deleteLevelCut(po.getLevel());
			}
		}
		return resultMsg;
	}
	
	public ResultMsg deleteCircleCut(String location) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_CIRCLE_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getLocation().equals(location)) {
				resultMsg = promotionWebDataService.deleteCircleCut(po.getLocation());
			}
		}
		return resultMsg;
	}
	
	public ResultMsg deleteWebCustomCut(String timeBegin,String timeOver) throws RemoteException {
		PromotionWebType type = PromotionWebType.WEB_CUSTOM_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) && po.getTimeOver().equals(timeOver)) {
				resultMsg = promotionWebDataService.deleteWebCustomCut(po.getTimeBegin(), po.getTimeOver());
			}
		}
		return resultMsg;
	}
}
