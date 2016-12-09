package bl.promotionbl;


import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import bl.vipbl.Vip;
import dataservice.creditdataservice.CreditDataService;
import dataservice.hoteldataservice.HotelInfoDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionHotelDataService;
import dataservice.promotiondataservice.PromotionWebDataService;
import dataservice.userdataservice.CustomerManagementDataService;
import dataservice.vipdataservice.VipDataService;
import po.CommonVipPO;
import po.CustomerInfoPO;
import po.OrderPO;
import po.PromotionHotelPO;
import po.PromotionWebPO;
import util.PromotionHotelType;
import util.PromotionWebType;
import util.VipType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class PromotionValue {

	private PromotionHotelDataService promotionHotelDataService;
	private VipDataService vipDataService;
	private OrderDataService orderDataService;
	private CustomerManagementDataService customerManagementDataService;
	private CreditDataService creditDataService;
	
	public PromotionValue(PromotionHotelDataService promotionHotelDataService,
			VipDataService vipDataService,OrderDataService orderDataService) {
		this.promotionHotelDataService = promotionHotelDataService;
		this.vipDataService = vipDataService;
		this.orderDataService = orderDataService;
	}
	
	public OrderVO getValue(CustomerInfoVO user, OrderVO order, PromotionHotelType hotelType) throws RemoteException {
		ArrayList<PromotionHotelPO> po = promotionHotelDataService.
				findByType(hotelType, order.getHotelID());;
		Vip vip = new Vip(vipDataService,customerManagementDataService,creditDataService);
		double ratio = 1;
		
		switch(hotelType) {
		
			case BIRTH_PROMOTION:
				
				if(user.getIsMember() && user.getVipType() == VipType.COMMON_VIP) {
					CommonVipPO commonVipPO = (CommonVipPO)((CustomerInfoPO)VOPOchange.VOtoPO(user));
					for(PromotionHotelPO hotelPO : po) {
						if(hotelPO.getTimeBegin().equals(commonVipPO.getBirthday())) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					order.setPrice(order.getPrice()*(1-ratio));
				}
				break;
				
			case OVERTHREE_PROMOTION:
				
				if(user.getIsMember()){
					for(PromotionHotelPO hotelPO : po) {
						if(hotelPO.getLevel() == vip.searchLevel(user)) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					order.setPrice(order.getPrice()*(1-ratio));
				}
				break;
				
			case HOTEL_CUSTOM_PROMOTION:
				
				if(user.getIsMember()) {
					for(PromotionHotelPO hotelPO : po) {
						if(!hotelPO.getTimeBegin().contains(order.getCheckInTime())
								&& hotelPO.getTimeOver().contains(order.getCheckOutTime())) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					order.setPrice(order.getPrice()*(1-ratio));
				}
				break;
				
			case JOIN_PROMOTION:
				
				if(user.getIsMember()) {
					String businessName = user.getUsername();
					for(PromotionHotelPO hotelPO : po) {
						if(hotelPO.getBusinessName().equals(businessName)) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					order.setPrice(order.getPrice()*(1-ratio));
				}
				break;
				
			default:
				break;
		}
		
		OrderPO poTmp = (OrderPO)VOPOchange.VOtoPO(order);
		orderDataService.update(poTmp);
		
		return order;
	}

	private PromotionWebDataService promotionWebDataService;
	private HotelInfoDataService dataService;
	
	public PromotionValue(PromotionWebDataService promotionWebDataService,
			VipDataService vipDataService,HotelInfoDataService dataService,OrderDataService orderDataService) {
		this.promotionWebDataService = promotionWebDataService;
		this.vipDataService = vipDataService;
		this.dataService = dataService;
		this.orderDataService = orderDataService;
	}
	
	public OrderVO getValue(CustomerInfoVO user, OrderVO order, PromotionWebType webType) throws RemoteException {
		ArrayList<PromotionWebPO> po = promotionWebDataService.
				findByType(webType);;
		Vip vip = new Vip(vipDataService,customerManagementDataService,creditDataService);
		double ratio = 1;
		
		switch(webType) {
		
			case VIP_CIRCLE_PROMOTION:
				
				if(user.getIsMember()) {
					for(PromotionWebPO hotelPO : po) {
						String location = dataService.find(order.getHotelID()).getAddress();
						if(hotelPO.getLocation().equals(location)) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					order.setPrice(order.getPrice()*(1-ratio));
				}
				break;
				
			case VIP_LEVEL_PROMOTION:
				
				if(user.getIsMember()){
					for(PromotionWebPO hotelPO : po) {
						if(hotelPO.getLevel() == vip.searchLevel(user)) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					order.setPrice(order.getPrice()*(1-ratio));
				}
				break;
				
			case WEB_CUSTOM_PROMOTION:
				
				if(user.getIsMember()) {
					for(PromotionWebPO hotelPO : po) {
						if(!hotelPO.getTimeBegin().contains(order.getCheckInTime())
								&& hotelPO.getTimeOver().contains(order.getCheckOutTime())) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					order.setPrice(order.getPrice()*(1-ratio));
				}
				break;
				
			default:
				break;
		}
		
		OrderPO poTmp = (OrderPO)VOPOchange.VOtoPO(order);
		orderDataService.update(poTmp);
		
		return order;
	}

}
