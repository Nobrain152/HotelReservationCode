package bl.userbl;


import java.rmi.RemoteException;
import java.util.ArrayList;


import blservice.userblservice.HotelStuffHotelOperationBlService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
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
	public HotelInfoVO hotelInfoInq(String hotelid){
		try {
			return stuff.hotelInfoInq(hotelid);
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
	public ResultMsg hotelInfoMod(HotelInfoVO vo1,String userid){
		try {
			return stuff.hotelInfoMod(vo1, userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * �޸ľƵ귿����Ϣ
	 * @param rooms
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg setRoomInfo(ArrayList<RoomInfoVO> rooms){
		try {
			return stuff.setRoomInfo(rooms);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
			
	
	/**
	 * ����Ƶ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean hotelStrategeManage(PromotionHotelVO vo){
		try {
			return stuff.hotelStrategeManage(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * ɾ���Ƶ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean hotelStrategeDelete(PromotionHotelVO vo){
		try {
			return stuff.hotelStrategeDelete(vo);
		} catch (RemoteException e) {
			return false;
		}
	}
			
	/**
	 * ���¶���״̬	
	 * @param �û�IDVO
	 * @param ����VO
	 * @throws RemoteException 
	 */
	public ResultMsg orderStateUpdate(String userid,OrderVO vo2) throws RemoteException{
		return stuff.orderStateUpdate(userid, vo2);
	}
			
	/**
	 * ����Ƶ궩��	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> orderScan(String hotelid){
		try {
			return stuff.orderScan(hotelid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ����Ƶ��쳣����	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> abnormalOrderScan(String hotelid){
		try {
			return stuff.abnormalOrderScan(hotelid);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * �����������
	 * @param hotelid
	 * @param state
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> specialOrderScan(String hotelid,OrderState state){
		try {
			return stuff.specialOrderScan(hotelid, state);
		} catch (RemoteException e) {
			return null;
		}
	}

	/**
	 * �鿴�Ƶ��������
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���������б�
	 */
	public ArrayList<PromotionHotelVO> hotelPromotionInq(PromotionHotelVO promotion) {
		try {
			return stuff.hotelPromotionInq(promotion);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ���·�����Ϣ
	 * @param ������ϢVO
	 */
	public ResultMsg updateRoomState(RoomInfoVO vo) {
		try {
			return stuff.updateRoomState(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	/**
	 * ¼����÷���
	 * @param rooms
	 */
	public ResultMsg typeInRoom(RoomInfoVO room){
		  try {
			return stuff.typeInRoom(room);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}

	
	/**
	 * �鿴�Ƶ����пͷ���Ϣ
	 * @param hotelid
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> hotelRoomList(String hotelid){
		try {
			return stuff.hotelRoomList(hotelid);
		} catch (RemoteException e) {
			return null;
		}
	}
	/**
	 * ���ӾƵ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean hotelStrategeAdd(PromotionHotelVO vo) {
		try {
			return stuff.hotelStrategeAdd(vo);
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
