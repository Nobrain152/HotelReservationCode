package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomInfoPO;
import util.ResultMsg;

public interface RoomInfoDataService {
	
	/**
	 * 增加
	 */
	public ResultMsg insert(RoomInfoPO po) throws RemoteException;
		
	/**
	 * 删除
	 */
	public ResultMsg delete(RoomInfoPO po) throws RemoteException;
	
	/**
	 * 更新
	 */
	public ResultMsg update(RoomInfoPO po) throws RemoteException;
	
	/**
	 * 查找
	 */
	public ArrayList<RoomInfoPO> find(RoomInfoPO po) throws RemoteException;
	
	
	/**
	 * 显示
	 */
	public ArrayList<RoomInfoPO> show() throws RemoteException;
	
	/**
	 * 根据酒店ID查看酒店房间列表
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoomInfoPO> HotelRoomSearch(String hotelID);
	
	/**
	 * 修改酒店房间列表
	 * @param hotelid
	 * @param po
	 * @return
	 */
	public ResultMsg HotelRoomMod(String hotelid,ArrayList<RoomInfoPO> po);




}