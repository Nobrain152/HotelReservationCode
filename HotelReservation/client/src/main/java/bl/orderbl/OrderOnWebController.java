package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.orderblservice.OrderOnWebBLService;
import dataservice.orderdataservice.OrderOnWebDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.OrderOnWebVO;

public class OrderOnWebController implements OrderOnWebBLService{

	private OrderOnWeb orderOnWeb;
	private OrderOnWebDataService orderOnWebDataService;
	
	public OrderOnWebController() {
		orderOnWebDataService = (OrderOnWebDataService)RMIManage.
				getDataService(DataServiceType.OrderOnWebDataService);
		orderOnWeb = new OrderOnWeb(orderOnWebDataService);
	}
	@Override
	public ArrayList<OrderOnWebVO> complaintListScan() {
		try {
			return orderOnWeb.complaintListScan();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMsg complaintHandle(OrderOnWebVO orderVO) {
		try {
			return orderOnWeb.complaintHandle(orderVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<OrderOnWebVO> abnormalOrderScan() {
		try {
			return orderOnWeb.abnormalOrderScan();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public OrderOnWebVO abnormalOrderDetail(String ID) {
		try {
			return orderOnWeb.abnormalOrderDetail(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
