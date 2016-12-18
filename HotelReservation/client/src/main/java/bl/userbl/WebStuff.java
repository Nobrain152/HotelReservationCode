
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
 * ��վӪ����Ա��
 * @author �ܳ�
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
	 * �鿴������Ϣ	
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		UserInfoPO po= user.GetWebStuffInfo(userid);
		UserInfoVO vo=(UserInfoVO)VOPOchange.POtoVO(po);
		return vo;
	}
			
	/**
	 * �޸ĸ�����Ϣ	
	 * @param �û�IDVO
	 * @param �û���ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO po= (UserInfoPO)VOPOchange.VOtoPO(vo2);
		return user.SetWebStuffInfo(userid, po);
	}
	
	/**
	 * ������վ��������
	 * @param ��վ��������VO
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
	 * �޸���վ��������
	 * @param ��վ��������VO
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
	 * �鿴�쳣����
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> AbnormalOrderScan()throws RemoteException{
		return order.abnormalOrderScan();
		
	}
			
	/**
	 * �޸��û�����ֵ
	 * @param �û�IDVO
	 * @param ����ֵ
	 * @return �޸ĺ���û�����ֵVO
	 */
	public ResultMsg UserCreditModification(String userid,int n)throws RemoteException{
		CustomerInfoVO vo=(CustomerInfoVO)VOPOchange.POtoVO(user.GetWebStuffInfo(userid));
		return inte.changeCredit(vo, n);
	}


	/**
	 * �鿴��վӪ������
	 * @return ��վӪ�������б�
	 */
	public ArrayList<PromotionWebVO> WebsiteStrategeInquire(PromotionWebVO vo)throws RemoteException {
		return pro.getWebPromotion(vo.getType());
	}

	/**
	 * �鿴�û�����ֵ��Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public int userCreditInquire(String userid)throws RemoteException {
		CustomerInfoVO vo=(CustomerInfoVO)VOPOchange.POtoVO(user.GetWebStuffInfo(userid));
		return inte.getCredit(vo);
	}
		
	/**
	 * ���ÿ��δִ�ж���
	 * @param today
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> dayUnexOrder(String today) throws RemoteException {
		return order.dayUnexOrder(today);
	}
	
	/**
	 * ɾ����վ��������
	 * @param ��վ��������VO
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
