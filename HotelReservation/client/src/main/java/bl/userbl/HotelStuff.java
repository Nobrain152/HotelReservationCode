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
	 * 查看酒店信息	
	 * @param 酒店IDVO
	 * @return 酒店信息VO
	 */
	public HotelInfoVO HotelInformationInquiry(String hotelid){
		return hotel.checkHotelInfo(hotelid);
	}
			
	/**
	 * 修改酒店信息	
	 * @param 酒店VO
	 * @param 用户IDVO
	 * @return 修改结果
	 */
	public ResultMsg HotelInformationModification(HotelInfoVO vo1,String userid){
		return mod.submitInfo(vo1);
	}
			
	
	/**
	 * 管理酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean HotelStrategeManage(String hotelid,PromotionHotelVO vo){
		return false;
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
	 * 查看酒店促销策略
	 * @param 酒店IDVO
	 * @return 酒店促销策略列表
	 */
	public ArrayList<PromotionHotelVO> HotelPromotionInquire(String hotelid) {
		return null;
	}

	/**
	 * 更新房间信息
	 * @param 房间信息VO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo) {
		return room.updateRoom(vo);
		
	}
	
	/**
	 * 查看个人基本信息
	 * @param 用户IDVO
	 * @return 酒店管理人员信息VO
	 */
	public StuffInfoVO IndividualBaseInfolnquiry(String userid){
		return (StuffInfoVO)voi;
	}
			
	
	/**
	 * 修改个人信息
	 * @param 用户IDVO
	 * @param 酒店管理人员信息VO
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(String userid,StuffInfoVO vo2){
		StuffInfoPO po2=new StuffInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()),vo2.getHotel());
		return user.SetUserBaseInfo(userid,po2);
	}
}
