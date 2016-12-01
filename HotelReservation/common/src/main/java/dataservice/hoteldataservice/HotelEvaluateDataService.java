package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelEvaluatePO;
import util.ResultMsg;

public interface HotelEvaluateDataService {

	/**
	 * 增加
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg insert(HotelEvaluatePO po) throws RemoteException;
	
	/**
	 * 删除
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg delete(HotelEvaluatePO po) throws RemoteException;
	
	/**
	 * 查找
	 * @param searchInfo
	 * @return ArrayList<HotelEvaluatePO>
	 * @throws RemoteException
	 */
	public ArrayList<HotelEvaluatePO> find(String searchInfo) throws RemoteException;
	
	/**
	 * 根据订单ID查找
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public HotelEvaluatePO findByID(String ID) throws RemoteException;
	
	/**
	 * 显示
	 * @return ArrayList<HotelEvaluatePO>
	 * @throws RemoteException
	 */
	public ArrayList<HotelEvaluatePO> show(String hotelid) throws RemoteException;




}	