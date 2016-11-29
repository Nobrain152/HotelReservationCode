package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import bl.hotelbl.HotelInfoCheckController;
import bl.hotelbl.HotelInfoMaintainController;
import bl.hotelbl.RoomAddController;
import bl.orderbl.OrderOnHotel;
import data.userdata.UserManagementDataServiceImpl;
import dataservice.orderdataservice.OrderDataService;
import dataservice.userdataservice.UserManagementDataService;
import po.ContactPO;
import po.StuffInfoPO;
import po.UserInfoPO;
import util.ResultMsg;
import vo.ContactVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;
import vo.StuffInfoVO;
import vo.UserInfoVO;

public class HotelStuff extends User {
	private HotelInfoMaintainController mod;
	private HotelInfoCheckController hotel;
	private OrderOnHotel order;
	private RoomAddController room;
	private OrderDataService orderDataService;
	private UserInfoVO voi;
	private UserManagementDataServiceImpl user;
	private UserManagementDataService userManagementDataService;
	
	public HotelStuff(UserManagementDataService user){
		this.userManagementDataService=user;
		mod=new HotelInfoMaintainController();
		order=new OrderOnHotel(orderDataService);
		room=new RoomAddController();
		hotel=new HotelInfoCheckController();
	}
	
	
	public HotelStuff(String userid){
		user=new UserManagementDataServiceImpl();
		UserInfoPO po2=user.GetUserBaseInfo(userid);
		voi=new UserInfoVO(po2.getUserID(),po2.getUsername(),(ContactVO)VOPOchange.POtoVO(po2.getContact()));
	}
	/**
	 * �鿴�Ƶ���Ϣ	
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���ϢVO
	 */
	public HotelInfoVO HotelInformationInquiry(String hotelid){
		return hotel.checkHotelInfo(hotelid);
	}
			
	/**
	 * �޸ľƵ���Ϣ	
	 * @param �Ƶ�VO
	 * @param �û�IDVO
	 * @return �޸Ľ��
	 */
	public ResultMsg HotelInformationModification(HotelInfoVO vo1,String userid){
		return mod.submitInfo(vo1);
	}
			
	
	/**
	 * ����Ƶ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean HotelStrategeManage(String hotelid,PromotionHotelVO vo){
		return false;
	}
			
	/**
	 * ���¶���״̬	
	 * @param �û�IDVO
	 * @param ����VO
	 * @throws RemoteException 
	 */
	public ResultMsg OrderStateUpdate(String userid,OrderVO vo2) throws RemoteException{
		return order.hotelOrderModify(vo2);
	}
			
	/**
	 * ����Ƶ궩��	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> OrderScan(String hotelid){
		try {
			return order.hotelOrderScan(hotelid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �鿴�Ƶ��������
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���������б�
	 */
	public ArrayList<PromotionHotelVO> HotelPromotionInquire(String hotelid) {
		return null;
	}

	/**
	 * ���·�����Ϣ
	 * @param ������ϢVO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo) {
		return room.updateRoom(vo);
		
	}
	
	/**
	 * �鿴���˻�����Ϣ
	 * @param �û�IDVO
	 * @return �Ƶ������Ա��ϢVO
	 */
	public StuffInfoVO IndividualBaseInfolnquiry(String userid){
		return (StuffInfoVO)voi;
	}
			
	
	/**
	 * �޸ĸ�����Ϣ
	 * @param �û�IDVO
	 * @param �Ƶ������Ա��ϢVO
	 * @return �޸Ľ��
	 */
	public boolean IndividualBaseInfoModification(String userid,StuffInfoVO vo2){
		StuffInfoPO po2=new StuffInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()),vo2.getHotel());
		return user.SetUserBaseInfo(userid,po2);
	}
}
