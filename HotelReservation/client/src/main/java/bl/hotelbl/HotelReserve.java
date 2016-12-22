package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import blservice.hotelblservice.RoomAddBLService;
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
	private RoomAddBLService roomcon;
	private BusinessLogicDataFactory factory;
	
	public HotelReserve(HotelInfoDataService hotelInfoDataService){
		this.hotelInfoData=hotelInfoDataService;
		factory=BusinessLogicDataFactory.getFactory();
		roomcon=factory.getRoomAddBLService();
		
	}
	
	/**
	 * Ô¤¶©¾Æµê²¢ÐÞ¸Ä·¿¼äÐÅÏ¢
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg reserveHotel(OrderVO vo) throws RemoteException{
		String hotelid=vo.getHotelID();
		int number=vo.getRoomNumber();
		Date date=new Date(vo.getCheckInTime(),vo.getCheckOutTime() );
		ArrayList<RoomInfoVO> room=roomcon.HotelRoomSearch(hotelid);
		//System.out.println(room.size());
		for(RoomInfoVO v:room ){
			
			if(v.getType()==vo.getRoomType()){
				//System.out.println("here");
				if(v.addOrderedTime(date)){
					room.set(room.indexOf(v),v);
					number--;
					if(number==0){
						roomcon.HotelRoomMod(hotelid, room);
						return ResultMsg.SUCCESS;
					}	
				}
			}
		}
		//System.out.println(number);
		return ResultMsg.FAIL;
	}
	

}
