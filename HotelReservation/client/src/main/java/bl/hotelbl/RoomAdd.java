package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelEvaluateDataService;
import dataservice.hoteldataservice.RoomInfoDataService;
import util.ResultMsg;
import util.RoomMsg;
import util.RoomState;
import vo.RoomInfoVO;

public class RoomAdd {
	private RoomInfoDataService roomData;
	private RoomMsg room;
	private ResultMsg result;
	
	public RoomAdd(RoomInfoDataService roomDataService){
		this.roomData=roomDataService;
	}
	
	
	public RoomMsg addRoom(RoomInfoVO roomInfoVO) throws RemoteException{
		room= new RoomMsg(roomInfoVO.getState(),roomInfoVO.getType(),roomInfoVO.getNumber(),
				roomInfoVO.getPrice());
		return room;
	}
	
	/**
	 * 更新客房信息
	 * 
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO) throws RemoteException{
    	if(roomInfoVO.getState()==RoomState.USABLE){
    		//result= new ResultMsg(true,"添加成功");
    		result = ResultMsg.SUCCESS;
    	}
    	else{
    		//result= new ResultMsg(false,"添加失败");
    		result = ResultMsg.FAIL;
    	}
    	return result;
    }

}
