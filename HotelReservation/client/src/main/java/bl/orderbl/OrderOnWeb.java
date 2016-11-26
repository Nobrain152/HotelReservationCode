package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.orderdataservice.OrderOnWebDataService;
import po.OrderOnWebPO;
import util.OrderOnWebMsg;
import util.OrderState;
import util.ResultMsg;
import vo.OrderOnWebVO;

public class OrderOnWeb {
	
	private OrderOnWebDataService webDataService;
	
	/**
	 * 网站营销人员查看申诉列表
	 *
	 * @param void
	 * @return 申诉列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderOnWebVO> complaintListScan() throws RemoteException {
		ArrayList<OrderOnWebVO> webVOs;
		ArrayList<OrderOnWebPO> webPOs;
		webPOs = webDataService.getComplaintList();
		
		if(webPOs == null || webPOs.isEmpty()) {
			return null;
		}
		
		webVOs = new ArrayList<>(webPOs.size());
		for(OrderOnWebPO webPO : webPOs){
			webVOs.add((OrderOnWebVO)VOPOchange.POtoVO(webPO));
		}
		
		return webVOs;
	}
	
	/**
	 * 网站营销人员处理申诉
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
	 */
	public ResultMsg complaintHandle(OrderOnWebVO orderVO){
		OrderOnWebPO order = (OrderOnWebPO)VOPOchange.VOtoPO(orderVO);
		if(order.getPass()){
			order.setOrderState(OrderState.UNEXECUTED);
			//TODO order.getInitiator().setCredit(order.getPrice());
			return new ResultMsg(true, "处理成功！");
		}else{
			order.setOrderState(OrderState.CANCELLED);
			return new ResultMsg(false, "撤销该订单!");
		}
	}
	
	/**
	 * 网站营销人员查看异常订单列表
	 *
	 * @param void
	 * @return 异常订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderOnWebVO> abnormalOrderScan() throws RemoteException {
		ArrayList<OrderOnWebVO> webVOs;
		ArrayList<OrderOnWebPO> webPOs;
		
		webPOs = webDataService.getAbnormalList();
		
		if(webPOs == null || webPOs.isEmpty()) {
			return null;
		}
		
		webVOs = new ArrayList<>(webPOs.size());
		for(OrderOnWebPO webPO : webPOs){
			webVOs.add((OrderOnWebVO)VOPOchange.POtoVO(webPO));
		}
		
		return webVOs;
	}
	
	/**
	 * 网站营销人员查看异常订单详情
	 *
	 * @param orderVO 订单VO
	 * @return 个人订单详情
	 * @throws RemoteException 
	 */
	public OrderOnWebMsg abnormalOrderDetail(OrderOnWebVO orderVO) throws RemoteException{
		ArrayList<OrderOnWebPO> webPOs;
		webPOs = webDataService.getAbnormalList();
		
		for(OrderOnWebPO webPO : webPOs) {
			if(webPO.getOrderID().equals(orderVO.getOrderID()))
				return new OrderOnWebMsg(webPO.getInitiator(),webPO.getOrderID(),
						webPO.getOrderState(),webPO.getPrice(),webPO.getReason());
		}
		return null;
	}

}
