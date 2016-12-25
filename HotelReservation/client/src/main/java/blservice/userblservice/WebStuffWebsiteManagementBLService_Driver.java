package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.PromotionWebVO;

public class WebStuffWebsiteManagementBLService_Driver {

	 public static void main(String[] args){
			
		 WebStuffWebsiteManagementBLService a=new WebStuffWebsiteManagementBLService_Stub();
		 WebStuffWebsiteManagementBLService_Driver b=new WebStuffWebsiteManagementBLService_Driver();
		   b.drive(a);
		
		}
		
		public void drive(WebStuffWebsiteManagementBLService a){
			ArrayList<HotelInfoVO> hotelInfoVOs;
			HotelInfoVO hotel;
			ArrayList<OrderVO> order;
			ArrayList<PromotionWebVO> pp;
			pp=a.WebsiteStrategeInquire(new PromotionWebVO());
			boolean bb=a.WebsiteStrategeCreate(new PromotionWebVO());
			ResultMsg res=a.WebsiteStrategeDelete(new PromotionWebVO());
			res=a.WebsiteStrategeMod(new PromotionWebVO());
			order=a.AbnormalOrderScan();
			int ii=a.userCreditInquire("12345678");
			res=a.UserCreditModification("12345678",100);
			order=a.dayUnexOrder("");
		}
}
