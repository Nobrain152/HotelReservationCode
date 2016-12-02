package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.hoteldataservice.RoomInfoDataService;
import po.RoomInfoPO;
import util.ResultMsg;
import vo.RoomInfoVO;

/**
 * ���ڷ���Ĳ���
 * @author �ܳ�
 *
 */
public class RoomAdd {
	
	private RoomInfoDataService roomData;
	private ResultMsg result;
	
	public RoomAdd(RoomInfoDataService roomDataService){
		this.roomData=roomDataService;
	}
	
	/**
	 * ��ӿͷ�
	 * @param roomInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg addRoom(RoomInfoVO roomInfoVO) throws RemoteException{
		RoomInfoPO roomInfoPO = (RoomInfoPO)VOPOchange.VOtoPO(roomInfoVO);
		result = roomData.insert(roomInfoPO);
		return result;
	}
	
	/**
	 * ���¿ͷ���Ϣ
	 * @param roomInfoVO
	 * @return
	 * @throws RemoteException
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO) throws RemoteException{
    	RoomInfoPO roomInfoPO = (RoomInfoPO)VOPOchange.VOtoPO(roomInfoVO);
    	return roomData.update(roomInfoPO);
    }
    
    /**
	 * ���ݾƵ�ID�鿴�Ƶ귿���б�
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoomInfoVO> HotelRoomSearch(String hotelID)throws RemoteException{
		ArrayList<RoomInfoVO> vos=new ArrayList<RoomInfoVO>();
		ArrayList<RoomInfoPO> pos=roomData.HotelRoomSearch(hotelID);
		for(RoomInfoPO p:pos){
			vos.add((RoomInfoVO)VOPOchange.POtoVO(p));
		}
		return vos;
	}
	
	/**
	 * �޸ľƵ귿���б�
	 * @param hotelid
	 * @param vo
	 * @return
	 */
	public ResultMsg HotelRoomMod(String hotelid,ArrayList<RoomInfoVO> vo)throws RemoteException{
		ArrayList<RoomInfoPO> pos=new ArrayList<RoomInfoPO>();
		for(RoomInfoVO v:vo){
			pos.add((RoomInfoPO)VOPOchange.VOtoPO(v));
		}
		return roomData.HotelRoomMod(hotelid, pos);
	}

}
