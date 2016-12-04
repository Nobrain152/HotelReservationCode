package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import bl.creditbl.CreditController;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import util.OrderState;
import util.ResultMsg;
import util.Today;
import vo.OrderVO;

public class OrderOnWeb {
	
	private OrderDataService webDataService;
	
	public OrderOnWeb(OrderDataService webDataService) {
		this.webDataService = webDataService;
	}
	
	/**
	 * ��վӪ����Ա�鿴�����б�
	 *
	 * @param void
	 * @return �����б�
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> complaintListScan() throws RemoteException {
		ArrayList<OrderVO> webVOs;
		ArrayList<OrderPO> webPOs;
		webPOs = webDataService.showList();
		
		if(webPOs == null || webPOs.isEmpty()) {
			return null;
		}
		
		webVOs = new ArrayList<OrderVO>();
		for(OrderPO webPO : webPOs){
			if(webPO.getReason() != null)
				webVOs.add((OrderVO)VOPOchange.POtoVO(webPO));
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
	public ResultMsg complaintHandle(OrderVO orderVO,double rate) throws RemoteException{
		OrderPO order = (OrderPO)VOPOchange.VOtoPO(orderVO);
		ResultMsg resultMsg;
		if(order.getPass()){
			order.setOrderState(OrderState.CANCELLED);
			CreditController controller = new CreditController();
			controller.addCredit(orderVO.getInitiator(), (int)(order.getPrice()*rate));
			order.setCancelledTime(new Today().getToday());
		}
		resultMsg = webDataService.update(order);
		return resultMsg;
	}
	
	/**
	 * ��վӪ����Ա�鿴�쳣�����б�
	 *
	 * @param void
	 * @return �쳣�����б�
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
	 * ���ÿ��δִ�ж���
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
	 * ��վӪ����Ա�鿴�쳣��������
	 *
	 * @param String ����ID
	 * @return ���˶�������
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
