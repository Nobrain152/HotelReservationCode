package blservice.orderblservice;

import java.util.ArrayList;

import po.OrderPO;
import util.OrderState;
import util.ResultMsg;
import vo.OrderVO;

public class OrderOnHotelBLService_Stub implements OrderOnHotelBLService{
	OrderState orderState;

	public OrderOnHotelBLService_Stub(){

	}
	
	public OrderOnHotelBLService_Stub(OrderState orderState) {
		super();
		this.orderState = orderState;
	}
	
	@Override
	//提交界面得到修改订单状态的反馈结果
	public ResultMsg hotelOrderModify(OrderVO orderVO) {
		if(orderVO.getOrderState() != OrderState.UNEXECUTED)
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}

	@Override
	public ArrayList<OrderVO> hotelOrderScan(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO hotelOrderDetail(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(OrderPO poTmp) {
		// TODO Auto-generated method stub
		
	}


}
