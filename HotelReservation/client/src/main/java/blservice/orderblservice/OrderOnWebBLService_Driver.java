package blservice.orderblservice;

import java.util.ArrayList;

import vo.OrderVO;

public class OrderOnWebBLService_Driver {
	
	public static void main(String[] args){
		OrderOnWebBLService a = new OrderOnWebBLService_Stub();
		OrderOnWebBLService_Driver driver = new OrderOnWebBLService_Driver();
		driver.drive(a);
	}
	
	public void drive(OrderOnWebBLService OrderOnWebBLService){
		OrderVO orderVO = new OrderVO(); 
		
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
