package blservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;

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
	public HotelInfoVO HotelInformationInquiry(String hotelid);
		
	/**
	 * �޸ľƵ���Ϣ	
	 * @param �Ƶ�VO
	 * @param �û�IDVO
	 * @return �޸Ľ��
	 */
	public ResultMsg HotelInformationModification(HotelInfoVO vo1,String userid);
		
	/**
	 * �鿴�Ƶ��������
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���������б�
	 */
	public ArrayList<PromotionHotelVO> HotelPromotionInquire(PromotionHotelVO vo);
	
	/**
	 * �޸ľƵ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean HotelStrategeManage(PromotionHotelVO vo); 
	
	/**
	 * ���ӾƵ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean HotelStrategeAdd(PromotionHotelVO vo);
		
	/**
	 * ���¶���״̬	
	 * @param �û�IDVO
	 * @param ����VO
	 * @throws RemoteException 
	 */
	public ResultMsg OrderStateUpdate(String userid,OrderVO vo2) throws RemoteException;
		
	/**
	 * ����Ƶ궩��	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> OrderScan(String hotelid);
	
	/**
	 * ���·�����Ϣ
	 * @param ������ϢVO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo);
		
}