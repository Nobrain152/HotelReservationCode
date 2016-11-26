package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelEvaluatePO;
import util.ResultMsg;

public interface HotelEvaluateDataService {
	
	/**
	 * 增加
	 */
	public ResultMsg insert(HotelEvaluatePO po) throws RemoteException;
	
	
	/**
	 * 删除
	 */
	public ResultMsg delete(HotelEvaluatePO po) throws RemoteException;
	
	
	/**
	 * 查找
	 */
	public ArrayList<HotelEvaluatePO> find(String searchInfo) throws RemoteException;
	
	
	/**
	 * 显示
	 */
	public ArrayList<HotelEvaluatePO>show() throws RemoteException;




}	