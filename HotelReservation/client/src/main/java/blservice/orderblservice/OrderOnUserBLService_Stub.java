package blservice.orderblservice;

import java.util.ArrayList;

import util.OrderState;
import vo.OrderVO;

public class OrderOnUserBLService_Stub implements OrderOnUserBLService{

	OrderState orderState;

	public OrderOnUserBLService_Stub(){

	}
	
	public OrderOnUserBLService_Stub(OrderState orderState) {
		super();
		this.orderState = orderState;
	}
	


	@Override
	public ArrayList<OrderVO> personalOrderScan(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createOrder(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public util.ResultMsg personalOrderCancel(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO personalOrderDetail(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
