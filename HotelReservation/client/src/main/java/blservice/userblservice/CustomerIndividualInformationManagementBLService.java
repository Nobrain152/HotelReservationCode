package blservice.userblservice;

import java.util.ArrayList;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderOnUserVO;
import vo.UserIDVO;
import vo.UserInfoVO;
import vo.IntegralVO;


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
	public UserInfoVO IndividualBaseInfolnquiry(UserIDVO vo);
		
	/**
	 * �޸ĸ��˻�����Ϣ
	 * @param �û�IDVO
	 * @param �ͻ�������ϢVO
	 * @return �޸ĳɹ����
	 */
	public boolean IndividualBaseInfoModification(UserIDVO vo1,CustomerInfoVO vo2);
		
	/**
	 * ��ѯ���˶���
	 * @param �û�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderOnUserVO> IndividualOrderInquiry(UserIDVO vo);
		
	/**
	 * ��ѯԤ�����ľƵ�	
	 * @param �û�IDVO
	 * @return �Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(UserIDVO vo);
		
	/**
	 * ��ѯ����������Ϣ	
	 * @param �û�IDVO
	 * @return ����VO
	 */
	public IntegralVO IndividualCredictInquiry(UserIDVO vo);
		
			
}