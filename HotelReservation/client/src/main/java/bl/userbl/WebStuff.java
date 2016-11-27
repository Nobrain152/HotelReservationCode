package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.integralbl.IntegralController;
import bl.orderbl.OrderOnWeb;
import bl.promotionbl.PromotionWebController;
import data.userdata.UserManagementDataServiceImpl;
import po.UserInfoPO;
import vo.IntegralVO;
import vo.OrderOnWebVO;
import vo.PromotionWebVO;
import vo.UserInfoVO;

public class WebStuff extends User{

	private UserManagementDataServiceImpl user;
	private PromotionWebController pro;
	private OrderOnWeb order;
	private IntegralController inte;
	
	public  WebStuff(){
		pro=new PromotionWebController();
		order=new OrderOnWeb();
		inte=new IntegralController();
		user=new UserManagementDataServiceImpl();
	}
	
	
	/**
	 * �鿴������Ϣ	
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
		UserInfoPO po= user.GetUserBaseInfo(userid);
		UserInfoVO vo=new UserInfoVO(po.getUserid(),po.getUsername(),po.getContact());
		return vo;
	}
			
	/**
	 * �޸ĸ�����Ϣ	
	 * @param �û�IDVO
	 * @param �û���ϢVO
	 * @return �޸Ľ��
	 */
	public boolean IndividualBaseInfoModification(String userid,UserInfoVO vo2){
		UserInfoPO po= new UserInfoPO(vo2.getUserid(),vo2.getUsername(),vo2.getContact());
		return user.SetUserBaseInfo(userid, po);
	}
	
	/**
	 * ������վ��������
	 * @param ��վ��������VO
	 */
	public void WebsiteStrategeCreate(PromotionWebVO vo){
		
	}
			
	/**
	 * �鿴�쳣����
	 * @return ����VO�б�
	 */
	public ArrayList<OrderOnWebVO> AbnormalOrderScan(){
		try {
			return order.abnormalOrderScan();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
			
	/**
	 * �޸��û�����ֵ
	 * @param �û�IDVO
	 * @param ����ֵ
	 * @return �޸ĺ���û�����ֵVO
	 */
	public IntegralVO UserCreditModification(String userid,int n){
		return null;
	}


	/**
	 * �鿴��վӪ������
	 * @return ��վӪ�������б�
	 */
	public ArrayList<PromotionWebVO> WebsiteStrategeInquire() {
		return null;
	}

	/**
	 * �鿴�û�����ֵ��Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public IntegralVO userCreditInquire(String userid) {
		return null;
	}
}
