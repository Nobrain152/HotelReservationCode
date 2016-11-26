package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.orderblservice.OrderOnHotelBLService;
import dataservice.orderdataservice.OrderOnHotelDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.OrderOnHotelVO;

public class OrderOnHotelController implements OrderOnHotelBLService{

	private OrderOnHotel hotelOrder;
	private OrderOnHotelDataService hotelDataService;
	
	public OrderOnHotelController() {
		hotelDataService = (OrderOnHotelDataService)RMIManage.
				getDataService(DataServiceType.OrderOnHotelDataService);
		hotelOrder = new OrderOnHotel(hotelDataService);
	}
	
	@Override
	public ArrayList<OrderOnHotelVO> hotelOrderScan() {
		try {
			return hotelOrder.hotelOrderScan();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public OrderOnHotelVO hotelOrderDetail(String ID) {
		try {
			return hotelOrder.hotelOrderDetail(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMsg hotelOrderModify(OrderOnHotelVO orderVO) {
		try {
			return hotelOrder.hotelOrderModify(orderVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
