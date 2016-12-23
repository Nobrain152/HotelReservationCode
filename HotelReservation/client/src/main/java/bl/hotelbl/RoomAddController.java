package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.hotelblservice.RoomAddBLService;
import dataservice.hoteldataservice.RoomInfoDataService;
import net.RMIManage;
import po.RoomInfoPO;
import util.DataServiceType;
import util.ResultMsg;
import util.RoomType;
import vo.RoomInfoVO;

/**
 * 
 * @author �ܳ�
 *
 */
public class RoomAddController implements RoomAddBLService{
	public ArrayList<RoomInfoVO> roomList;
	private RoomAdd roomAdd;
	private RoomInfoDataService roomInfoData;
	
	public RoomAddController() {
		roomList = new ArrayList<RoomInfoVO>();
		roomInfoData = (RoomInfoDataService) RMIManage
				.getDataService(DataServiceType.RoomInfoDataService);
		roomAdd = new RoomAdd(roomInfoData);
	}
	
	/**
	 * ��ӿͷ�
	 * @param roomInfoVO
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ResultMsg addRoom(RoomInfoVO roomInfoVO){
		try {
			return roomAdd.addRoom(roomInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ���¿ͷ���Ϣ
	 * @param roomInfoVO
	 * @return
	 * @throws RemoteException
	 */
	@Override
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO){
		try {
			return roomAdd.updateRoom(roomInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }
	
	/**
	 * ���ݾƵ�ID�鿴�Ƶ귿���б�
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoomInfoVO> HotelRoomSearch(String hotelID){
		try {
			return roomAdd.HotelRoomSearch(hotelID);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * �޸ľƵ귿���б�
	 * @param hotelid
	 * @param po
	 * @return
	 */
	public ResultMsg HotelRoomMod(String hotelid,ArrayList<RoomInfoVO> vo){
		try {
			return roomAdd.HotelRoomMod(hotelid, vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
	
	/**
	 * ���������ʱ���жϾƵ���һʱ��ο�Ԥ���Ŀշ�
	 * @param hotelid
	 * @param intime
	 * @param outtime
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> getEmptyRoom(String hotelid){
		try {
			return roomAdd.getEmptyRoom(hotelid);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * �����ض��������͵Ŀշ����б�
	 * @param hotelid
	 * @param intime
	 * @param outtime
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> getTypeRoom(String hotelid,RoomType type){
		try {
			return roomAdd.getTypeRoom(hotelid, type);
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RoomInfoPO findByRoomID(String string) {
		try {
			return roomInfoData.findByRoomID(string);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(RoomInfoPO roomInfoPO) {
		try {
			roomInfoData.update(roomInfoPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}