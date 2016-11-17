package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelInfoPO;

public interface HotelInfoDataService {
	
	/**
	 * 增加
	 */
	public boolean insert(HotelInfoPO po) throws RemoteException;
	
	
	/**
	 * 删除
	 */
	public boolean delete(HotelInfoPO po) throws RemoteException;
	
	/**
	 * 更新
	 */
	public boolean update(HotelInfoPO po) throws RemoteException;
	
	/**
	 * 查找
	 */
	public ArrayList<HotelInfoPO> find(HotelInfoPO po) throws RemoteException;

	
	/**
	 * 显示
	 */
	public ArrayList<HotelInfoPO> show() throws RemoteException;




}