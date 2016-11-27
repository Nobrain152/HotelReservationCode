
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
	 * �ͻ��鿴���˶�����Ϣ
	 *
	 * @param ID
	 * @return ���˶����б�
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
	 * �ͻ���������
	 *
	 * @param ���˶���
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
	 * �ͻ��������˶���
	 *
	 * @param orderVO ����VO
	 * @return ϵͳ��ʾ��Ϣ
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
	 * �ͻ��鿴���˶�������
	 *
	 * @param String ����ID
	 * @return ���˶�������
	 * @throws RemoteException 
	 */
	public OrderVO personalOrderDetail(String ID) throws RemoteException {
		OrderPO userPO = userDataService.findByOrderID(ID);
		return (OrderVO)VOPOchange.POtoVO(userPO);
	}

}
