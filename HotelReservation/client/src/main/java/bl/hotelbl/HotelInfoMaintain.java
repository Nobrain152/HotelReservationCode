package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelInfoDataService;
import util.HotelMsg;
import util.ResultMsg;
import vo.HotelInfoVO;

public class HotelInfoMaintain {
	private HotelInfoDataService hotelInfoData;
	private HotelMsg hotel;
	private ResultMsg result;
	
	public HotelInfoMaintain(HotelInfoDataService hotelInfoData){
		this.hotelInfoData=hotelInfoData;
	}

	
	public HotelMsg inputHotelInfo(HotelInfoVO hotelInfoVO)  throws RemoteException{
		hotel=new HotelMsg(hotelInfoVO.getName(),hotelInfoVO.getAddress(),
    			hotelInfoVO.getArea(),hotelInfoVO.getLevel(),hotelInfoVO.getIntroduction(),
    			hotelInfoVO.getFacility(),hotelInfoVO.isReserved());
		return hotel;
	}
	
	
    public ResultMsg submitInfo(HotelInfoVO hotelInfoVO)  throws RemoteException{
    	result=new ResultMsg(true,"ά���ɹ�");
    	return result;
    }
}
