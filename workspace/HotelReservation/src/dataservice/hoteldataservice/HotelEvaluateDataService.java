package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelEvaluatePO;

public interface HotelEvaluateDataService {
	
	/**
	 * 增加
	 */
	public boolean insert(HotelEvaluatePO po) throws RemoteException;
	
	
	/**
	 * 删除
	 */
	public boolean delete(HotelEvaluatePO po) throws RemoteException;
	
	
	/**
	 * 查找
	 */
	public ArrayList<HotelEvaluatePO> find(String searchInfo) throws RemoteException;
	
	
	/**
	 * 显示
	 */
	public ArrayList<HotelEvaluatePO>show() throws RemoteException;




}	