package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.orderblservice.OrderOnUserBLService;
import dataservice.orderdataservice.OrderOnUserDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.OrderOnUserVO;

public class OrderOnUserController implements OrderOnUserBLService{

	private OrderOnUser orderOnUser;
	private OrderOnUserDataService userDataService;
	
	public OrderOnUserController() {
		userDataService = (OrderOnUserDataService)RMIManage.
				getDataService(DataServiceType.OrderOnUserDataService);
		orderOnUser = new OrderOnUser(userDataService);
	}
	
	@Override
	public ArrayList<OrderOnUserVO> personalOrderScan() {
		try {
			return orderOnUser.personalOrderScan();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMsg personalOrderCancel(OrderOnUserVO orderVO) {
		try {
			return orderOnUser.personalOrderCancel(orderVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public OrderOnUserVO personalOrderDetail(String ID) {
		try {
			return orderOnUser.personalOrderDetail(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createOrder(OrderOnUserVO orderVO) {
		try {
			orderOnUser.createOrder(orderVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
