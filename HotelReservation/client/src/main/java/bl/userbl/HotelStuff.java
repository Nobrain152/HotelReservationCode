package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import bl.hotelbl.HotelInfoCheckController;
import bl.hotelbl.HotelInfoMaintainController;
import bl.hotelbl.RoomAddController;
import bl.orderbl.OrderOnHotel;
import bl.promotionbl.PromotionHotelController;
import dataservice.orderdataservice.OrderDataService;
import dataservice.userdataservice.UserManagementDataService;
import po.ContactPO;
import po.StuffInfoPO;
import po.UserInfoPO;
import util.PromotionHotelType;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;
import vo.StuffInfoVO;
import vo.UserInfoVO;


/**
 * �Ƶ������Ա��
 * @author �ܳ�
 *
 */
public class HotelStuff extends User {
	private HotelInfoMaintainController mod;
	private HotelInfoCheckController hotel;
	private OrderOnHotel order;
	private RoomAddController room;
	private OrderDataService orderDataService;
	private UserInfoVO userInfoVO;
	private UserManagementDataService userDataService;
	private PromotionHotelController promotion;
	
	
	public HotelStuff(UserManagementDataService user){
		super(user);
		this.userDataService=user;
		mod=new HotelInfoMaintainController();
		order=new OrderOnHotel(orderDataService);
		room=new RoomAddController();
		hotel=new HotelInfoCheckController();
		promotion=new PromotionHotelController();
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
		return mod.submitInfo(vo1);
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
		return order.hotelOrderModify(vo2);
	}
			
	/**
	 * ����Ƶ궩��	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> OrderScan(String hotelid)throws RemoteException{
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
	 * �鿴���˻�����Ϣ
	 * @param �û�IDVO
	 * @return �Ƶ������Ա��ϢVO
	 */
	public StuffInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		UserInfoPO userInfoPO = userDataService.GetUserBaseInfo(userid);
		userInfoVO = (UserInfoVO)VOPOchange.POtoVO(userInfoPO);
		return (StuffInfoVO) userInfoVO;
	}
			
	
	/**
	 * �޸ĸ�����Ϣ
	 * @param �û�IDVO
	 * @param �Ƶ������Ա��ϢVO
	 * @return �޸Ľ��
	 */
	public boolean IndividualBaseInfoModification(String userid,StuffInfoVO vo2)throws RemoteException{
		StuffInfoPO po2=new StuffInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()),vo2.getHotel());
		return userDataService.SetUserBaseInfo(userid,po2);
	}
}
