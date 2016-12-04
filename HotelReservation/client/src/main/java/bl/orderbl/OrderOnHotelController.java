package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.orderblservice.OrderOnHotelBLService;
import dataservice.creditdataservice.CreditDataService;
import dataservice.hoteldataservice.RoomInfoDataService;
import dataservice.orderdataservice.OrderDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.OrderVO;

public class OrderOnHotelController implements OrderOnHotelBLService{

	private OrderOnHotel hotelOrder;
	private OrderDataService hotelDataService;
	private RoomInfoDataService roomInfoDataService;
	private CreditDataService creditDataService;
	
	public OrderOnHotelController() {
		hotelDataService = (OrderDataService)RMIManage.
				getDataService(DataServiceType.OrderDataService);
		hotelOrder = new OrderOnHotel(hotelDataService,roomInfoDataService,creditDataService);
	}
	
	@Override
	public ArrayList<OrderVO> hotelOrderScan(String ID) {
		try {
			return hotelOrder.hotelOrderScan(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public OrderVO hotelOrderDetail(String ID) {
		try {
			return hotelOrder.hotelOrderDetail(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMsg hotelOrderModify(OrderVO orderVO) {
		try {
			return hotelOrder.hotelOrderModify(orderVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
