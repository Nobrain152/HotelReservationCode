package blservice.userblservice;

import java.util.ArrayList;

import vo.CreditVO;
import vo.OrderVO;
import vo.PromotionWebVO;



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
	public ArrayList<OrderVO> AbnormalOrderScan();
	
	/**
	 * �鿴�û�����ֵ��Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public CreditVO userCreditInquire(String userid);
	
	/**
	 * �޸��û�����ֵ
	 * @param �û�IDVO
	 * @param ����ֵ
	 * @return �޸ĺ���û�����ֵVO
	 */
	public CreditVO UserCreditModification(String userid,int n);
		
		
}