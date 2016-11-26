package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelInfoDataService;
import vo.HotelInfoVO;

/**
 * 显示预定过的酒店列表
 * @author gyf
 *
 */
public class HotelReservedCheck {
	public ArrayList<HotelInfoVO> hotelList;
	private HotelInfoDataService hotelData;
	
	public HotelReservedCheck(HotelInfoDataService hotelDataService) {
		this.hotelData=hotelDataService;
		hotelList = new ArrayList<HotelInfoVO>();
	}
	
	
	/**
	 * 显示预定过的酒店列表
	 * @param reservedHotelListVO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<HotelInfoVO> checkReserved(HotelInfoVO reservedHotelListVO) throws RemoteException{
		//TODO 需要VOPO转换
    	return hotelList; 
    }
}
