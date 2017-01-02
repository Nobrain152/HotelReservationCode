package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;


import bl.VOPOchange;
import dataservice.hoteldataservice.RoomInfoDataService;
import po.RoomInfoPO;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;
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
	public ArrayList<RoomInfoVO> hotelRoomSearch(String hotelID)throws RemoteException{
		ArrayList<RoomInfoVO> vos=new ArrayList<RoomInfoVO>();
		ArrayList<RoomInfoPO> pos=roomData.hotelRoomSearch(hotelID);
		//System.out.println(pos.size());
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
	public ResultMsg hotelRoomMod(String hotelid,ArrayList<RoomInfoVO> vo)throws RemoteException{
		for(RoomInfoVO v:vo){
			ResultMsg resultMsg1=roomData.delete(v.getHotelid(),v.getRoomID());
			resultMsg1=roomData.insert((RoomInfoPO)VOPOchange.VOtoPO(v));
			if(resultMsg1!=ResultMsg.SUCCESS){
				return resultMsg1;
			}
		}
		return ResultMsg.SUCCESS;
	}
	
	
	/**
	 * ���������ʱ���жϾƵ���һʱ��ο�Ԥ���Ŀշ�
	 * @param hotelid
	 * @param intime
	 * @param outtime
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> getEmptyRoom(String hotelid) throws RemoteException{
		ArrayList<RoomInfoVO> empty=new ArrayList<RoomInfoVO>();
		ArrayList<RoomInfoVO> all=hotelRoomSearch(hotelid);
		for(RoomInfoVO vo:all){
			if(vo.getState()==RoomState.USABLE){
				empty.add(vo);
			}
		}
		return empty;
		
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
	public ArrayList<RoomInfoVO> getTypeRoom(String hotelid,RoomType type) throws RemoteException{
		ArrayList<RoomInfoVO> empty=new ArrayList<RoomInfoVO>();
		ArrayList<RoomInfoVO> all=hotelRoomSearch(hotelid);
		for(RoomInfoVO vo:all){
			if(vo.getState()==RoomState.USABLE){
				if(vo.getType()==type){
					empty.add(vo);
				}
			}
		}
		return empty;
		
	}

	public void update(RoomInfoPO roomInfoPO) throws RemoteException {
		roomData.update(roomInfoPO);
	}

	public RoomInfoPO findByRoomID(String string) throws RemoteException {
		return roomData.findByRoomID(string);
	}

}
