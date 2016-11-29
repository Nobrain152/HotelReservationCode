
package bl.hotelbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import vo.HotelInfoVO;

/**
 * 查看酒店信息
 * @author gyf
 *
 */
public class HotelInfoCheck {
	
	private HotelInfoDataService hotelData;
	
	public HotelInfoCheck(HotelInfoDataService hotelDataService){
		this.hotelData = hotelDataService;
	}
	
	/**
	 * 查看酒店信息
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public HotelInfoVO checkHotelInfo(String hotelid) throws RemoteException{
		HotelInfoPO hotelInfoPO = hotelData.findByID(hotelid);
    	return (HotelInfoVO)VOPOchange.POtoVO(hotelInfoPO);
    }
}
