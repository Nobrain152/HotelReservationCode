package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.orderblservice.OrderOnWebBLService;
import dataservice.orderdataservice.OrderDataService;
import net.RMIManage;
import util.DataServiceType;
import vo.OrderVO;

public class OrderOnWebController implements OrderOnWebBLService{

	private OrderOnWeb orderOnWeb;
	private OrderDataService orderOnWebDataService;
	
	public OrderOnWebController() {
		orderOnWebDataService = (OrderDataService)RMIManage.
				getDataService(DataServiceType.OrderDataService);
		orderOnWeb = new OrderOnWeb(orderOnWebDataService);
	}

	@Override
	public ArrayList<OrderVO> abnormalOrderScan() {
		try {
			return orderOnWeb.abnormalOrderScan();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public OrderVO abnormalOrderDetail(String ID) {
		try {
			return orderOnWeb.abnormalOrderDetail(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ArrayList<OrderVO> dayUnexOrder(String today) {
		try {
			return orderOnWeb.dayUnexOrder(today);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
