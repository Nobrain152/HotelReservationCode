package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.HotelStuffHotelOperationBlService;
import dataservice.userdataservice.CustomerManagementDataService;
import dataservice.userdataservice.UserManagementDataService;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;



/**
 * 酒店工作人员对酒店进行的操作
 * @author 曹畅
 *
 */
public class HotelStuffHotelOperationController implements HotelStuffHotelOperationBlService {

	private HotelStuff stuff;
	private UserManagementDataService userManagementDataService;
	
	
	public HotelStuffHotelOperationController(){
		stuff=new HotelStuff(userManagementDataService);
	}
	
	
	/**
	 * 查看酒店信息	
	 * @param 酒店IDVO
	 * @return 酒店信息VO
	 */
	public HotelInfoVO HotelInformationInquiry(String hotelid){
		return stuff.HotelInformationInquiry(hotelid);
	}
			
	/**
	 * 修改酒店信息	
	 * @param 酒店VO
	 * @param 用户IDVO
	 * @return 修改结果
	 */
	public ResultMsg HotelInformationModification(HotelInfoVO vo1,String userid){
		return stuff.HotelInformationModification(vo1, userid);
	}
			
	
	/**
	 * 管理酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean HotelStrategeManage(String hotelid,PromotionHotelVO vo){
		return stuff.HotelStrategeManage(hotelid, vo);
	}
			
	/**
	 * 更新订单状态	
	 * @param 用户IDVO
	 * @param 订单VO
	 * @throws RemoteException 
	 */
	public ResultMsg OrderStateUpdate(String userid,OrderVO vo2) throws RemoteException{
		return stuff.OrderStateUpdate(userid, vo2);
	}
			
	/**
	 * 浏览酒店订单	
	 * @param 酒店IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> OrderScan(String hotelid){
		return stuff.OrderScan(hotelid);
	}

	/**
	 * 查看酒店促销策略
	 * @param 酒店IDVO
	 * @return 酒店促销策略列表
	 */
	public ArrayList<PromotionHotelVO> HotelPromotionInquire(String hotelid) {
		return stuff.HotelPromotionInquire(hotelid);
	}

	/**
	 * 更新房间信息
	 * @param 房间信息VO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo) {
		return stuff.UpdateRoomState(vo);
		
	}
}
