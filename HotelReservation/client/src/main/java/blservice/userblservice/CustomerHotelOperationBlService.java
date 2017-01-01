package blservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMsg;
import util.Sort;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;

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
	public ArrayList<HotelInfoVO> hotelSearch(RoomInfoVO vo1,HotelInfoVO vo,String userid,boolean done);
	
	
	/**
	 * ��ĳһ�Ƶ����ɶ���
	 * @param �Ƶ�IDVO
	 * @param ����VO
	 *
	 */
	public ResultMsg orderCreat(String hotelID,OrderVO vo2);
		
	/**
	 * ���۾Ƶ�	
	 * @param �Ƶ�����VO
	 */
	public void hotelEvaluate(HotelEvaluateVO vo);
	
	/**
	 * ��������ľƵ�ID���û�ID���ط��������ľƵ���ϢVO�б�
	 * @param ɸѡ����VO
	 * @return �Ƶ���ϢVO�б�
	 */
	public HotelInfoVO hotelDetail(String hotelid,String userid);
	
	
	/**
	 * �����������෵���ź���ľƵ��б�
	 * @param before
	 * @param type
	 * @return
	 */
	public ArrayList<HotelInfoVO> sortHotel(ArrayList<HotelInfoVO> before,Sort type);
	
	/**
	 * ���ݾƵ�ID���û�ID���ض����б�
	 * @param hotelid
	 * @param userid
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> getHotelOrder(String hotelid,String userid);	
			
}