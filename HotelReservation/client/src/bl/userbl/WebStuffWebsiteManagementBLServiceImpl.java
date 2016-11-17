package businesslogicserviceimpl.userblserviceimpl;

import java.util.ArrayList;

import vo.IntegralVO;
import vo.OrderOnWebVO;
import vo.PromotionWebVO;
import vo.UserIDVO;
import businesslogicservice.userblservice.WebStuffWebsiteManagementBLService;
import businesslogicserviceimpl.Integralblserviceimpl.IntegralImpl;
import businesslogicserviceimpl.Promotionbl.PromotionWebImpl;
import businesslogicserviceimpl.orderblserviceimpl.OrderOnWebBLServiceImpl;


/**
 * ��վӪ����Ա����վ�Ĳ���
 * @author �ܳ�
 *
 */
public class WebStuffWebsiteManagementBLServiceImpl implements WebStuffWebsiteManagementBLService {

	PromotionWebImpl pro;
	OrderOnWebBLServiceImpl order;
	IntegralImpl inte;
	
	public  WebStuffWebsiteManagementBLServiceImpl(){
		pro=new PromotionWebImpl();
		order=new OrderOnWebBLServiceImpl();
		inte=new IntegralImpl();
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
		return order.abnormalOrderScan();
	}
			
	/**
	 * �޸��û�����ֵ
	 * @param �û�IDVO
	 * @param ����ֵ
	 * @return �޸ĺ���û�����ֵVO
	 */
	public IntegralVO UserCreditModification(UserIDVO vo,int n){
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
	public IntegralVO userCreditInquire(UserIDVO vo) {
		return null;
	}
}
