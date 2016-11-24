package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelInfoDataService;
import util.HotelMsg;
import vo.HotelInfoVO;

public class HotelInfoCheck {
	
	private HotelInfoDataService hotelData;
	private HotelMsg hotel;
	
	public HotelInfoCheck(HotelInfoDataService hotelDataService){
		this.hotelData=hotelDataService;
	}
	
	public HotelMsg checkHotelInfo(HotelInfoVO hotelInfoVO) throws RemoteException{
    	hotel= new HotelMsg(hotelInfoVO.getName(),hotelInfoVO.getAddress(),
    			hotelInfoVO.getArea(),hotelInfoVO.getLevel(),hotelInfoVO.getIntroduction(),
    			hotelInfoVO.getFacility(),hotelInfoVO.isReserved());
    	return hotel;
    }
}
