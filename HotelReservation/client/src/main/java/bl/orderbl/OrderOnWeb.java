package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.creditdataservice.CreditDataService;
import dataservice.orderdataservice.OrderDataService;
import po.CreditPO;
import po.OrderPO;
import util.OrderState;
import util.ResultMsg;
import vo.OrderVO;

public class OrderOnWeb {
	
	private OrderDataService webDataService;
	private CreditDataService creditDataService;
	
	public OrderOnWeb(OrderDataService webDataService,
			CreditDataService creditDataService) {
		this.webDataService = webDataService;
		this.creditDataService = creditDataService;
	}
	
	/**
	 * 网站营销人员查看申诉列表
	 *
	 * @param void
	 * @return 申诉列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> complaintListScan() throws RemoteException {
		ArrayList<OrderVO> webVOs;
		ArrayList<OrderPO> webPOs;
		webPOs = webDataService.showList();
		
		if(webPOs == null || webPOs.isEmpty()) {
			return null;
		}
		
		webVOs = new ArrayList<>();
		for(OrderPO webPO : webPOs){
			if(webPO.getReason() != null)
				webVOs.add((OrderVO)VOPOchange.POtoVO(webPO));
		}
		
		return webVOs;
	}
	
	/**
	 * 网站营销人员处理申诉
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
	 * @throws RemoteException 
	 */
	public ResultMsg complaintHandle(OrderVO orderVO) throws RemoteException{
		OrderPO order = (OrderPO)VOPOchange.VOtoPO(orderVO);
		ResultMsg resultMsg;
		if(order.getPass()){
			order.setOrderState(OrderState.CANCELLED);
			CreditPO creditPO = creditDataService.findByID(order.getInitiator().getUserID());
			creditPO.setCredit(order.getInitiator().getCredit()
					+ order.getPrice());
		}
		resultMsg = webDataService.update(order);
		return resultMsg;
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
		
		webVOs = new ArrayList<>();
		for(OrderPO webPO : webPOs){
			if(webPO.getOrderState() == OrderState.ABNORMAL)
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
