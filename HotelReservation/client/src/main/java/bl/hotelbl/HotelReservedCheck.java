package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelInfoDataService;
import vo.HotelInfoVO;

public class HotelReservedCheck {
	public ArrayList<HotelInfoVO> hotelList;
	private HotelInfoDataService hotelData;
	
	public HotelReservedCheck(HotelInfoDataService hotelDataService) {
		this.hotelData=hotelDataService;
		hotelList = new ArrayList<HotelInfoVO>();
	}
	
	//TODO ��ҪVOPOת��
	public ArrayList<HotelInfoVO> checkReserved(HotelInfoVO reservedHotelListVO) throws RemoteException{
		
    	return hotelList; 
    }
}
