
package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import bl.creditbl.CreditController;
import bl.orderbl.OrderOnWeb;
import bl.promotionbl.PromotionWebController;
import data.userdata.UserManagementDataServiceImpl;
import dataservice.creditdataservice.CreditDataService;
import dataservice.orderdataservice.OrderDataService;
import po.ContactPO;
import po.UserInfoPO;
import vo.ContactVO;
import vo.CreditVO;
import vo.OrderVO;
import vo.PromotionWebVO;
import vo.UserInfoVO;

public class WebStuff extends User{

	private UserManagementDataServiceImpl user;
	private PromotionWebController pro;
	private OrderOnWeb order;
	private CreditController inte;
	private OrderDataService orderDataService;
	private CreditDataService creditDataService;
	
	public  WebStuff(){
		pro = new PromotionWebController();
		order = new OrderOnWeb(orderDataService, creditDataService);
		inte=new CreditController();
		user=new UserManagementDataServiceImpl();
	}
	
	
	/**
	 * 查看个人信息	
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
		UserInfoPO po= user.GetUserBaseInfo(userid);
		UserInfoVO vo=new UserInfoVO(po.getUserID(),po.getUsername(),(ContactVO)VOPOchange.POtoVO(po.getContact()));
		return vo;
	}
			
	/**
	 * 修改个人信息	
	 * @param 用户IDVO
	 * @param 用户信息VO
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(String userid,UserInfoVO vo2){
		UserInfoPO po= new UserInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()));
		return user.SetUserBaseInfo(userid, po);
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
	public ArrayList<OrderVO> AbnormalOrderScan(){
		try {
			return order.abnormalOrderScan();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
			
	/**
	 * 修改用户信用值
	 * @param 用户IDVO
	 * @param 增加值
	 * @return 修改后的用户信用值VO
	 */
	public CreditVO UserCreditModification(String userid,int n){
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
	public CreditVO userCreditInquire(String userid) {
		return null;
	}
}
