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
	public ArrayList<PromotionWebVO> websiteStrategeInq(PromotionWebVO vo);
	
	/**
	 * ������վ��������
	 * @param ��վ��������VO
	 */
	public boolean websiteStrategeCreate(PromotionWebVO vo);
	
	/**
	 * �޸���վ��������
	 * @param ��վ��������VO
	 */
	public ResultMsg websiteStrategeMod(PromotionWebVO vo);
	
	/**
	 * ɾ����վ��������
	 * @param ��վ��������VO
	 */
	public ResultMsg websiteStrategeDelete(PromotionWebVO vo);
		
	/**
	 * �鿴�쳣����
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> abnormalOrderScan();
	
	/**
	 * �鿴�û�����ֵ��Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public int userCreditInq(String userid);
	
	/**
	 * �޸��û�����ֵ
	 * @param �û�IDVO
	 * @param ����ֵ
	 * @return �޸ĺ���û�����ֵVO
	 */
	public ResultMsg userCreditMod(String userid,int n);
	
	/**
	 * ���ÿ��δִ�ж���
	 * @param today
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> dayUnexOrder(String today);
		
		
}