
package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import blservice.creditblservice.CreditBLService;
import blservice.orderblservice.OrderOnWebBLService;
import blservice.promotionblservice.PromotionWebBLService;
import dataservice.userdataservice.UserManagementDataService;
import po.UserInfoPO;
import util.PromotionWebType;
import util.ResultMsg;
import vo.CustomerInfoVO;
import vo.OrderVO;
import vo.PromotionWebVO;
import vo.UserInfoVO;

/**
 * 网站营销人员类
 * @author 曹畅
 *
 */
public class WebStuff extends User{

	private UserManagementDataService user;
	private PromotionWebBLService pro;
	private OrderOnWebBLService order;
	private CreditBLService inte;
	private BusinessLogicDataFactory factory;
	
	
	public  WebStuff(UserManagementDataService user){
		super(user);
		factory=BusinessLogicDataFactory.getFactory();
		pro = factory.getPromotionWebBLService();
		order = factory.getOrderOnWebBLService();
		inte=factory.getCreditBLService();
		this.user=user;
	}
	
	
	/**
	 * 查看个人信息	
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		UserInfoPO po= user.GetWebStuffInfo(userid);
		UserInfoVO vo=(UserInfoVO)VOPOchange.POtoVO(po);
		return vo;
	}
			
	/**
	 * 修改个人信息	
	 * @param 用户IDVO
	 * @param 用户信息VO
	 * @return 修改结果
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO po= (UserInfoPO)VOPOchange.VOtoPO(vo2);
		return user.SetWebStuffInfo(userid, po);
	}
	
	/**
	 * 创建网站促销策略
	 * @param 网站促销策略VO
	 */
	public ResultMsg WebsiteStrategeCreate(PromotionWebVO vo)throws RemoteException{
		PromotionWebType type=vo.getType();
		ResultMsg msg=null;
		if(type==PromotionWebType.VIP_LEVEL_PROMOTION){
			msg=pro.addLevelCut(vo.getLevel(),vo.getRatio());
		}
		else if(type==PromotionWebType.VIP_CIRCLE_PROMOTION){
			msg=pro.addCircleCut(vo.getLocation(),vo.getRatio());
		}
		else{
			msg=pro.addWebCustomCut(vo.getTimeBegin(),vo.getTimeOver(),vo.getRatio());
		}
		
		return msg;
	}
	
	/**
	 * 修改网站促销策略
	 * @param 网站促销策略VO
	 */
	public ResultMsg WebsiteStrategeMod(PromotionWebVO vo)throws RemoteException{
		PromotionWebType type=vo.getType();
		ResultMsg msg=null;
		if(type==PromotionWebType.VIP_LEVEL_PROMOTION){
			msg=pro.changeLevelCut(vo.getLevel(),vo.getRatio());
		}
		else if(type==PromotionWebType.VIP_CIRCLE_PROMOTION){
			msg=pro.changeCircleCut(vo.getLocation(),vo.getRatio());
		}
		else{
			msg=pro.changeWebCustomCut(vo.getTimeBegin(),vo.getTimeOver(),vo.getRatio());
		}
		
		return msg;
	}
	
			
	/**
	 * 查看异常订单
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> AbnormalOrderScan()throws RemoteException{
		return order.abnormalOrderScan();
		
	}
			
	/**
	 * 修改用户信用值
	 * @param 用户IDVO
	 * @param 增加值
	 * @return 修改后的用户信用值VO
	 */
	public ResultMsg UserCreditModification(String userid,int n)throws RemoteException{
		CustomerInfoVO vo=(CustomerInfoVO)VOPOchange.POtoVO(user.GetWebStuffInfo(userid));
		return inte.changeCredit(vo, n);
	}


	/**
	 * 查看网站营销策略
	 * @return 网站营销策略列表
	 */
	public ArrayList<PromotionWebVO> WebsiteStrategeInquire(PromotionWebVO vo)throws RemoteException {
		return pro.getWebPromotion(vo.getType());
	}

	/**
	 * 查看用户信用值信息
	 * @param 用户IDVO
	 * @return 用户信用信息VO
	 */
	public int userCreditInquire(String userid)throws RemoteException {
		CustomerInfoVO vo=(CustomerInfoVO)VOPOchange.POtoVO(user.GetWebStuffInfo(userid));
		return inte.getCredit(vo);
	}
		
	/**
	 * 浏览每日未执行订单
	 * @param today
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> dayUnexOrder(String today) throws RemoteException {
		return order.dayUnexOrder(today);
	}
	
	/**
	 * 删除网站促销策略
	 * @param 网站促销策略VO
	 */
	public ResultMsg WebsiteStrategeDelete(PromotionWebVO vo)throws RemoteException{
		PromotionWebType type=vo.getType();
		ResultMsg msg=null;
		if(type==PromotionWebType.VIP_LEVEL_PROMOTION){
			msg=pro.deleteLevelCut(vo.getLevel());
		}
		else if(type==PromotionWebType.VIP_CIRCLE_PROMOTION){
			msg=pro.deleteCircleCut(vo.getLocation());
		}
		else{
			msg=pro.deleteWebCustomCut(vo.getTimeBegin(),vo.getTimeOver());
		}
		
		return msg;
	}
	
	
	}
