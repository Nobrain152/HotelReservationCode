package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomInfoPO;

public interface RoomInfoDataService {
	
	/**
	 * 增加
	 */
	public boolean insert(RoomInfoPO po) throws RemoteException;
	
	
	/**
	 * 删除
	 */
	public boolean delete(RoomInfoPO po) throws RemoteException;
	
	/**
	 * 更新
	 */
	public boolean update(RoomInfoPO po) throws RemoteException;
	
	/**
	 * 查找
	 */
	public ArrayList<RoomInfoPO> find(RoomInfoPO po) throws RemoteException;
	
	
	/**
	 * 显示
	 */
	public ArrayList<RoomInfoPO> show() throws RemoteException;




}