package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelInfoDataService;
import util.HotelMsg;
import vo.HotelInfoVO;

public class HotelSearch {
	private HotelInfoDataService hotelData;
	private HotelMsg evaluation;
	public ArrayList<HotelInfoVO> hotelList;
	
	public HotelSearch(HotelInfoDataService hotelDataService){
		this.hotelData=hotelDataService;
		hotelList = new ArrayList<HotelInfoVO>();
	}

	public HotelMsg selectCondition(HotelInfoVO hotelInfoVO) throws RemoteException{
		evaluation =new HotelMsg(hotelInfoVO.getName(),hotelInfoVO.getAddress(),
    			hotelInfoVO.getArea(),hotelInfoVO.getLevel(),hotelInfoVO.getIntroduction(),
    			hotelInfoVO.getFacility(),hotelInfoVO.isReserved());
		return evaluation;
	}
	
	
    public ArrayList<HotelInfoVO> showList(HotelInfoVO hotelListInfoVO) throws RemoteException{
    	return hotelList;
    }
}
