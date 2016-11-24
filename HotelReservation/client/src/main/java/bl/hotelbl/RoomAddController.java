package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.hotelblservice.RoomAddBLService;
import dataservice.hoteldataservice.RoomInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import util.RoomMsg;
import util.RoomState;
import vo.RoomInfoVO;

public class RoomAddController implements RoomAddBLService{
	public ArrayList<RoomInfoVO> roomList;
	private RoomAdd roomAdd;
	private RoomInfoDataService roomInfoData;
	
	public RoomAddController() {
		roomList = new ArrayList<RoomInfoVO>();
		roomInfoData = (RoomInfoDataService) RMIManage
				.getDataService(DataServiceType.RoomInfoDataService);
		roomAdd = new RoomAdd(roomInfoData);
	}
	
	/**
	 * 添加可用客房
	 *
	 */
	@Override
	public RoomMsg addRoom(RoomInfoVO roomInfoVO){
		try {
			return roomAdd.addRoom(roomInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 更新客房信息
	 * 
	 */
	@Override
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO){
		try {
			return roomAdd.updateRoom(roomInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }
	
}