
package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.orderdataservice.OrderOnUserDataService;
import po.OrderOnUserPO;
import util.OrderState;
import util.ResultMsg;
import vo.OrderOnUserVO;

public class OrderOnUser {
	
	private OrderOnUserDataService userDataService;
	
	public OrderOnUser(OrderOnUserDataService userDataService) {
		this.userDataService = userDataService;
	}
	
	/**
	 * �ͻ��鿴���˶�����Ϣ
	 *
	 * @param void
	 * @return ���˶����б�
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
	 * �ͻ���������
	 *
	 * @param ���˶���
	 * @return void
	 * @throws RemoteException 
	 */
	public void createOrder(OrderOnUserVO orderVO) throws RemoteException {
		userDataService.insert((OrderOnUserPO)VOPOchange.VOtoPO(orderVO));
	}
	
	/**
	 * �ͻ��������˶���
	 *
	 * @param orderVO ����VO
	 * @return ϵͳ��ʾ��Ϣ
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
	 * �ͻ��鿴���˶�������
	 *
	 * @param String ����ID
	 * @return ���˶�������
	 * @throws RemoteException 
	 */
	public OrderOnUserVO personalOrderDetail(String ID) throws RemoteException {
		ArrayList<OrderOnUserPO> userPOs = userDataService.show();
		for(OrderOnUserPO userPO : userPOs) {
			if(userPO.getOrderID().equals(ID))
				return (OrderOnUserVO)VOPOchange.POtoVO(userPO);
		}
		return null;
	}

}
