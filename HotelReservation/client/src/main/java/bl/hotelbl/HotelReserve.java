package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelInfoDataService;
import util.EvaluationMsg;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderVO;

public class HotelReserve {
	private HotelInfoDataService hotelInfoData;
	private EvaluationMsg evaluation;
	private ResultMsg result;
	
	public HotelReserve(HotelInfoDataService hotelInfoDataService){
		this.hotelInfoData=hotelInfoDataService;
	}
	
	
	public ResultMsg reserveHotel(HotelInfoVO reserveHotelVO) throws RemoteException{
		
		return ResultMsg.SUCCESS;
	}
	
	
    public ResultMsg createUserOrder(OrderVO order) throws RemoteException{
    	return ResultMsg.SUCCESS;
    }

}
