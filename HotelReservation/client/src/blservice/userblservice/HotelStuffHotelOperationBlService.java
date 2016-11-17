package businesslogicservice.userblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.HotelIDVO;
import vo.HotelInfoVO;
import vo.OrderOnHotelVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;
import vo.UserIDVO;


/**
 * �Ƶ깤����Ա�ԾƵ���еĲ���
 * @author �ܳ�
 *
 */
public interface HotelStuffHotelOperationBlService{
		
		
	/**
	 * �鿴�Ƶ���Ϣ	
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���ϢVO
	 */
	public HotelInfoVO HotelInformationInquiry(HotelIDVO vo);
		
	/**
	 * �޸ľƵ���Ϣ	
	 * @param �Ƶ�VO
	 * @param �û�IDVO
	 * @return �޸Ľ��
	 */
	public ResultMsg HotelInformationModification(HotelInfoVO vo1,UserIDVO vo2);
		
	/**
	 * �鿴�Ƶ��������
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���������б�
	 */
	public ArrayList<PromotionHotelVO> HotelPromotionInquire(HotelIDVO vo);
	
	/**
	 * ����Ƶ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean HotelStrategeManage(HotelIDVO vo1,PromotionHotelVO vo); 
		
	/**
	 * ���¶���״̬	
	 * @param �û�IDVO
	 * @param ����VO
	 */
	public ResultMsg OrderStateUpdate(UserIDVO vo1,OrderOnHotelVO vo2);
		
	/**
	 * ����Ƶ궩��	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderOnHotelVO> OrderScan(HotelIDVO vo);
	
	/**
	 * ���·�����Ϣ
	 * @param ������ϢVO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo);
		
}