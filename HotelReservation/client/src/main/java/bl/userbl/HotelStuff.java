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
 * 酒店管理人员类
 * @author 曹畅
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
	 * 查看酒店信息	
	 * @param 酒店IDVO
	 * @return 酒店信息VO
	 */
	public HotelInfoVO HotelInformationInquiry(String hotelid)throws RemoteException{
		return hotel.checkHotelInfo(hotelid);
	}
			
	/**
	 * 修改酒店信息	
	 * @param 酒店VO
	 * @param 用户IDVO
	 * @return 修改结果
	 */
	public ResultMsg HotelInformationModification(HotelInfoVO vo1,String userid)throws RemoteException{
		return mod.submitInfo(vo1);
	}
			
	
	/**
	 * 修改酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
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
	 * 增加酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
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
	 * 更新订单状态	
	 * @param 用户IDVO
	 * @param 订单VO
	 * @throws RemoteException 
	 */
	public ResultMsg OrderStateUpdate(String userid,OrderVO vo2) throws RemoteException{
		return order.hotelOrderModify(vo2);
	}
			
	/**
	 * 浏览酒店订单	
	 * @param 酒店IDVO
	 * @return 订单VO列表
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
	 * 查看酒店促销策略
	 * @param 酒店IDVO
	 * @return 酒店促销策略列表
	 */
	public ArrayList<PromotionHotelVO> HotelPromotionInquire(PromotionHotelVO vo)throws RemoteException {
		return promotion.getHotelPromotion(vo.getType(),vo.getHotelID());
	}

	/**
	 * 更新房间信息
	 * @param 房间信息VO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo)throws RemoteException {
		return room.updateRoom(vo);
		
	}
	
	/**
	 * 查看个人基本信息
	 * @param 用户IDVO
	 * @return 酒店管理人员信息VO
	 */
	public StuffInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		UserInfoPO userInfoPO = userDataService.GetUserBaseInfo(userid);
		userInfoVO = (UserInfoVO)VOPOchange.POtoVO(userInfoPO);
		return (StuffInfoVO) userInfoVO;
	}
			
	
	/**
	 * 修改个人信息
	 * @param 用户IDVO
	 * @param 酒店管理人员信息VO
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(String userid,StuffInfoVO vo2)throws RemoteException{
		StuffInfoPO po2=new StuffInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()),vo2.getHotel());
		return userDataService.SetUserBaseInfo(userid,po2);
	}
}
