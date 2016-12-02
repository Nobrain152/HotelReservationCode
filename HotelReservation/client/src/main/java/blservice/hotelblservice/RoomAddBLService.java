package blservice.hotelblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.RoomInfoVO;

/**
 * 添加可用客房的接口
 * @author 曹畅
 *
 */
public interface RoomAddBLService {
	
	/**
	 * 添加可用客房
	 * @param roomInfoVO
	 * @return
	 */
	public ResultMsg addRoom(RoomInfoVO roomInfoVO);
	
	/**
	 * 更新客房信息
	 * @param roomInfoVO
	 * @return
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO);
    
    /**
	 * 根据酒店ID查看酒店房间列表
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoomInfoVO> HotelRoomSearch(String hotelID);
	
	/**
	 * 修改酒店房间列表
	 * @param hotelid
	 * @param po
	 * @return
	 */
	public ResultMsg HotelRoomMod(String hotelid,ArrayList<RoomInfoVO> po);
   
}