package blservice.userblservice;

import java.util.ArrayList;

import vo.HotelEvaluateVO;
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
	public void OederCreat(HotelInfoVO vo1,OrderOnUserVO vo2);
		
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
	public void MemberRegisterApply(HotelInfoVO vo1,VipVO vo2);
		
			
}