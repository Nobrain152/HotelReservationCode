package blservice.userblservice;

import java.util.ArrayList;

import po.CustomerInfoPO;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;


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
	public CustomerInfoVO individualInfolnq(String userid);
		
	/**
	 * �޸ĸ��˻�����Ϣ
	 * @param �û�IDVO
	 * @param �ͻ�������ϢVO
	 * @return �޸ĳɹ����
	 */
	public ResultMsg individualInfoMod(String userid,CustomerInfoVO vo2);
		
	/**
	 * ��ѯ���˶���
	 * @param �û�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> individualOrderInq(String userid);
		
	
	/**
	 * ��ѯ����δִ�ж�����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> unfinishedOrderInq(String userid);
	
	
	/**
	 * ��ѯ������ִ�ж�����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> finishedOrderInq(String userid);
	
	
	/**
	 * ��ѯ������������Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> cancelOrderInq(String userid);
	
	
	/**
	 * ��ѯ�����쳣������Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> abnormalOrderInq(String userid);
	
	
	/**
	 * ��ѯԤ�����ľƵ�	
	 * @param �û�IDVO
	 * @return �Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> individualHotelInq(String userid);
	
	/**
	 * ��ѯ����δִ�оƵ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> unfinishedHotelInq(String userid);
	
	/**
	 * ��ѯ������ִ�оƵ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> finishedHotelInq(String userid);
	
	/**
	 * ��ѯ�����쳣�Ƶ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> abnormalHotelInq(String userid);
	
	/**
	 * ��ѯ�������Ƶ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> cancelHotelInq(String userid);
		
	/**
	 * ��ѯ����������Ϣ	
	 * @param �û�IDVO
	 * @return ����VO
	 */
	public int individualCredictInq(String userid);
	
	/**
	 * ��ѯ����������Ϣ��¼	
	 * @param �û�IDVO
	 * @return ����VO
	 */
	public ArrayList<CreditVO> individualCredictRecord(String userid);
	
	/**
	 * ɾ�����˶���
	 * @param orderVO
	 * @return
	 */
	public ResultMsg orderCancel(OrderVO orderVO);

	/**
	 * �õ��û���Ϣ
	 * @param userID
	 * @return
	 */
	CustomerInfoPO getCustomerInfo(String userID);

	/*
	 * ���ø�����Ϣ
	 */
	void setCustomerInfo(String userID, CustomerInfoPO customerInfoPO);

	
			
}