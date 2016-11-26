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
	 * ���¿ͷ���Ϣ
	 * 
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO) throws RemoteException{
    	if(roomInfoVO.getState()==RoomState.USABLE){
    		//result= new ResultMsg(true,"��ӳɹ�");
    		result = ResultMsg.SUCCESS;
    	}
    	else{
    		//result= new ResultMsg(false,"���ʧ��");
    		result = ResultMsg.FAIL;
    	}
    	return result;
    }

}
