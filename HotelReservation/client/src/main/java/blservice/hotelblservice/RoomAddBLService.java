package blservice.hotelblservice;

import util.ResultMsg;
import util.RoomMsg;
import vo.RoomInfoVO;

public interface RoomAddBLService {
	
	/**
	 * 添加可用客房
	 *
	 */
	public RoomMsg addRoom(RoomInfoVO roomInfoVO);
	
	/**
	 * 更新客房信息
	 * 
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO);
   
}