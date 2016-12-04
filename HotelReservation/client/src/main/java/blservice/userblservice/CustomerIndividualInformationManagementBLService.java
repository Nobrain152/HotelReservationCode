package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.UserInfoVO;


/**
 * �ͻ����������Ϣ
 * @author �ܳ�
 *
 */
public interface CustomerIndividualInformationManagementBLService{
        
	/**
	 * ��ѯ���˻�����Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid);
		
	/**
	 * �޸ĸ��˻�����Ϣ
	 * @param �û�IDVO
	 * @param �ͻ�������ϢVO
	 * @return �޸ĳɹ����
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,CustomerInfoVO vo2);
		
	/**
	 * ��ѯ���˶���
	 * @param �û�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid);
		
	
	/**
	 * ��ѯ����δִ�ж�����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> UnfinishedOrderInquiry(String userid);
	
	
	/**
	 * ��ѯ������ִ�ж�����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> finishedOrderInquiry(String userid);
	
	
	/**
	 * ��ѯ������������Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> CancelOrderInquiry(String userid);
	
	
	/**
	 * ��ѯ�����쳣������Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> AbnormalOrderInquiry(String userid);
	
	
	/**
	 * ��ѯԤ�����ľƵ�	
	 * @param �û�IDVO
	 * @return �Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(String userid);
	
	/**
	 * ��ѯ����δִ�оƵ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> UnfinishedHotelInquiry(String userid);
	
	/**
	 * ��ѯ������ִ�оƵ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> finishedHotelInquiry(String userid);
	
	/**
	 * ��ѯ�����쳣�Ƶ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> AbnormalHotelInquiry(String userid);
	
	/**
	 * ��ѯ�������Ƶ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> CancelHotelInquiry(String userid);
		
	/**
	 * ��ѯ����������Ϣ	
	 * @param �û�IDVO
	 * @return ����VO
	 */
	public int[] IndividualCredictInquiry(String userid);
	
	/**
	 * ��ѯ����������Ϣ��¼	
	 * @param �û�IDVO
	 * @return ����VO
	 */
	public ArrayList<CreditVO> IndividualCredictRecord(String userid);
	
	/**
	 * ɾ�����˶���
	 * @param orderVO
	 * @return
	 */
	public ResultMsg personalOrderCancel(OrderVO orderVO);
	
	
	
	
			
}