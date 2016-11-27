package bl.hotelbl;

import java.rmi.RemoteException;

import blservice.hotelblservice.HotelReserveBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderVO;

public class HotelReserveController implements HotelReserveBLService{
	private HotelReserve hotelReserve;
	private HotelInfoDataService hotelInfoData;
	
	public HotelReserveController() {
		hotelInfoData = (HotelInfoDataService) RMIManage
				.getDataService(DataServiceType.HotelInfoDataService);
		hotelReserve = new HotelReserve(hotelInfoData);
	}

	/**
	 * 预定酒店
	 *
	 */
	@Override
	public ResultMsg reserveHotel(HotelInfoVO reserveHotelVO){
		try {
			return hotelReserve.reserveHotel(reserveHotelVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 创建用户订单
	 * 
	 */
	@Override
    public ResultMsg createUserOrder(OrderVO order){
		try {
			return hotelReserve.createUserOrder(order);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }
	

      
}