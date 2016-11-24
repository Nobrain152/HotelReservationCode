package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelInfoDataService;
import util.EvaluationMsg;
import util.OrderOnUserMsg;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderOnUserVO;

public class HotelReserve {
	private HotelInfoDataService hotelInfoData;
	private EvaluationMsg evaluation;
	private ResultMsg result;
	
	public HotelReserve(HotelInfoDataService hotelInfoDataService){
		this.hotelInfoData=hotelInfoDataService;
	}
	
	
	public ResultMsg reserveHotel(HotelInfoVO reserveHotelVO) throws RemoteException{
		return new ResultMsg(true,"Ô¤¶¨³É¹¦");
	}
	
	
    public OrderOnUserMsg createUserOrder(OrderOnUserVO order) throws RemoteException{
    	return new OrderOnUserMsg(order.getInitiator(),order.getOrderID(), order.getOrderState(), order.getPrice(), order.getLatestExecutionTime(), 
				order.getRoomType(), order.getRoomNumber(), order.getPeopleNumber(), order.getHasChild());
    }

}
