package businesslogicservice.userblservice;

import java.util.ArrayList;

import vo.HotelEvaluateVO;
import vo.HotelIDVO;
import vo.HotelInfoVO;
import vo.OrderOnUserVO;
import vo.VipVO;

/**
 * �ͻ��ԾƵ�Ĳ���
 * 
 * @author �ܳ�
 *
 */
public interface CustomerHotelOperationBlService{
        
	/**
	 * ��������ľƵ������������ط��������ľƵ���ϢVO�б�
	 * @param ɸѡ����VO
	 * @return �Ƶ���ϢVO�б�
	 */
	public ArrayList<HotelInfoVO> HotelSearch(HotelInfoVO vo);
	
	
	/**
	 * ��ĳһ�Ƶ����ɶ���
	 * @param �Ƶ�IDVO
	 * @param ����VO
	 *
	 */
	public void OederCreat(HotelIDVO vo1,OrderOnUserVO vo2);
		
	/**
	 * ���۾Ƶ�	
	 * @param �Ƶ�����VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo);
		
	
	/**
	 * �����Ա
	 * @param �Ƶ�IDVO
	 * @param ��Ա��ϢVO
	 */
	public void MemberRegisterApply(HotelIDVO vo1,VipVO vo2);
		
			
}