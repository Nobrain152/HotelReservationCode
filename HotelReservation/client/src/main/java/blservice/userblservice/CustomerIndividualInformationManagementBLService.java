package blservice.userblservice;

import java.util.ArrayList;

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
	public boolean IndividualBaseInfoModification(String userid,CustomerInfoVO vo2);
		
	/**
	 * ��ѯ���˶���
	 * @param �û�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid);
		
	/**
	 * ��ѯԤ�����ľƵ�	
	 * @param �û�IDVO
	 * @return �Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(String userid);
		
	/**
	 * ��ѯ����������Ϣ	
	 * @param �û�IDVO
	 * @return ����VO
	 */
	public CreditVO IndividualCredictInquiry(String userid);
		
			
}