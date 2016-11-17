package bl.hotelbl;

import java.util.ArrayList;

import util.ResultMsg;
import util.RoomMsg;
import util.RoomState;
import vo.RoomInfoVO;

public class RoomAddController {
	public ArrayList<RoomInfoVO> roomList;
	
	public RoomAddController() {
		roomList = new ArrayList<RoomInfoVO>();
	}
	
	/**
	 * 添加可用客房
	 *
	 */
	public RoomMsg addRoom(RoomInfoVO roomInfoVO){
		return new RoomMsg(roomInfoVO.getState(),roomInfoVO.getType(),roomInfoVO.getNumber(),
				roomInfoVO.getPrice());
	}
	
	/**
	 * 更新客房信息
	 * 
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO){
    	if(roomInfoVO.getState()==RoomState.USABLE){
    		return new ResultMsg(true,"添加成功");
    	}
    	else{
    		return new ResultMsg(false,"添加失败");
    	}
    	
    }
	
}