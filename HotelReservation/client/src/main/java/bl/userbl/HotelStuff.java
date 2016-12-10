package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import blservice.hotelblservice.HotelInfoCheckBLService;
import blservice.hotelblservice.HotelInfoMaintainBLService;
import blservice.hotelblservice.RoomAddBLService;
import blservice.orderblservice.OrderOnHotelBLService;
import blservice.promotionservice.PromotionHotelBLService;
import dataservice.userdataservice.UserManagementDataService;
import po.StuffInfoPO;
import util.OrderState;
import util.PromotionHotelType;
import util.ResultMsg;
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
	private HotelInfoMaintainBLService mod;
	private HotelInfoCheckBLService hotel;
	private OrderOnHotelBLService order;
	private RoomAddBLService room;
	private StuffInfoVO userInfoVO;
	private UserManagementDataService userDataService;
	private PromotionHotelBLService promotion;
	private BusinessLogicDataFactory factory;
	
	
	public HotelStuff(UserManagementDataService user){
		super(user);
		factory=BusinessLogicDataFactory.getFactory();
		this.userDataService=user;
		mod=factory.getHotelInfoMaintainBLService();
		order=factory.getOrderOnHotelBLService();
		room=factory.getRoomAddBLService();
		hotel=factory.getHotelInfoCheckBLService();
		promotion=factory.getPromotionHotelBLService();
	}
	
	
	/**
	 * �鿴�Ƶ���Ϣ	
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���ϢVO
	 */
	public HotelInfoVO HotelInformationInquiry(String hotelid)throws RemoteException{
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
		return order.hotelOrderScan(hotelid);
	}
	
	/**
	 * ����Ƶ��쳣����	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> AbnormalOrderScan(String hotelid)throws RemoteException{
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
		return promotion.getHotelPromotion(vo.getType(),vo.getHotelID());
	}

	/**
	 * ���·�����Ϣ
	 * @param ������ϢVO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo)throws RemoteException {
		return room.updateRoom(vo);
		
	}
	
	/**
	 * ¼����÷���
	 * @param rooms
	 */
	public ResultMsg TypeInRoom(ArrayList<RoomInfoVO> rooms)throws RemoteException{
		for(RoomInfoVO v:rooms){
			ResultMsg resultMsg=room.addRoom(v);
			if(resultMsg==ResultMsg.FAIL){
				return ResultMsg.FAIL;
			}
		}
		return ResultMsg.SUCCESS;
	}
	
	/**
	 * �޸ľƵ귿����Ϣ
	 * @param rooms
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg SetRoomInfo(ArrayList<RoomInfoVO> rooms)throws RemoteException{
		return room.HotelRoomMod(rooms.get(0).getHotelid(), rooms);
	}
	
	/**
	 * �鿴���˻�����Ϣ
	 * @param �û�IDVO
	 * @return �Ƶ������Ա��ϢVO
	 */
	public StuffInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		StuffInfoPO userInfoPO = userDataService.FindStuffInfo(userid);
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
		StuffInfoPO po2=(StuffInfoPO)VOPOchange.VOtoPO(vo2);
		boolean result= userDataService.ModStuffInfo(userid,po2);
		if(result){
			return ResultMsg.SUCCESS;
		}
		return ResultMsg.FAIL;
	}
}
