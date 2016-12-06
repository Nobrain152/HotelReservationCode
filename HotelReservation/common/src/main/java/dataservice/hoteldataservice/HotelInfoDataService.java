package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelInfoPO;
import util.ResultMsg;

public interface HotelInfoDataService {
	
	/**
	 * ����
	 */
	public ResultMsg insert(HotelInfoPO po) throws RemoteException;
	
	
	/**
	 * ɾ��
	 */
	public ResultMsg delete(HotelInfoPO po) throws RemoteException;
	
	/**
	 * ����
	 */
	public ResultMsg update(HotelInfoPO po) throws RemoteException;
	
	/**
	 * ����
	 */
	public HotelInfoPO find(String ID) throws RemoteException;

	/**
	 * ���ݶ���ID����
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public HotelInfoPO findByOrderID(String ID) throws RemoteException;
	
	/**
	 * ��ʾ
	 */
	public ArrayList<HotelInfoPO> show() throws RemoteException;




}