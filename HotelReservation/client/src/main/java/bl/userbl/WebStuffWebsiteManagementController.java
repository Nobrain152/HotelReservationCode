package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.WebStuffWebsiteManagementBLService;
import vo.CreditVO;
import vo.OrderVO;
import vo.PromotionWebVO;


/**
 * 网站营销人员对网站的操作
 * @author 曹畅
 *
 */
public class WebStuffWebsiteManagementController implements WebStuffWebsiteManagementBLService {

	private WebStuff stuff;
	
	public  WebStuffWebsiteManagementController(){
		stuff=new WebStuff();
	}
	
	/**
	 * 创建网站促销策略
	 * @param 网站促销策略VO
	 */
	public void WebsiteStrategeCreate(PromotionWebVO vo){
		stuff.WebsiteStrategeCreate(vo);
	}
			
	/**
	 * 查看异常订单
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> AbnormalOrderScan(){
		return stuff.AbnormalOrderScan();
	}
			
	/**
	 * 修改用户信用值
	 * @param 用户IDVO
	 * @param 增加值
	 * @return 修改后的用户信用值VO
	 */
	public CreditVO UserCreditModification(String userid,int n){
		return stuff.UserCreditModification(userid, n);
	}


	/**
	 * 查看网站营销策略
	 * @return 网站营销策略列表
	 */
	public ArrayList<PromotionWebVO> WebsiteStrategeInquire() {
		return stuff.WebsiteStrategeInquire();
	}

	/**
	 * 查看用户信用值信息
	 * @param 用户IDVO
	 * @return 用户信用信息VO
	 */
	public CreditVO userCreditInquire(String userid) {
		return stuff.userCreditInquire(userid);
	}
}
