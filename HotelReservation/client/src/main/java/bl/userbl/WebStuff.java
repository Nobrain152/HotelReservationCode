
package bl.userbl;


import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.creditbl.CreditController;
import bl.orderbl.OrderOnWebController;
import bl.promotionbl.PromotionWebController;
import dataservice.userdataservice.UserManagementDataService;
import po.CreditPO;
import po.CustomerInfoPO;
import po.UserInfoPO;
import util.PromotionWebType;
import util.ResultMsg;
import util.Today;
import util.UserType;
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
	private OrderOnWebController order;
	private CreditController inte;
	private BusinessLogicDataFactory factory=BusinessLogicDataFactory.getFactory();
	
	
	public  WebStuff(UserManagementDataService user){
		super(user);
		this.user=user;
	}
	
	
	/**
	 * �鿴������Ϣ	
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO individualInfolnq(String userid)throws RemoteException{
		UserInfoPO po= user.getWebStuffInfo(userid);
		UserInfoVO vo=(UserInfoVO)VOPOchange.POtoVO(po);
		return vo;
	}
			
	/**
	 * �޸ĸ�����Ϣ	
	 * @param �û�IDVO
	 * @param �û���ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg individualInfoMod(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO past= user.getWebStuffInfo(userid);
		past.setType(UserType.WebStuff);
		if(vo2.getContact()!=null){
			if(vo2.getContact().length()!=11){
				return ResultMsg.WRONG_PHONENUMBER;
			}
			past.setContact(vo2.getContact());
		}
		if(vo2.getUsername()!=null){
			past.setUsername(vo2.getUsername());
		}
		return user.setWebStuffInfo(userid,past);
	}
	
	/**
	 * ������վ��������
	 * @param ��վ��������VO
	 */
	public ResultMsg websiteStrategeCreate(PromotionWebVO vo)throws RemoteException{
		PromotionWebType type=vo.getType();
		ResultMsg msg=null;
		pro = (PromotionWebController)factory.getPromotionWebBLService();
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
	public ResultMsg websiteStrategeMod(PromotionWebVO vo)throws RemoteException{
		PromotionWebType type=vo.getType();
		ResultMsg msg=null;
		pro = (PromotionWebController)factory.getPromotionWebBLService();
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
	public ArrayList<OrderVO> abnormalOrderScan()throws RemoteException{
		order = (OrderOnWebController)factory.getOrderOnWebBLService();
		return order.abnormalOrderScan();
	}
			
	/**
	 * �޸��û�����ֵ
	 * @param �û�IDVO
	 * @param ����ֵ
	 * @return �޸ĺ���û�����ֵVO
	 */
	public ResultMsg userCreditMod(String userid,int n)throws RemoteException{
		inte=(CreditController)factory.getCreditBLService();
		CreditPO cre=inte.get(userid);
		String string="+"+n;
		CreditPO cre1=new CreditPO(cre.getUserID(),null,new Today().getToday(),util.Action.Charge,string,cre.getCreditResult()+n);
		CustomerInfoPO customerInfo = user.getCustomerInfo(userid);
		customerInfo.setCredit(cre.getCreditResult()+n);
		user.setCustomerInfo(userid, customerInfo);
		return inte.insert(cre1);
	}


	/**
	 * �鿴��վӪ������
	 * @return ��վӪ�������б�
	 */
	public ArrayList<PromotionWebVO> websiteStrategeInq(PromotionWebVO vo)throws RemoteException {
		pro = (PromotionWebController)factory.getPromotionWebBLService();
		return pro.getWebPromotion(vo.getType());
	}

	/**
	 * �鿴�û�����ֵ��Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public int userCreditInq(String userid)throws RemoteException {
		CustomerInfoVO vo=(CustomerInfoVO)VOPOchange.POtoVO(user.getWebStuffInfo(userid));
		inte=(CreditController)factory.getCreditBLService();
		return inte.getCredit(vo);
	}
		
	/**
	 * ���ÿ��δִ�ж���
	 * @param today
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> dayUnexOrder(String today) throws RemoteException {
		order = (OrderOnWebController)factory.getOrderOnWebBLService();
		return order.dayUnexOrder(new Today().getToday());
	}
	
	/**
	 * ɾ����վ��������
	 * @param ��վ��������VO
	 */
	public ResultMsg websiteStrategeDelete(PromotionWebVO vo)throws RemoteException{
		PromotionWebType type=vo.getType();
		ResultMsg msg=null;
		pro = (PromotionWebController)factory.getPromotionWebBLService();
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