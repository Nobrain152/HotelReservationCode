package blservice.orderblservice;


import blservice.orderblservice.OrderOnHotelBLService;
import util.ResultMsg;
import vo.OrderVO;

public class OrderOnHotelBLService_Driver {
	
	public static void main(String[] args){
		OrderOnHotelBLService a = new OrderOnHotelBLService_Stub();
		OrderOnHotelBLService_Driver driver = new OrderOnHotelBLService_Driver();
		driver.drive(a);
	}
	
	public void drive(OrderOnHotelBLService OrderOnHotelBLService){
		OrderVO orderVO = new OrderVO(); 
				
		ResultMsg result = OrderOnHotelBLService.hotelOrderModify(orderVO);
		if(result == ResultMsg.SUCCESS)
			System.out.println("修改订单状态成功");
		else
			System.out.println("修改失败");
		
		OrderVO orderVO2 = OrderOnHotelBLService.hotelOrderDetail(orderVO.getOrderID());
		if(orderVO2.getOrderID().equals(orderVO.getOrderID()))
			System.out.println("显示酒店订单详情");
		else
			System.out.println("显示失败");
		
	}
}
