
package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * 查看酒店信息
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
	 * 查看酒店信息
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
