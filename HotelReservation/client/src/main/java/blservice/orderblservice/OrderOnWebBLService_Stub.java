package blservice.orderblservice;

import java.util.ArrayList;

import util.OrderState;
import vo.OrderVO;

public class OrderOnWebBLService_Stub implements OrderOnWebBLService{

	OrderState orderState;

	public OrderOnWebBLService_Stub(){

	}
	
	public OrderOnWebBLService_Stub(OrderState orderState) {
		super();
		this.orderState = orderState;
	}
	
	@Override
	public ArrayList<OrderVO> dayUnexOrder(String today) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO abnormalOrderDetail(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public util.ResultMsg abnormalOrderCancel(String ID, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> abnormalOrderScan() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
