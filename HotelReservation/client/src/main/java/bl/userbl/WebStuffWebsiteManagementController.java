package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.WebStuffWebsiteManagementBLService;
import vo.IntegralVO;
import vo.OrderOnWebVO;
import vo.PromotionWebVO;


/**
 * ��վӪ����Ա����վ�Ĳ���
 * @author �ܳ�
 *
 */
public class WebStuffWebsiteManagementController implements WebStuffWebsiteManagementBLService {

	private WebStuff stuff;
	
	public  WebStuffWebsiteManagementController(){
		stuff=new WebStuff();
	}
	
	/**
	 * ������վ��������
	 * @param ��վ��������VO
	 */
	public void WebsiteStrategeCreate(PromotionWebVO vo){
		stuff.WebsiteStrategeCreate(vo);
	}
			
	/**
	 * �鿴�쳣����
	 * @return ����VO�б�
	 */
	public ArrayList<OrderOnWebVO> AbnormalOrderScan(){
		return stuff.AbnormalOrderScan();
	}
			
	/**
	 * �޸��û�����ֵ
	 * @param �û�IDVO
	 * @param ����ֵ
	 * @return �޸ĺ���û�����ֵVO
	 */
	public IntegralVO UserCreditModification(String userid,int n){
		return stuff.UserCreditModification(userid, n);
	}


	/**
	 * �鿴��վӪ������
	 * @return ��վӪ�������б�
	 */
	public ArrayList<PromotionWebVO> WebsiteStrategeInquire() {
		return stuff.WebsiteStrategeInquire();
	}

	/**
	 * �鿴�û�����ֵ��Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public IntegralVO userCreditInquire(String userid) {
		return stuff.userCreditInquire(userid);
	}
}
