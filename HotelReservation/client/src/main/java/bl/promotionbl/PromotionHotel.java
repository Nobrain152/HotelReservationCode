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
 * 酒店促销策略
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
	 * 修改生日特惠折扣
	 * @param level
	 * @param ratio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeBirthCut(int level,double ratio) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.BIRTH_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type);
		for(PromotionHotelPO po : promotion) {
			if(po.getLevel() == level) {
				po.setRatio(ratio);
				resultMsg = promotionHotelDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * 三间及以上预订特惠
	 * @param number
	 * @param ratio
	 * @return
	 */
	public ResultMsg changeOverCut(int number,double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 双11活动折扣（在特定的期间住宿有折扣）
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
	 * 合作企业客户折扣
	 * @param businessName
	 * @param ratio
	 * @return
	 */
	public ResultMsg changeJoin(String businessName, double ratio) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取该酒店的某个策略
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<PromotionHotelVO> getHotelPromotion(PromotionHotelType type) throws RemoteException {
		ArrayList<PromotionHotelPO> list = promotionHotelDataService.findByType(type);
		ArrayList<PromotionHotelVO> voList = new ArrayList<>();
		PromotionHotelVO vo;
		for(PromotionHotelPO po : list) {
			vo = (PromotionHotelVO)VOPOchange.POtoVO(po);
			voList.add(vo);
		}
		return voList;
	}

	/**
	 * 添加生日特惠折扣
	 * @param level
	 * @param radio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addBirthCut(int level, double ratio) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.BIRTH_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type);
		for(PromotionHotelPO po : promotion) {
			if(po.getLevel() == level) {
				return resultMsg;
			}
		}
		PromotionHotelPO po = new PromotionHotelPO(type, level, ratio);
		resultMsg = promotionHotelDataService.insert(po);
		return resultMsg;
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
