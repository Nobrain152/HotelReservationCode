package blservice.orderblservice;

import java.util.ArrayList;

import util.OrderState;
import util.RoomType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class OrderOnWebBLService_Driver {
	
	public static void main(String[] args){
		OrderOnWebBLService a = new OrderOnWebBLService_Stub();
		OrderOnWebBLService_Driver driver = new OrderOnWebBLService_Driver();
		driver.drive(a);
	}
	
	public void drive(OrderOnWebBLService OrderOnWebBLService){
		CustomerInfoVO client = new CustomerInfoVO("1000066", "123", "12345678910", "sfd", 0, false, null);
		OrderVO orderVO = new OrderVO("60000010", client, OrderState.UNEXECUTED, 100, "5000", false, "", "", "", "", 1, null, 1, RoomType.ROOM_BIGBED);
		
		OrderVO msg1 = OrderOnWebBLService.abnormalOrderDetail(orderVO.getOrderID());
		if(msg1.getOrderID().equals(orderVO.getOrderID()))
			System.out.println("��ʾ�쳣��������");
		else
			System.out.println("��ʾʧ��");
		
		ArrayList<OrderVO> arr = OrderOnWebBLService.abnormalOrderScan();
		if(arr != null)
			System.out.println("��ʾ�쳣�����б�");
		else
			System.out.println("��ʾʧ��");
	}
}
