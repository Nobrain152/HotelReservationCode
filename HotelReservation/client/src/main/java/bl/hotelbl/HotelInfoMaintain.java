package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import util.HotelMsg;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * 维护酒店基本信息
 * @author gyf
 *
 */
public class HotelInfoMaintain {
	private HotelInfoDataService hotelInfoData;
	private HotelMsg hotel;
	
	public HotelInfoMaintain(HotelInfoDataService hotelInfoData){
		this.hotelInfoData=hotelInfoData;
	}

	/**
	 * 输入酒店基本信息
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public HotelMsg inputHotelInfo(HotelInfoVO hotelInfoVO)  throws RemoteException{
		HotelInfoPO hotelInfoPO = hotelInfoData.findByID(hotelInfoVO.getHotelID());
		hotel = new HotelMsg(hotelInfoPO.getName(),hotelInfoPO.getAddress(),
    			hotelInfoPO.getArea(),hotelInfoPO.getLevel(),hotelInfoPO.getIntroduction(),
    			hotelInfoPO.getFacility(),hotelInfoPO.getIsReserved());
		return hotel;
	}
	
	/**
	 * 检查信息是否符合标准
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
    public ResultMsg checkInfo(HotelInfoVO hotelInfoVO)  throws RemoteException{
    	return ResultMsg.SUCCESS;
    }
}
