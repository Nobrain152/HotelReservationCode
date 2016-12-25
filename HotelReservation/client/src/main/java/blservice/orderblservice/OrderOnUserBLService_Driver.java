package blservice.orderblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.OrderVO;


public class OrderOnUserBLService_Driver {
	
	public static void main(String[] args){
		OrderOnUserBLService a = new OrderOnUserBLService_Stub();
		OrderOnUserBLService_Driver driver = new OrderOnUserBLService_Driver();
		driver.drive(a);
	}
	
	public void drive(OrderOnUserBLService OrderOnUserBLService){
		OrderVO orderVO = new OrderVO(); 
				
		ResultMsg result = OrderOnUserBLService.personalOrderCancel(orderVO);
		if(result == ResultMsg.SUCCESS)
			System.out.println("撤销订单成功");
		else
			System.out.println("撤销订单失败");
		
		OrderVO msg1 = OrderOnUserBLService.personalOrderDetail(orderVO.getOrderID());
		if(msg1.getOrderID().equals(orderVO.getOrderID()))
			System.out.println("显示个人订单详情");
		else
			System.out.println("显示失败");
		
		ArrayList<OrderVO> arr = OrderOnUserBLService.personalOrderScan(orderVO.getInitiator().getUserID());
		if(arr != null)
			System.out.println("显示个人订单列表");
		else
			System.out.println("显示失败");
	}
}
