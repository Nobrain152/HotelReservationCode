package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import util.HotelMsg;
import util.ResultMsg;
import vo.HotelInfoVO;

public class HotelInfoMaintain {
	private HotelInfoDataService hotelInfoData;
	private HotelMsg hotel;
	
	public HotelInfoMaintain(HotelInfoDataService hotelInfoData){
		this.hotelInfoData=hotelInfoData;
	}

	public HotelMsg inputHotelInfo(HotelInfoVO hotelInfoVO)  throws RemoteException{
		HotelInfoPO hotelInfoPO = hotelInfoData.findByID(hotelInfoVO.getHotelID());
		hotel = new HotelMsg(hotelInfoPO.getName(),hotelInfoPO.getAddress(),
    			hotelInfoPO.getArea(),hotelInfoPO.getLevel(),hotelInfoPO.getIntroduction(),
    			hotelInfoPO.getFacility(),hotelInfoPO.getIsReserved());
		return hotel;
	}
	
	
    public ResultMsg submitInfo(HotelInfoVO hotelInfoVO)  throws RemoteException{
    	return ResultMsg.SUCCESS;
    }
}
