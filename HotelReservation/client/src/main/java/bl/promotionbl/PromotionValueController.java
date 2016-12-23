package bl.promotionbl;

import java.rmi.Remote;
import java.rmi.RemoteException;

import bl.BusinessController;
import blservice.promotionblservice.PromotionValueBLService;
import dataservice.promotiondataservice.PromotionHotelDataService;
import dataservice.promotiondataservice.PromotionWebDataService;
import net.RMIManage;
import util.DataServiceType;
import util.PromotionHotelType;
import util.PromotionWebType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class PromotionValueController extends BusinessController implements PromotionValueBLService{

	private PromotionHotelDataService promotionHotelDataService;
	private PromotionWebDataService promotionWebDataService;
	private PromotionValue promotionValueHotel;
	private PromotionValue promotionValueWeb;
	
	public PromotionValueController() {
		promotionHotelDataService = (PromotionHotelDataService)RMIManage.
				getDataService(DataServiceType.PromotionHotelDataService);
		promotionWebDataService = (PromotionWebDataService)RMIManage.
				getDataService(DataServiceType.PromotionWebDataService);
		promotionValueHotel = new PromotionValue(promotionHotelDataService);
		promotionValueWeb = new PromotionValue(promotionWebDataService);
	}
	
	@Override
	public OrderVO getValue(CustomerInfoVO user, OrderVO order, PromotionHotelType hotelType) {
		try {
			order = promotionValueHotel.getValue(user, order, hotelType);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public OrderVO getValue(CustomerInfoVO user, OrderVO order, PromotionWebType webType) {
		try {
			order = promotionValueWeb.getValue(user, order, webType);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public void reinitDataService(Remote dataService) {
		promotionHotelDataService = (PromotionHotelDataService)dataService;
		promotionValueHotel = new PromotionValue(promotionHotelDataService);
		promotionWebDataService = (PromotionWebDataService)dataService;
		promotionValueWeb = new PromotionValue(promotionWebDataService);
		
	}

}
