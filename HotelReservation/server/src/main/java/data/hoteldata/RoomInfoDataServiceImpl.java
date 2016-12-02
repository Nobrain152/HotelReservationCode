package data.hoteldata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.RoomInfoDataService;
import po.RoomInfoPO;
import util.ResultMsg;

public class RoomInfoDataServiceImpl implements RoomInfoDataService{
	ArrayList<RoomInfoPO> roomPOs;
	
	public RoomInfoDataServiceImpl(){
		roomPOs = new ArrayList<RoomInfoPO>();
	}
	
	/**
	 * 增加
	 */
	public ResultMsg insert(RoomInfoPO po) throws RemoteException{
		if(roomPOs.add(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	
	/**
	 * 删除
	 */
	public ResultMsg delete(RoomInfoPO po) throws RemoteException{
		if(roomPOs.remove(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	/**
	 * 更新
	 */
	public ResultMsg update(RoomInfoPO po) throws RemoteException{
		for (RoomInfoPO op : roomPOs) {
			po = op;
			return ResultMsg.SUCCESS;
		}
		return ResultMsg.FAIL;
	}
	
	/**
	 * 查找
	 */
	public ArrayList<RoomInfoPO> find(RoomInfoPO po) throws RemoteException{
		ArrayList<RoomInfoPO> arrayList = new ArrayList<RoomInfoPO>();
		for (RoomInfoPO op : roomPOs) {
			
				arrayList.add(op);
			
		}
		return arrayList;
	}
	
	
	/**
	 * 显示
	 */
	public ArrayList<RoomInfoPO> show() throws RemoteException{
		return roomPOs;
	}

	
	public ArrayList<RoomInfoPO> HotelRoomSearch(String hotelID){
		return null;
	}
	
	
	public ResultMsg HotelRoomMod(String hotelid,ArrayList<RoomInfoPO> po){
		return null;
	}


}