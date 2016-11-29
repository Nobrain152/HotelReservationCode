
package bl.hotelbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import vo.HotelInfoVO;

/**
 * �鿴�Ƶ���Ϣ
 * @author gyf
 *
 */
public class HotelInfoCheck {
	
	private HotelInfoDataService hotelData;
	
	public HotelInfoCheck(HotelInfoDataService hotelDataService){
		this.hotelData = hotelDataService;
	}
	
	/**
	 * �鿴�Ƶ���Ϣ
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public HotelInfoVO checkHotelInfo(String hotelid) throws RemoteException{
		HotelInfoPO hotelInfoPO = hotelData.findByID(hotelid);
    	return (HotelInfoVO)VOPOchange.POtoVO(hotelInfoPO);
    }
}
