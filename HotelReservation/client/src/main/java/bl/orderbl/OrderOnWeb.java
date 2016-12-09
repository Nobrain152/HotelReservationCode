package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import util.OrderState;
import vo.OrderVO;

public class OrderOnWeb {
	
	private OrderDataService webDataService;
	
	public OrderOnWeb(OrderDataService webDataService) {
		this.webDataService = webDataService;
	}
	
	/**
	 * 网站营销人员查看异常订单列表
	 *
	 * @param void
	 * @return 异常订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> abnormalOrderScan() throws RemoteException {
		ArrayList<OrderVO> webVOs;
		ArrayList<OrderPO> webPOs;
		
		webPOs = webDataService.showList();
		
		if(webPOs == null || webPOs.isEmpty()) {
			return null;
		}
		
		webVOs = new ArrayList<OrderVO>();
		for(OrderPO webPO : webPOs){
			if(webPO.getOrderState() == OrderState.ABNORMAL)
				webVOs.add((OrderVO)VOPOchange.POtoVO(webPO));
		}
		
		return webVOs;
	}
	
	/**
	 * 浏览每日未执行订单
	 * @param today
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> dayUnexOrder(String today) throws RemoteException {
		ArrayList<OrderVO> webVOs;
		ArrayList<OrderPO> webPOs;
		
		webPOs = webDataService.showList();
		
		if(webPOs == null || webPOs.isEmpty()) {
			return null;
		}
		
		webVOs = new ArrayList<OrderVO>();
		for(OrderPO webPO : webPOs){
			if(webPO.getOrderState() == OrderState.UNEXECUTED && webPO.getLatestExecutionTime().equals(today))
				webVOs.add((OrderVO)VOPOchange.POtoVO(webPO));
		}
		
		return webVOs;
	}
	
	/**
	 * 网站营销人员查看异常订单详情
	 *
	 * @param String 订单ID
	 * @return 个人订单详情
	 * @throws RemoteException 
	 */
	public OrderVO abnormalOrderDetail(String ID) throws RemoteException{
		ArrayList<OrderPO> webPOs;
		webPOs = webDataService.showList();
		
		for(OrderPO webPO : webPOs) {
			if(webPO.getOrderID().equals(ID))
				return (OrderVO)VOPOchange.POtoVO(webPO);
		}
		return null;
	}

}
