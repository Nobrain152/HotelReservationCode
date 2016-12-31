package blservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.OrderState;
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
	public HotelInfoVO hotelInfoInq(String hotelid);
		
	/**
	 * �޸ľƵ���Ϣ	
	 * @param �Ƶ�VO
	 * @param �û�IDVO
	 * @return �޸Ľ��
	 */
	public ResultMsg hotelInfoMod(HotelInfoVO vo1,String userid);
	
	/**
	 * ɾ���Ƶ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean hotelStrategeDelete(PromotionHotelVO vo);
	
	/**
	 * �޸ľƵ귿����Ϣ
	 * @param rooms
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg setRoomInfo(ArrayList<RoomInfoVO> rooms);
	
	/**
	 * �鿴�Ƶ��������
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���������б�
	 */
	public ArrayList<PromotionHotelVO> hotelPromotionInq(PromotionHotelVO vo);
	
	/**
	 * �޸ľƵ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean hotelStrategeManage(PromotionHotelVO vo); 
	
	/**
	 * ���ӾƵ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean hotelStrategeAdd(PromotionHotelVO vo);
		
	/**
	 * ���¶���״̬	
	 * @param �û�IDVO
	 * @param ����VO
	 * @throws RemoteException 
	 */
	public ResultMsg orderStateUpdate(String userid,OrderVO vo2) throws RemoteException;
		
	/**
	 * ����Ƶ궩��	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> orderScan(String hotelid);
	
	/**
	 * ����Ƶ��쳣����	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> abnormalOrderScan(String hotelid);
	
	/**
	 * �����������
	 * @param hotelid
	 * @param state
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> specialOrderScan(String hotelid,OrderState state);
	
	/**
	 * ���·�����Ϣ
	 * @param ������ϢVO
	 */
	public ResultMsg updateRoomState(RoomInfoVO vo);
	
	/**
	 * ¼����÷���
	 * @param rooms
	 */
	public ResultMsg typeInRoom(RoomInfoVO room);
	
	
	/**
	 * �鿴�Ƶ����пͷ���Ϣ
	 * @param hotelid
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> hotelRoomList(String hotelid);
	
	/**
	 * �Ƶ깤����Ա���Ķ���״̬
	 * @param hotelid
	 * @param orderid
	 *
	 */
	public ResultMsg setAbnormalOrder(String hotelid,String orderid);
		
}