package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.orderdataservice.OrderOnUserDataService;
import po.OrderOnUserPO;
import util.OrderOnUserMsg;
import util.OrderState;
import util.ResultMsg;
import vo.OrderOnUserVO;

public class OrderOnUser {
	
	private OrderOnUserDataService userDataService;
	
	/**
	 * 客户查看个人订单信息
	 *
	 * @param void
	 * @return 个人订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderOnUserVO> personalOrderScan() throws RemoteException {
		ArrayList<OrderOnUserVO> userVOs = new ArrayList<>();
		ArrayList<OrderOnUserPO> userPOs;
		
		userPOs = userDataService.show();
		if(userPOs == null || userPOs.isEmpty()) {
			return null;
		}
		
		userVOs = new ArrayList<>(userPOs.size());
		for(OrderOnUserPO userPO : userPOs) {
			userVOs.add((OrderOnUserVO)VOPOchange.POtoVO(userPO));
		}
		return userVOs;
	}
	
	/**
	 * 客户创建订单
	 *
	 * @param 个人订单
	 * @return void
	 * @throws RemoteException 
	 */
	public void createOrder(OrderOnUserVO orderVO) throws RemoteException {
		userDataService.insert((OrderOnUserPO)VOPOchange.VOtoPO(orderVO));
	}
	
	/**
	 * 客户撤销个人订单
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
	 * @throws RemoteException 
	 */
	public ResultMsg personalOrderCancel(OrderOnUserVO orderVO) throws RemoteException {
		
		OrderOnUserPO orderOnUserPO = userDataService.findByID(orderVO.getOrderID());
		ResultMsg resultMsg;
		if(orderOnUserPO.getOrderState() == OrderState.UNEXECUTED) {
			orderOnUserPO.setOrderState(OrderState.CANCELLED);
			resultMsg = userDataService.update(orderOnUserPO);
			return resultMsg;
		}else{
			resultMsg = ResultMsg.FAIL;
			return resultMsg;
		}
	}
	
	/**
	 * 客户查看个人订单详情
	 *
	 * @param orderVO 订单VO
	 * @return 个人订单详情
	 * @throws RemoteException 
	 */
	public OrderOnUserMsg personalOrderDetail(OrderOnUserVO orderVO) throws RemoteException {
		OrderOnUserPO order = userDataService.findByID(orderVO.getOrderID());
		return new OrderOnUserMsg(order.getInitiator(), order.getOrderID(),order.getOrderState(), order.getPrice(), order.getLatestExecutionTime(), 
				order.getRoomType(), order.getRoomNumber(), order.getPeopleNumber(), order.getHasChild());
	}

}
