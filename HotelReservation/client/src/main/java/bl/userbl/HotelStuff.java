package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.hotelbl.HotelInfoCheckController;
import bl.hotelbl.HotelInfoMaintainController;
import bl.hotelbl.RoomAddController;
import bl.orderbl.OrderOnHotelController;
import bl.promotionbl.PromotionHotelController;
import dataservice.userdataservice.UserManagementDataService;
import po.StuffInfoPO;
import util.OrderState;
import util.PromotionHotelType;
import util.ResultMsg;
import util.UserType;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;
import vo.StuffInfoVO;



/**
 * �Ƶ������Ա��
 * @author �ܳ�
 *
 */
public class HotelStuff extends User {
	private HotelInfoMaintainController mod;
	private HotelInfoCheckController hotel;
	private OrderOnHotelController order;
	private RoomAddController room;
	private StuffInfoVO userInfoVO;
	private UserManagementDataService userDataService;
	private PromotionHotelController promotion;
	private BusinessLogicDataFactory factory=BusinessLogicDataFactory.getFactory();;
	
	
	public HotelStuff(UserManagementDataService user){
		super(user);
		this.userDataService=user;
	}
	
	
	/**
	 * �鿴�Ƶ���Ϣ	
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���ϢVO
	 */
	public HotelInfoVO HotelInformationInquiry(String hotelid)throws RemoteException{
		hotel=(HotelInfoCheckController)factory.getHotelInfoCheckBLService();
		return hotel.checkHotelInfo(hotelid);
	}
			
	/**
	 * �޸ľƵ���Ϣ	
	 * @param �Ƶ�VO
	 * @param �û�IDVO
	 * @return �޸Ľ��
	 */
	public ResultMsg HotelInformationModification(HotelInfoVO vo1,String userid)throws RemoteException{
		if(userid.charAt(0)=='2'){
			mod=(HotelInfoMaintainController)factory.getHotelInfoMaintainBLService();
			return mod.inputHotelInfo(vo1);
		}
		return ResultMsg.UNAUYHORIZED;
	}
			
	
	/**
	 * �޸ľƵ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean HotelStrategeManage(PromotionHotelVO vo)throws RemoteException{
		PromotionHotelType type=vo.getType();
		ResultMsg msg=null;
		promotion=(PromotionHotelController)factory.getPromotionHotelBLService();
		if(type==PromotionHotelType.BIRTH_PROMOTION){
			msg=promotion.changeBirthCut(vo.getLevel(),vo.getRatio(),vo.getHotelID());
		}
		else if(type==PromotionHotelType.OVERTHREE_PROMOTION){
			msg=promotion.changeOverCut(vo.getNumber(),vo.getRatio(),vo.getHotelID());
		}
		else if(type==PromotionHotelType.JOIN_PROMOTION){
			msg=promotion.changeJoin(vo.getBusinessName(),vo.getRatio(),vo.getHotelID());
		}
		else{
			promotion.changeHotelCustomCut(vo.getTimeBegin(),vo.getTimeOver(),vo.getRatio(),vo.getHotelID());
		}
		
		if(msg==ResultMsg.SUCCESS){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * ���ӾƵ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean HotelStrategeAdd(PromotionHotelVO vo)throws RemoteException{
		PromotionHotelType type=vo.getType();
		ResultMsg msg=null;
		promotion=(PromotionHotelController)factory.getPromotionHotelBLService();
		if(type==PromotionHotelType.BIRTH_PROMOTION){
			msg=promotion.addBirthCut(vo.getLevel(),vo.getRatio(),vo.getHotelID());
		}
		else if(type==PromotionHotelType.OVERTHREE_PROMOTION){
			msg=promotion.addOverCut(vo.getNumber(),vo.getRatio(),vo.getHotelID());
		}
		else if(type==PromotionHotelType.JOIN_PROMOTION){
			msg=promotion.addJoin(vo.getBusinessName(),vo.getRatio(),vo.getHotelID());
		}
		else{
			promotion.addHotelCustomCut(vo.getTimeBegin(),vo.getTimeOver(),vo.getRatio(),vo.getHotelID());
		}
		
		if(msg==ResultMsg.SUCCESS){
			return true;
		}
		else{
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
		if(userid.charAt(0)=='2'){
			order=(OrderOnHotelController)factory.getOrderOnHotelBLService();
			return order.hotelOrderModify(vo2);
		}
		return ResultMsg.FAIL;
	}
			
	/**
	 * ����Ƶ궩��	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> OrderScan(String hotelid)throws RemoteException{
		order=(OrderOnHotelController)factory.getOrderOnHotelBLService();
		return order.hotelOrderScan(hotelid);
	}
	
	
	/**
	 * �����������
	 * @param hotelid
	 * @param state
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> specialOrderScan(String hotelid,OrderState state)throws RemoteException{
		ArrayList<OrderVO> all=OrderScan(hotelid);
		ArrayList<OrderVO> res=new ArrayList<OrderVO>();
		for(int i=0;i<all.size();i++){
			if(all.get(i).orderState==state){
				res.add(all.get(i));
			}
		}
		return res;
	}
	
	/**
	 * ����Ƶ��쳣����	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> AbnormalOrderScan(String hotelid)throws RemoteException{
		order=(OrderOnHotelController)factory.getOrderOnHotelBLService();
		ArrayList<OrderVO> all = order.hotelOrderScan(hotelid);
		ArrayList<OrderVO> res=new ArrayList<OrderVO>();
		for(OrderVO vo:all){
			if(vo.getOrderState()==OrderState.ABNORMAL){
				res.add(vo);
			}
		}
		return res;
	}
	
	/**
	 * �Ƶ깤����Ա���Ķ���״̬
	 * @param hotelid
	 * @param orderid
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg setAbnormalOrder(String hotelid,String orderid)throws RemoteException{
		ArrayList<OrderVO> all=AbnormalOrderScan(hotelid);
		for(OrderVO vo:all){
			if(vo.getOrderID().equals(orderid)){
				order=(OrderOnHotelController)factory.getOrderOnHotelBLService();
				return order.hotelOrderModify(vo);
			}
		}
		return ResultMsg.FAIL;
	}

	/**
	 * �鿴�Ƶ��������
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���������б�
	 */
	public ArrayList<PromotionHotelVO> HotelPromotionInquire(PromotionHotelVO vo)throws RemoteException {
		promotion=(PromotionHotelController)factory.getPromotionHotelBLService();
		return promotion.getHotelPromotion(vo.getType(),vo.getHotelID());
	}

	/**
	 * ���·�����Ϣ
	 * @param ������ϢVO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo)throws RemoteException {
		room=(RoomAddController)factory.getRoomAddBLService();
		return room.updateRoom(vo);
		
	}
	
	/**
	 * ¼����÷���
	 * @param rooms
	 */
	public ResultMsg TypeInRoom(RoomInfoVO roo)throws RemoteException{
		room=(RoomAddController)factory.getRoomAddBLService();
		return room.addRoom(roo);
	}
	
	
	/**
	 * �鿴�Ƶ����пͷ���Ϣ
	 * @param hotelid
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> HotelRoomList(String hotelid)throws RemoteException{
		room=(RoomAddController)factory.getRoomAddBLService();
		return room.HotelRoomSearch(hotelid);
	}
	
	/**
	 * �޸ľƵ귿����Ϣ
	 * @param rooms
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg SetRoomInfo(ArrayList<RoomInfoVO> rooms)throws RemoteException{
		room=(RoomAddController)factory.getRoomAddBLService();
		return room.HotelRoomMod(rooms.get(0).getHotelid(), rooms);
	}
	
	/**
	 * �鿴���˻�����Ϣ
	 * @param �û�IDVO
	 * @return �Ƶ������Ա��ϢVO
	 */
	public StuffInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		StuffInfoPO userInfoPO = userDataService.GetHotelStuffInfo(userid);
		userInfoVO = (StuffInfoVO)VOPOchange.POtoVO(userInfoPO);
		return  userInfoVO;
	}
			
	
	/**
	 * �޸ĸ�����Ϣ
	 * @param �û�IDVO
	 * @param �Ƶ������Ա��ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,StuffInfoVO vo2)throws RemoteException{
		StuffInfoPO past= userDataService.GetHotelStuffInfo(userid);
		past.setType(UserType.HotelStuff);
		if(vo2.getContact()!=null){
			if(vo2.getContact().length()!=11){
				return ResultMsg.WRONG_PHONENUMBER;
			}
			past.setContact(vo2.getContact());
		}
		if(vo2.getUsername()!=null){
			past.setUsername(vo2.getUsername());
		}
		return userDataService.SetHotelStuffInfo(userid, past);
		
	}
	
	/**
	 * ɾ���Ƶ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean HotelStrategeDelete(PromotionHotelVO vo)throws RemoteException{
		PromotionHotelType type=vo.getType();
		ResultMsg msg=null;
		promotion=(PromotionHotelController)factory.getPromotionHotelBLService();
		if(type==PromotionHotelType.BIRTH_PROMOTION){
			msg=promotion.deleteBirthCut(vo.getLevel(),vo.getHotelID());
		}
		else if(type==PromotionHotelType.OVERTHREE_PROMOTION){
			msg=promotion.deleteOverCut(vo.getNumber(),vo.getHotelID());
		}
		else if(type==PromotionHotelType.JOIN_PROMOTION){
			msg=promotion.deleteJoin(vo.getBusinessName(),vo.getHotelID());
		}
		else{
			promotion.deleteHotelCustomCut(vo.getTimeBegin(),vo.getTimeOver(),vo.getHotelID());
		}
		
		if(msg==ResultMsg.SUCCESS){
			return true;
		}
		else{
			return false;
		}
	}
	
}
