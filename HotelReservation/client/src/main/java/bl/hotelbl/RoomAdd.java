package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;


import bl.VOPOchange;
import dataservice.hoteldataservice.RoomInfoDataService;
import po.RoomInfoPO;
import util.ResultMsg;
import vo.RoomInfoVO;

/**
 * 关于房间的操作
 * @author 曹畅
 *
 */
public class RoomAdd {
	
	private RoomInfoDataService roomData;
	private ResultMsg result;
	
	public RoomAdd(RoomInfoDataService roomDataService){
		this.roomData=roomDataService;
	}
	
	/**
	 * 添加客房
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
	 * 更新客房信息
	 * @param roomInfoVO
	 * @return
	 * @throws RemoteException
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO) throws RemoteException{
    	RoomInfoPO roomInfoPO = (RoomInfoPO)VOPOchange.VOtoPO(roomInfoVO);
    	return roomData.update(roomInfoPO);
    }
    
    /**
	 * 根据酒店ID查看酒店房间列表
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
	 * 修改酒店房间列表
	 * @param hotelid
	 * @param vo
	 * @return
	 */
	public ResultMsg HotelRoomMod(String hotelid,ArrayList<RoomInfoVO> vo)throws RemoteException{
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
	 * 根据输入的时间判断酒店这一时间段可预订的空房
	 * @param hotelid
	 * @param intime
	 * @param outtime
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> getEmptyRoom(String hotelid,String intime,String outtime) throws RemoteException{
		ArrayList<RoomInfoVO> empty=new ArrayList<RoomInfoVO>();
		ArrayList<RoomInfoVO> all=HotelRoomSearch(hotelid);
		Date date=new Date(intime, outtime);
		for(RoomInfoVO vo:all){
			ArrayList<Date> d=vo.getOrderedTime();
			boolean goon=false;
			for(Date d1:d){
				if(d1.isConflict(date)){
					goon=true;
					break;
				}
			}
			if(goon){
				goon=false;
				continue;
			}
			empty.add(vo);
		}
		return empty;
		
	}

}
