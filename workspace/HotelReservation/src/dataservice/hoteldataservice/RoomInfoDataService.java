package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomInfoPO;

public interface RoomInfoDataService {
	
	/**
	 * ����
	 */
	public boolean insert(RoomInfoPO po) throws RemoteException;
	
	
	/**
	 * ɾ��
	 */
	public boolean delete(RoomInfoPO po) throws RemoteException;
	
	/**
	 * ����
	 */
	public boolean update(RoomInfoPO po) throws RemoteException;
	
	/**
	 * ����
	 */
	public ArrayList<RoomInfoPO> find(RoomInfoPO po) throws RemoteException;
	
	
	/**
	 * ��ʾ
	 */
	public ArrayList<RoomInfoPO> show() throws RemoteException;




}