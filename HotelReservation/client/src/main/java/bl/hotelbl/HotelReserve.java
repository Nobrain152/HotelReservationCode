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
