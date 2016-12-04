package blservice.hotelblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMsg;
import vo.RoomInfoVO;

/**
 * ��ӿ��ÿͷ��Ľӿ�
 * @author �ܳ�
 *
 */
public interface RoomAddBLService {
	
	/**
	 * ��ӿ��ÿͷ�
	 * @param roomInfoVO
	 * @return
	 */
	public ResultMsg addRoom(RoomInfoVO roomInfoVO);
	
	/**
	 * ���¿ͷ���Ϣ
	 * @param roomInfoVO
	 * @return
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO);
    
    /**
	 * ���ݾƵ�ID�鿴�Ƶ귿���б�
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoomInfoVO> HotelRoomSearch(String hotelID);
	
	/**
	 * �޸ľƵ귿���б�
	 * @param hotelid
	 * @param po
	 * @return
	 */
	public ResultMsg HotelRoomMod(String hotelid,ArrayList<RoomInfoVO> po);
   
	
	/**
	 * ���������ʱ���жϾƵ���һʱ��ο�Ԥ���Ŀշ�
	 * @param hotelid
	 * @param intime
	 * @param outtime
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> getEmptyRoom(String hotelid,String intime,String outtime);
}