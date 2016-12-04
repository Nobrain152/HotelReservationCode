package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.HotelStuffHotelOperationBlService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
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
public class HotelStuffHotelOperationController implements HotelStuffHotelOperationBlService {

	private HotelStuff stuff;
	private UserManagementDataService userManagementDataService;
	
	
	public HotelStuffHotelOperationController(){
		userManagementDataService = (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		stuff=new HotelStuff(userManagementDataService);
	}
	
	
	/**
	 * �鿴�Ƶ���Ϣ	
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���ϢVO
	 */
	public HotelInfoVO HotelInformationInquiry(String hotelid){
		try {
			return stuff.HotelInformationInquiry(hotelid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	/**
	 * �޸ľƵ���Ϣ	
	 * @param �Ƶ�VO
	 * @param �û�IDVO
	 * @return �޸Ľ��
	 */
	public ResultMsg HotelInformationModification(HotelInfoVO vo1,String userid){
		try {
			return stuff.HotelInformationModification(vo1, userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	
	/**
	 * ����Ƶ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean HotelStrategeManage(PromotionHotelVO vo){
		try {
			return stuff.HotelStrategeManage(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
			
	/**
	 * ���¶���״̬	
	 * @param �û�IDVO
	 * @param ����VO
	 * @throws RemoteException 
	 */
	public ResultMsg OrderStateUpdate(String userid,OrderVO vo2) throws RemoteException{
		return stuff.OrderStateUpdate(userid, vo2);
	}
			
	/**
	 * ����Ƶ궩��	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> OrderScan(String hotelid){
		try {
			return stuff.OrderScan(hotelid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * �鿴�Ƶ��������
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���������б�
	 */
	public ArrayList<PromotionHotelVO> HotelPromotionInquire(PromotionHotelVO promotion) {
		try {
			return stuff.HotelPromotionInquire(promotion);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ���·�����Ϣ
	 * @param ������ϢVO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo) {
		try {
			return stuff.UpdateRoomState(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	/**
	 * ¼����÷���
	 * @param rooms
	 */
	public ResultMsg TypeInRoom(ArrayList<RoomInfoVO> rooms){
		  try {
			return stuff.TypeInRoom(rooms);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}

	/**
	 * ���ӾƵ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean HotelStrategeAdd(PromotionHotelVO vo) {
		try {
			return stuff.HotelStrategeAdd(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * �Ƶ깤����Ա���Ķ���״̬
	 * @param hotelid
	 * @param orderid
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg setAbnormalOrder(String hotelid,String orderid){
		try {
			return stuff.setAbnormalOrder(hotelid, orderid);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
}
