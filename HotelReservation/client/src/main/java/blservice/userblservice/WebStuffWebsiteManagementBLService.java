package blservice.userblservice;

import java.util.ArrayList;

import vo.IntegralVO;
import vo.OrderOnWebVO;
import vo.PromotionWebVO;
import vo.UserIDVO;



/**
 * ��վӪ����Ա����վ�Ĳ���
 * @author �ܳ�
 *
 */
public interface WebStuffWebsiteManagementBLService{
	
	
	
	/**
	 * �鿴��վӪ������
	 * @return ��վӪ�������б�
	 */
	public ArrayList<PromotionWebVO> WebsiteStrategeInquire();
	
	/**
	 * ������վ��������
	 * @param ��վ��������VO
	 */
	public void WebsiteStrategeCreate(PromotionWebVO vo);
		
	/**
	 * �鿴�쳣����
	 * @return ����VO�б�
	 */
	public ArrayList<OrderOnWebVO> AbnormalOrderScan();
	
	/**
	 * �鿴�û�����ֵ��Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public IntegralVO userCreditInquire(UserIDVO vo);
	
	/**
	 * �޸��û�����ֵ
	 * @param �û�IDVO
	 * @param ����ֵ
	 * @return �޸ĺ���û�����ֵVO
	 */
	public IntegralVO UserCreditModification(UserIDVO vo,int n);
		
		
}