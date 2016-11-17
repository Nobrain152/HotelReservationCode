package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelInfoPO;

public interface HotelInfoDataService {
	
	/**
	 * ����
	 */
	public boolean insert(HotelInfoPO po) throws RemoteException;
	
	
	/**
	 * ɾ��
	 */
	public boolean delete(HotelInfoPO po) throws RemoteException;
	
	/**
	 * ����
	 */
	public boolean update(HotelInfoPO po) throws RemoteException;
	
	/**
	 * ����
	 */
	public ArrayList<HotelInfoPO> find(HotelInfoPO po) throws RemoteException;

	
	/**
	 * ��ʾ
	 */
	public ArrayList<HotelInfoPO> show() throws RemoteException;




}