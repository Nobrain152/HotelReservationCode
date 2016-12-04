package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelInfoDataService;
import util.ResultMsg;
import vo.OrderVO;
import vo.RoomInfoVO;


/**
 * Ô¤¶©¾Æµê
 * @author ²Ü³©
 *
 */
public class HotelReserve {
	private HotelInfoDataService hotelInfoData;
	private RoomAddController roomcon;
	
	public HotelReserve(HotelInfoDataService hotelInfoDataService){
		this.hotelInfoData=hotelInfoDataService;
		roomcon=new RoomAddController();
		
	}
	
	
	public ResultMsg reserveHotel(OrderVO vo) throws RemoteException{
		String hotelid=vo.hotelID;
		int number=vo.getRoomNumber();
		Date date=new Date(vo.getCheckInTime(),vo.getCheckOutTime() );
		ArrayList<RoomInfoVO> room=roomcon.HotelRoomSearch(hotelid);
		for(RoomInfoVO v:room ){
			if(v.getType()==vo.getRoomInfoVO().getType()){
				if(v.addOrderedTime(date)){
					number--;
					if(number==0){
						roomcon.HotelRoomMod(hotelid, room);
						return ResultMsg.SUCCESS;
					}	
				}
			}
		}
		return ResultMsg.FAIL;
	}
	

}
