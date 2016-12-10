package bl.promotionbl;

import java.rmi.RemoteException;

import blservice.promotionblservice.PromotionValueBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionHotelDataService;
import dataservice.promotiondataservice.PromotionWebDataService;
import dataservice.vipdataservice.VipDataService;
import net.RMIManage;
import util.DataServiceType;
import util.PromotionHotelType;
import util.PromotionWebType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class PromotionValueController implements PromotionValueBLService{

	private PromotionHotelDataService promotionHotelDataService;
	private PromotionWebDataService promotionWebDataService;
	private VipDataService vipDataService;
	private HotelInfoDataService hotelInfoDataService;
	private PromotionValue promotionValueHotel;
	private PromotionValue promotionValueWeb;
	private OrderDataService orderDataService;
	
	public PromotionValueController() {
		this.promotionHotelDataService = (PromotionHotelDataService)RMIManage.getDataService(DataServiceType.PromotionHotelDataService);
		this.promotionWebDataService = (PromotionWebDataService)RMIManage.getDataService(DataServiceType.PromotionWebDataService);
		this.vipDataService = (VipDataService)RMIManage.getDataService(DataServiceType.VipDataService);
		this.hotelInfoDataService = (HotelInfoDataService)RMIManage.getDataService(DataServiceType.HotelInfoDataService);
		promotionValueHotel = new PromotionValue(promotionHotelDataService, vipDataService,orderDataService);
		promotionValueWeb = new PromotionValue(promotionWebDataService, vipDataService, hotelInfoDataService,orderDataService);
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

}
