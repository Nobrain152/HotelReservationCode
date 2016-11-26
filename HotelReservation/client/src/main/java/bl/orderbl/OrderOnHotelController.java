package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.orderblservice.OrderOnHotelBLService;
import util.ResultMsg;
import vo.OrderOnHotelVO;

public class OrderOnHotelController implements OrderOnHotelBLService{

	OrderOnHotel hotelOrder;
	
	/* (non-Javadoc)
	 * @see blservice.orderblservice.OrderOnHotelBLService#hotelOrderScan()
	 */
	public ArrayList<OrderOnHotelVO> hotelOrderScan() {
		try {
			return hotelOrder.hotelOrderScan();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see blservice.orderblservice.OrderOnHotelBLService#hotelOrderDetail(java.lang.String)
	 */
	public OrderOnHotelVO hotelOrderDetail(String ID) {
		try {
			return hotelOrder.hotelOrderDetail(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see blservice.orderblservice.OrderOnHotelBLService#hotelOrderModify(vo.OrderOnHotelVO)
	 */
	public ResultMsg hotelOrderModify(OrderOnHotelVO orderVO) {
		try {
			return hotelOrder.hotelOrderModify(orderVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

}
