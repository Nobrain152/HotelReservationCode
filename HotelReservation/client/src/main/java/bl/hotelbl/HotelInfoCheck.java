
package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * �鿴�Ƶ���Ϣ
 * @author gyf
 *
 */
public class HotelInfoCheck {
	
	private HotelInfoDataService hotelData;
	private ResultMsg resultMsg;
	
	public HotelInfoCheck(HotelInfoDataService hotelDataService){
		this.hotelData = hotelDataService;
	}
	
	/**
	 * �鿴�Ƶ���Ϣ
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg checkHotelInfo(HotelInfoVO hotelInfoVO) throws RemoteException{
		HotelInfoPO hotelInfoPO = hotelData.findByID(hotelInfoVO.getHotelID());
		if(hotelInfoPO != null)
			resultMsg = ResultMsg.SUCCESS;
		else
			resultMsg = ResultMsg.FAIL;
    	return resultMsg;
    }
}
