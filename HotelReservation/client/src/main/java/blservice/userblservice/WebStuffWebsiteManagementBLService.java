package blservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMsg;
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
	public ArrayList<PromotionWebVO> WebsiteStrategeInquire(PromotionWebVO vo);
	
	/**
	 * ������վ��������
	 * @param ��վ��������VO
	 */
	public void WebsiteStrategeCreate(PromotionWebVO vo);
	
	/**
	 * �޸���վ��������
	 * @param ��վ��������VO
	 */
	public ResultMsg WebsiteStrategeMod(PromotionWebVO vo);
		
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
	public int userCreditInquire(String userid);
	
	/**
	 * �޸��û�����ֵ
	 * @param �û�IDVO
	 * @param ����ֵ
	 * @return �޸ĺ���û�����ֵVO
	 */
	public ResultMsg UserCreditModification(String userid,int n);
	
	/**
	 * ���ÿ��δִ�ж���
	 * @param today
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> dayUnexOrder(String today);
		
		
}