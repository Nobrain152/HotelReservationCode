package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelInfoDataService;
import vo.HotelInfoVO;

/**
 * ËÑË÷¾Æµê
 * @author ²Ü³©
 *
 */
public class HotelSearch {
	private HotelInfoDataService hotelData;
	public ArrayList<HotelInfoVO> hotelList;
	
	public HotelSearch(HotelInfoDataService hotelDataService){
		this.hotelData=hotelDataService;
		hotelList = new ArrayList<HotelInfoVO>();
	}

	/**
	 * Ñ¡ÔñÌõ¼þ
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<HotelInfoVO> selectCondition(HotelInfoVO hotelInfoVO) throws RemoteException{
		
		return hotelList;
	}
	
}
