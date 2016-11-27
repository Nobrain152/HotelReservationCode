package bl.hotelbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import dataservice.hoteldataservice.RoomInfoDataService;
import po.RoomInfoPO;
import util.ResultMsg;
import util.RoomState;
import vo.RoomInfoVO;

/**
 * 添加客房
 * @author gyf
 *
 */
public class RoomAdd {
	
	private RoomInfoDataService roomData;
	private ResultMsg result;
	
	public RoomAdd(RoomInfoDataService roomDataService){
		this.roomData=roomDataService;
	}
	
	/**
	 * 添加客房
	 * @param roomInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg addRoom(RoomInfoVO roomInfoVO) throws RemoteException{
		RoomInfoPO roomInfoPO = (RoomInfoPO)VOPOchange.VOtoPO(roomInfoVO);
		result = roomData.insert(roomInfoPO);
		return result;
	}
	
	/**
	 * 更新客房信息
	 * @param roomInfoVO
	 * @return
	 * @throws RemoteException
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO) throws RemoteException{
    	RoomInfoPO roomInfoPO = (RoomInfoPO)VOPOchange.VOtoPO(roomInfoVO);
    	if(roomInfoPO.getState()==RoomState.USABLE)
    		result = ResultMsg.SUCCESS;
    	else
    		result = ResultMsg.FAIL;
    	return result;
    }

}
