
package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.orderdataservice.OrderDataService;
import po.CustomerInfoPO;
import po.OrderPO;
import util.OrderState;
import util.ResultMsg;
import vo.OrderVO;

public class OrderOnUser {
	
	private OrderDataService userDataService;
	
	public OrderOnUser(OrderDataService userDataService) {
		this.userDataService = userDataService;
	}
	
	/**
	 * 客户查看个人订单信息
	 *
	 * @param ID
	 * @return 个人订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> personalOrderScan(String ID) throws RemoteException {
		ArrayList<OrderVO> userVOs = new ArrayList<>();
		ArrayList<OrderPO> userPOs;
		
		userPOs = userDataService.findByUserID(ID);
		if(userPOs == null || userPOs.isEmpty()) {
			return null;
		}
		
		userVOs = new ArrayList<>(userPOs.size());
		for(OrderPO userPO : userPOs) {
			userVOs.add((OrderVO)VOPOchange.POtoVO(userPO));
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
	public ResultMsg createOrder(OrderVO orderVO) throws RemoteException {
		OrderPO orderPO = userDataService.findByOrderID(orderVO.getOrderID());
		CustomerInfoPO customerInfoPO = orderPO.getInitiator();
		if(customerInfoPO.getCredit() > 0){
			userDataService.insert((OrderPO)VOPOchange.VOtoPO(orderVO));
			return ResultMsg.SUCCESS;
		}else{
			return ResultMsg.FAIL;
		}
		
	}
	
	/**
	 * 客户撤销个人订单
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
	 * @throws RemoteException 
	 */
	public ResultMsg personalOrderCancel(OrderVO orderVO) throws RemoteException {
		OrderPO orderOnUserPO = userDataService.findByOrderID(orderVO.getOrderID());
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
	 * @param String 订单ID
	 * @return 个人订单详情
	 * @throws RemoteException 
	 */
	public OrderVO personalOrderDetail(String ID) throws RemoteException {
		OrderPO userPO = userDataService.findByOrderID(ID);
		return (OrderVO)VOPOchange.POtoVO(userPO);
	}

}
