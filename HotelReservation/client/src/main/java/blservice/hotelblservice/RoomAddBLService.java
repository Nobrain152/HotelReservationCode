package blservice.hotelblservice;

import util.ResultMsg;
import vo.RoomInfoVO;

/**
 * 添加可用客房的接口
 * @author gyf
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
   
}