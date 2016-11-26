package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelInfoPO;
import util.ResultMsg;

public interface HotelInfoDataService {
	
	/**
	 * 增加
	 */
	public ResultMsg insert(HotelInfoPO po) throws RemoteException;
	
	
	/**
	 * 删除
	 */
	public ResultMsg delete(HotelInfoPO po) throws RemoteException;
	
	/**
	 * 更新
	 */
	public ResultMsg update(HotelInfoPO po) throws RemoteException;
	
	/**
	 * 查找
	 */
	public ArrayList<HotelInfoPO> find(HotelInfoPO po) throws RemoteException;

	
	/**
	 * 显示
	 */
	public ArrayList<HotelInfoPO> show() throws RemoteException;




}