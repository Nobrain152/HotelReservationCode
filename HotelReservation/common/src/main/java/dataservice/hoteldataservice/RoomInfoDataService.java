package dataservice.hoteldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomInfoPO;
import util.ResultMsg;

public interface RoomInfoDataService extends Remote{
	
	/**
	 * ����
	 */
	public ResultMsg insert(RoomInfoPO po) throws RemoteException;
		
	/**
	 * ɾ��
	 */
	public ResultMsg delete(RoomInfoPO po) throws RemoteException;
	
	/**
	 * ����
	 */
	public ResultMsg update(RoomInfoPO po) throws RemoteException;
	
	/**
	 * ����
	 */
	public RoomInfoPO findByRoomID(String id) throws RemoteException;
	
	
	/**
	 * ��ʾ
	 */
	public ArrayList<RoomInfoPO> show() throws RemoteException;
	
	/**
	 * ���ݾƵ�ID�鿴�Ƶ귿���б�
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<RoomInfoPO> HotelRoomSearch(String hotelID) throws RemoteException;
	
	



}