package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.OrderVO;
import vo.PromotionWebVO;

public class WebStuffWebsiteManagementBLService_Stub  implements WebStuffWebsiteManagementBLService{

	
	ArrayList<PromotionWebVO> web;
	ArrayList<OrderVO> order;
	
	public WebStuffWebsiteManagementBLService_Stub(){
		web=new ArrayList<PromotionWebVO>();
		order=new ArrayList<OrderVO>();
	}
	
	@Override
	public ArrayList<PromotionWebVO> WebsiteStrategeInquire(PromotionWebVO vo) {
		
		return web;
	}

	@Override
	public boolean WebsiteStrategeCreate(PromotionWebVO vo) {
		
		return true;
	}

	@Override
	public ResultMsg WebsiteStrategeMod(PromotionWebVO vo) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg WebsiteStrategeDelete(PromotionWebVO vo) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<OrderVO> AbnormalOrderScan() {
		
		return order;
	}

	@Override
	public int userCreditInquire(String userid) {
		
		return 100;
	}

	@Override
	public ResultMsg UserCreditModification(String userid, int n) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<OrderVO> dayUnexOrder(String today) {
		
		return order;
	}

}
