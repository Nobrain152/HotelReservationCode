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
			System.out.println("�޸Ķ���״̬�ɹ�");
		else
			System.out.println("�޸�ʧ��");
		
		OrderVO orderVO2 = OrderOnHotelBLService.hotelOrderDetail(orderVO.getOrderID());
		if(orderVO2.getOrderID().equals(orderVO.getOrderID()))
			System.out.println("��ʾ�Ƶ궩������");
		else
			System.out.println("��ʾʧ��");
		
	}
}
