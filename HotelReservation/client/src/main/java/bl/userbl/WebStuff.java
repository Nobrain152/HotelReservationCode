
package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import bl.creditbl.CreditController;
import bl.orderbl.OrderOnWeb;
import bl.promotionbl.PromotionWebController;
import dataservice.creditdataservice.CreditDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.userdataservice.UserManagementDataService;
import po.ContactPO;
import po.UserInfoPO;
import util.PromotionWebType;
import util.ResultMsg;
import vo.ContactVO;
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
	private PromotionWebController pro;
	private OrderOnWeb order;
	private CreditController inte;
	private OrderDataService orderDataService;
	private CreditDataService creditDataService;
	
	public  WebStuff(UserManagementDataService user){
		super(user);
		pro = new PromotionWebController();
		//先注释掉，使其能够运行，你们写的时候，把注释符号取消就好
		//order = new OrderOnWeb(orderDataService, creditDataService);
		inte=new CreditController();
		this.user=user;
	}
	
	
	/**
	 * 查看个人信息	
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
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
	public ResultMsg IndividualBaseInfoModification(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO po= new UserInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()));
		return user.SetUserBaseInfo(userid, po);
	}
	
	/**
	 * 创建网站促销策略
	 * @param 网站促销策略VO
	 */
	public ResultMsg WebsiteStrategeCreate(PromotionWebVO vo)throws RemoteException{
		PromotionWebType type=vo.getType();
		ResultMsg msg=null;
		if(type==PromotionWebType.VIP_LEVEL_PROMOTION){
			msg=pro.addLevelCut(vo.getLevel(),vo.getRatio(),vo.getHotelID());
		}
		else if(type==PromotionWebType.VIP_CIRCLE_PROMOTION){
			msg=pro.addCircleCut(vo.getLocation(),vo.getRatio(),vo.getHotelID());
		}
		else{
			msg=pro.addWebCustomCut(vo.getTimeBegin(),vo.getTimeOver(),vo.getRatio(),vo.getHotelID());
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
			msg=pro.changeLevelCut(vo.getLevel(),vo.getRatio(),vo.getHotelID());
		}
		else if(type==PromotionWebType.VIP_CIRCLE_PROMOTION){
			msg=pro.changeCircleCut(vo.getLocation(),vo.getRatio(),vo.getHotelID());
		}
		else{
			msg=pro.changeWebCustomCut(vo.getTimeBegin(),vo.getTimeOver(),vo.getRatio(),vo.getHotelID());
		}
		
		return msg;
	}
	
			
	/**
	 * 查看异常订单
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> AbnormalOrderScan()throws RemoteException{
		try {
			return order.abnormalOrderScan();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
	}
			
	/**
	 * 修改用户信用值
	 * @param 用户IDVO
	 * @param 增加值
	 * @return 修改后的用户信用值VO
	 */
	public ResultMsg UserCreditModification(String userid,int n)throws RemoteException{
		CustomerInfoVO vo=(CustomerInfoVO)VOPOchange.POtoVO(user.GetUserBaseInfo(userid));
		return inte.changeCredit(vo, n);
	}


	/**
	 * 查看网站营销策略
	 * @return 网站营销策略列表
	 */
	public ArrayList<PromotionWebVO> WebsiteStrategeInquire(PromotionWebVO vo)throws RemoteException {
		return pro.getWebPromotion(vo.getType(),vo.getHotelID());
	}

	/**
	 * 查看用户信用值信息
	 * @param 用户IDVO
	 * @return 用户信用信息VO
	 */
	public int userCreditInquire(String userid)throws RemoteException {
		CustomerInfoVO vo=(CustomerInfoVO)VOPOchange.POtoVO(user.GetUserBaseInfo(userid));
		return inte.getCredit(vo);
	}
	
	}
