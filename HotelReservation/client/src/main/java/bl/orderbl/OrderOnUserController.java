package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.orderblservice.OrderOnUserBLService;
import dataservice.orderdataservice.OrderDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.OrderVO;

public class OrderOnUserController implements OrderOnUserBLService{

	private OrderOnUser orderOnUser;
	private OrderDataService userDataService;
	
	public OrderOnUserController() {
		userDataService = (OrderDataService)RMIManage.
				getDataService(DataServiceType.OrderDataService);
		orderOnUser = new OrderOnUser(userDataService);
	}
	
	@Override
	public ArrayList<OrderVO> personalOrderScan(String ID) {
		try {
			return orderOnUser.personalOrderScan(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMsg personalOrderCancel(OrderVO orderVO) {
		try {
			return orderOnUser.personalOrderCancel(orderVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public OrderVO personalOrderDetail(String ID) {
		try {
			return orderOnUser.personalOrderDetail(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createOrder(OrderVO orderVO) {
		try {
			orderOnUser.createOrder(orderVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}