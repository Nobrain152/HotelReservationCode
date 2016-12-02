package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.hotelblservice.RoomAddBLService;
import dataservice.hoteldataservice.RoomInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.RoomInfoVO;

/**
 * 
 * @author �ܳ�
 *
 */
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
	
	
	@Override
	public ResultMsg addRoom(RoomInfoVO roomInfoVO){
		try {
			return roomAdd.addRoom(roomInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO){
		try {
			return roomAdd.updateRoom(roomInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }
	
	/**
	 * ���ݾƵ�ID�鿴�Ƶ귿���б�
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoomInfoVO> HotelRoomSearch(String hotelID){
		try {
			return roomAdd.HotelRoomSearch(hotelID);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * �޸ľƵ귿���б�
	 * @param hotelid
	 * @param po
	 * @return
	 */
	public ResultMsg HotelRoomMod(String hotelid,ArrayList<RoomInfoVO> vo){
		try {
			return roomAdd.HotelRoomMod(hotelid, vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
	
}