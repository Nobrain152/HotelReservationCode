package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import util.HotelMsg;
import vo.HotelInfoVO;

/**
 * �鿴�Ƶ���Ϣ
 * @author gyf
 *
 */
public class HotelInfoCheck {
	
	private HotelInfoDataService hotelData;
	private HotelMsg hotel;
	
	public HotelInfoCheck(HotelInfoDataService hotelDataService){
		this.hotelData = hotelDataService;
	}
	
	/**
	 * �鿴�Ƶ���Ϣ
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public HotelMsg checkHotelInfo(HotelInfoVO hotelInfoVO) throws RemoteException{
		HotelInfoPO hotelInfoPO = hotelData.findByID(hotelInfoVO.getHotelID());
    	hotel = new HotelMsg(hotelInfoPO.getName(),hotelInfoPO.getAddress(),
    			hotelInfoPO.getArea(),hotelInfoPO.getLevel(),hotelInfoPO.getIntroduction(),
    			hotelInfoPO.getFacility(),hotelInfoPO.getIsReserved());
    	return hotel;
    }
}
