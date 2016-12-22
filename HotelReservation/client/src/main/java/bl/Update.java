package bl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.orderdataservice.OrderDataService;
import net.RMIManage;
import po.OrderPO;
import util.DataServiceType;
import util.OrderState;
import util.Today;

/**
 * 如果时间在超过最晚订单执行时间后还没有办理入住，系统自动将其置为异常订单
 * @author txin
 *
 */
public class Update implements Runnable{
	
	private OrderDataService orderDataService = (OrderDataService)RMIManage.
			getDataService(DataServiceType.OrderDataService);
	
		
	@Override
	public void run() {
		
		final long timeInterval = 60000;// 1分钟运行一次
		
		while (true) {
			
			ArrayList<OrderPO> orderPOs = null;
			try {
				orderPOs = orderDataService.showList();
				System.out.println("Success txin");
			} catch (NullPointerException e) {
				e.printStackTrace();
				// TODO: handle exception
			}catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(orderPOs != null) {
				for(OrderPO po : orderPOs) {
					if(po.getLatestExecutionTime().compareTo(new Today().getToday()) < 0
							&& po.getOrderState() == OrderState.UNEXECUTED) {
						po.setOrderState(OrderState.ABNORMAL);
						try {
							System.out.println(orderDataService.update(po));
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			try {
				Thread.sleep(timeInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
