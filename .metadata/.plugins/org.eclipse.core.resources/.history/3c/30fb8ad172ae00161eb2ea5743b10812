package bl.userbl;

import java.util.ArrayList;

import bl.integralbl.IntegralController;
import bl.orderbl.OrderOnWebController;
import bl.promotionbl.PromotionWebController;
import blservice.userblservice.WebStuffWebsiteManagementBLService;
import vo.IntegralVO;
import vo.OrderOnWebVO;
import vo.PromotionWebVO;
import vo.UserIDVO;


/**
 * 网站营销人员对网站的操作
 * @author 曹畅
 *
 */
public class WebStuffWebsiteManagementController implements WebStuffWebsiteManagementBLService {

	PromotionWebController pro;
	OrderOnWebController order;
	IntegralController inte;
	
	public  WebStuffWebsiteManagementController(){
		pro=new PromotionWebController();
		order=new OrderOnWebController();
		inte=new IntegralController();
	}
	
	/**
	 * 创建网站促销策略
	 * @param 网站促销策略VO
	 */
	public void WebsiteStrategeCreate(PromotionWebVO vo){
		
	}
			
	/**
	 * 查看异常订单
	 * @return 订单VO列表
	 */
	public ArrayList<OrderOnWebVO> AbnormalOrderScan(){
		return order.abnormalOrderScan();
	}
			
	/**
	 * 修改用户信用值
	 * @param 用户IDVO
	 * @param 增加值
	 * @return 修改后的用户信用值VO
	 */
	public IntegralVO UserCreditModification(UserIDVO vo,int n){
		return null;
	}


	/**
	 * 查看网站营销策略
	 * @return 网站营销策略列表
	 */
	public ArrayList<PromotionWebVO> WebsiteStrategeInquire() {
		return null;
	}

	/**
	 * 查看用户信用值信息
	 * @param 用户IDVO
	 * @return 用户信用信息VO
	 */
	public IntegralVO userCreditInquire(UserIDVO vo) {
		return null;
	}
}
