package bl.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.promotionservice.PromotionWebBLService;
import dataservice.promotiondataservice.PromotionWebDataService;
import net.RMIManage;
import util.DataServiceType;
import util.PromotionWebType;
import util.ResultMsg;
import vo.PromotionWebVO;

public class PromotionWebController implements PromotionWebBLService{
	
	PromotionWeb promotionWeb;
	PromotionWebDataService webDataService;
	ResultMsg resultMsg = ResultMsg.FAIL;
	
	public PromotionWebController() {
		this.webDataService = (PromotionWebDataService)RMIManage
				.getDataService(DataServiceType.PromotionWebDataService);
		promotionWeb = new PromotionWeb(webDataService);
	}
	@Override
	public ResultMsg changeLevelCut(int level, double ratio, String hotelID) {
		try {
			resultMsg = promotionWeb.changeLevelCut(level, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg changeCircleCut(String location, double ratio, String hotelID) {
		try {
			resultMsg = promotionWeb.changeCircleCut(location, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg changeWebCustomCut(String timeBegin, String timeOver, double ratio, String hotelID) {
		try {
			resultMsg = promotionWeb.changeWebCustomCut(timeBegin, timeOver, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg addLevelCut(int level, double ratio, String hotelID) {
		try {
			resultMsg = promotionWeb.addLevelCut(level, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg addCircleCut(String location, double ratio, String hotelID) {
		try {
			resultMsg = promotionWeb.addCircleCut(location, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg addWebCustomCut(String timeBegin, String timeOver, double ratio, String hotelID) {
		try {
			resultMsg = promotionWeb.addWebCustomCut(timeBegin, timeOver, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ArrayList<PromotionWebVO> getWebPromotion(PromotionWebType type, String hotelID) {
		ArrayList<PromotionWebVO> list = null;
		try {
			list = promotionWeb.getWebPromotion(type, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
