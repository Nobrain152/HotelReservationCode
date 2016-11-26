package bl.userbl;

import java.util.ArrayList;

import bl.hotelbl.HotelInfoMaintainController;
import bl.hotelbl.RoomAddController;
import bl.orderbl.OrderOnHotelController;
import blservice.userblservice.HotelStuffHotelOperationBlService;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.HotelInfoVO;
import vo.OrderOnHotelVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;
import vo.UserIDVO;



/**
 * 酒店工作人员对酒店进行的操作
 * @author 曹畅
 *
 */
public class HotelStuffHotelOperation implements HotelStuffHotelOperationBlService {

	HotelInfoVO hotel;
	HotelInfoMaintainController mod;
	OrderOnHotelController order;
	RoomAddController room;
	
	public HotelStuffHotelOperation(){
		mod=new HotelInfoMaintainController();
		order=new OrderOnHotelController();
		room=new RoomAddController();
	}
	
	
	/**
	 * 查看酒店信息	
	 * @param 酒店IDVO
	 * @return 酒店信息VO
	 */
	public HotelInfoVO HotelInformationInquiry(HotelInfoVO vo){
		return null;
	}
			
	/**
	 * 修改酒店信息	
	 * @param 酒店VO
	 * @param 用户IDVO
	 * @return 修改结果
	 */
	public ResultMsg HotelInformationModification(HotelInfoVO vo1,UserIDVO vo2){
		return mod.submitInfo(vo1);
	}
			
	
	/**
	 * 管理酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean HotelStrategeManage(HotelInfoVO vo1,PromotionHotelVO vo){
		return false;
	}
			
	/**
	 * 更新订单状态	
	 * @param 用户IDVO
	 * @param 订单VO
	 */
	public ResultMsg OrderStateUpdate(UserIDVO vo1,OrderOnHotelVO vo2){
		return order.hotelOrderModify(vo2);
	}
			
	/**
	 * 浏览酒店订单	
	 * @param 酒店IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderOnHotelVO> OrderScan(HotelInfoVO vo){
		return order.hotelOrderScan();
	}

	/**
	 * 查看酒店促销策略
	 * @param 酒店IDVO
	 * @return 酒店促销策略列表
	 */
	public ArrayList<PromotionHotelVO> HotelPromotionInquire(HotelInfoVO vo) {
		return null;
	}

	/**
	 * 更新房间信息
	 * @param 房间信息VO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo) {
		return room.updateRoom(vo);
		
	}
}
