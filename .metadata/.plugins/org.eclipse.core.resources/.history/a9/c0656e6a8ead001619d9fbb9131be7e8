package data.hoteldata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomInfoPO;

public class RoomInfoDataServiceImpl {
	ArrayList<RoomInfoPO> roomPOs;
	
	public RoomInfoDataServiceImpl(){
		roomPOs = new ArrayList<>();
	}
	
	/**
	 * 增加
	 */
	public boolean insert(RoomInfoPO po) throws RemoteException{
		if(roomPOs.add(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * 删除
	 */
	public boolean delete(RoomInfoPO po) throws RemoteException{
		if(roomPOs.remove(po))
			return true;
		else
			return false;
	}
	
	/**
	 * 更新
	 */
	public boolean update(RoomInfoPO po) throws RemoteException{
		for (RoomInfoPO op : roomPOs) {
			
				op = po;
				return true;
			
		}
		return false;
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



}