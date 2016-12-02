package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomInfoPO;
import util.ResultMsg;

public interface RoomInfoDataService {
	
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
	public ArrayList<RoomInfoPO> find(RoomInfoPO po) throws RemoteException;
	
	
	/**
	 * ��ʾ
	 */
	public ArrayList<RoomInfoPO> show() throws RemoteException;
	
	/**
	 * ���ݾƵ�ID�鿴�Ƶ귿���б�
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoomInfoPO> HotelRoomSearch(String hotelID);
	
	/**
	 * �޸ľƵ귿���б�
	 * @param hotelid
	 * @param po
	 * @return
	 */
	public ResultMsg HotelRoomMod(String hotelid,ArrayList<RoomInfoPO> po);




}