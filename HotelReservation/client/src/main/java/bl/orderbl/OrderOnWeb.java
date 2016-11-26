package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

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
	 * ��վӪ����Ա�鿴�����б�
	 *
	 * @param void
	 * @return �����б�
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
	 * ��վӪ����Ա��������
	 *
	 * @param orderVO ����VO
	 * @return ϵͳ��ʾ��Ϣ
	 * @throws RemoteException 
	 */
	public ResultMsg complaintHandle(OrderOnWebVO orderVO) throws RemoteException{
		OrderOnWebPO order = (OrderOnWebPO)VOPOchange.VOtoPO(orderVO);
		ResultMsg resultMsg;
		if(order.getPass()){
			order.setOrderState(OrderState.UNEXECUTED);
			resultMsg = webDataService.update(order);
			//TODO order.getInitiator().add(order.getPrice());
			return resultMsg;
		}else{
			order.setOrderState(OrderState.CANCELLED);
			resultMsg = webDataService.update(order);
			return resultMsg;
		}
	}
	
	/**
	 * ��վӪ����Ա�鿴�쳣�����б�
	 *
	 * @param void
	 * @return �쳣�����б�
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
	 * ��վӪ����Ա�鿴�쳣��������
	 *
	 * @param orderVO ����VO
	 * @return ���˶�������
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
