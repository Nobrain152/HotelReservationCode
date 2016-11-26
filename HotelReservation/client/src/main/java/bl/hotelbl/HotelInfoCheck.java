package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import util.HotelMsg;
import vo.HotelInfoVO;

public class HotelInfoCheck {
	
	private HotelInfoDataService hotelData;
	private HotelMsg hotel;
	
	public HotelInfoCheck(HotelInfoDataService hotelDataService){
		this.hotelData = hotelDataService;
	}
	
	public HotelMsg checkHotelInfo(HotelInfoVO hotelInfoVO) throws RemoteException{
		HotelInfoPO hotelInfoPO = hotelData.findByID(hotelInfoVO.getHotelID());
    	hotel = new HotelMsg(hotelInfoPO.getName(),hotelInfoPO.getAddress(),
    			hotelInfoPO.getArea(),hotelInfoPO.getLevel(),hotelInfoPO.getIntroduction(),
    			hotelInfoPO.getFacility(),hotelInfoPO.getIsReserved());
    	return hotel;
    }
}
