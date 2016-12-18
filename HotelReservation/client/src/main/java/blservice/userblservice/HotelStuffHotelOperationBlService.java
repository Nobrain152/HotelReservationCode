package blservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.OrderState;
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
public interface HotelStuffHotelOperationBlService{
		
		
	/**
	 * 查看酒店信息	
	 * @param 酒店IDVO
	 * @return 酒店信息VO
	 */
	public HotelInfoVO HotelInformationInquiry(String hotelid);
		
	/**
	 * 修改酒店信息	
	 * @param 酒店VO
	 * @param 用户IDVO
	 * @return 修改结果
	 */
	public ResultMsg HotelInformationModification(HotelInfoVO vo1,String userid);
	
	/**
	 * 删除酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean HotelStrategeDelete(PromotionHotelVO vo);
	
	/**
	 * 修改酒店房间信息
	 * @param rooms
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg SetRoomInfo(ArrayList<RoomInfoVO> rooms);
	
	/**
	 * 查看酒店促销策略
	 * @param 酒店IDVO
	 * @return 酒店促销策略列表
	 */
	public ArrayList<PromotionHotelVO> HotelPromotionInquire(PromotionHotelVO vo);
	
	/**
	 * 修改酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean HotelStrategeManage(PromotionHotelVO vo); 
	
	/**
	 * 增加酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean HotelStrategeAdd(PromotionHotelVO vo);
		
	/**
	 * 更新订单状态	
	 * @param 用户IDVO
	 * @param 订单VO
	 * @throws RemoteException 
	 */
	public ResultMsg OrderStateUpdate(String userid,OrderVO vo2) throws RemoteException;
		
	/**
	 * 浏览酒店订单	
	 * @param 酒店IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> OrderScan(String hotelid);
	
	/**
	 * 浏览酒店异常订单	
	 * @param 酒店IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> AbnormalOrderScan(String hotelid);
	
	/**
	 * 分类浏览订单
	 * @param hotelid
	 * @param state
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> specialOrderScan(String hotelid,OrderState state);
	
	/**
	 * 更新房间信息
	 * @param 房间信息VO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo);
	
	/**
	 * 录入可用房间
	 * @param rooms
	 */
	public ResultMsg TypeInRoom(ArrayList<RoomInfoVO> rooms);
	
	/**
	 * 酒店工作人员更改订单状态
	 * @param hotelid
	 * @param orderid
	 *
	 */
	public ResultMsg setAbnormalOrder(String hotelid,String orderid);
		
}