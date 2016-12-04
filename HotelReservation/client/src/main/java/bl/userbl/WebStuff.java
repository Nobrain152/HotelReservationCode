
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
 * ��վӪ����Ա��
 * @author �ܳ�
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
		//��ע�͵���ʹ���ܹ����У�����д��ʱ�򣬰�ע�ͷ���ȡ���ͺ�
		//order = new OrderOnWeb(orderDataService, creditDataService);
		inte=new CreditController();
		this.user=user;
	}
	
	
	/**
	 * �鿴������Ϣ	
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		UserInfoPO po= user.GetUserBaseInfo(userid);
		UserInfoVO vo=new UserInfoVO(po.getUserID(),po.getUsername(),(ContactVO)VOPOchange.POtoVO(po.getContact()));
		return vo;
	}
			
	/**
	 * �޸ĸ�����Ϣ	
	 * @param �û�IDVO
	 * @param �û���ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO po= new UserInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()));
		return user.SetUserBaseInfo(userid, po);
	}
	
	/**
	 * ������վ��������
	 * @param ��վ��������VO
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
	 * �޸���վ��������
	 * @param ��վ��������VO
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
	 * �鿴�쳣����
	 * @return ����VO�б�
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
	 * �޸��û�����ֵ
	 * @param �û�IDVO
	 * @param ����ֵ
	 * @return �޸ĺ���û�����ֵVO
	 */
	public ResultMsg UserCreditModification(String userid,int n)throws RemoteException{
		CustomerInfoVO vo=(CustomerInfoVO)VOPOchange.POtoVO(user.GetUserBaseInfo(userid));
		return inte.changeCredit(vo, n);
	}


	/**
	 * �鿴��վӪ������
	 * @return ��վӪ�������б�
	 */
	public ArrayList<PromotionWebVO> WebsiteStrategeInquire(PromotionWebVO vo)throws RemoteException {
		return pro.getWebPromotion(vo.getType(),vo.getHotelID());
	}

	/**
	 * �鿴�û�����ֵ��Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public int userCreditInquire(String userid)throws RemoteException {
		CustomerInfoVO vo=(CustomerInfoVO)VOPOchange.POtoVO(user.GetUserBaseInfo(userid));
		return inte.getCredit(vo);
	}
	
	}
