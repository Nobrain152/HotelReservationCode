package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;

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
	public ArrayList<HotelInfoVO> HotelSearch(HotelInfoVO vo,String userid);
	
	
	/**
	 * ��ĳһ�Ƶ����ɶ���
	 * @param �Ƶ�IDVO
	 * @param ����VO
	 *
	 */
	public ResultMsg OederCreat(String hotelID,OrderVO vo2);
		
	/**
	 * ���۾Ƶ�	
	 * @param �Ƶ�����VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo);
	
	/**
	 * ����Ƶ��Ա
	 * @param �Ƶ�IDVO
	 * @param ��Ա��ϢVO
	 */
	public ResultMsg HotelMemberRegisterApply(VipType type,String pa,CustomerInfoVO vo);
		
	
	
		
			
}