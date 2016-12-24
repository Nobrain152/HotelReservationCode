package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.creditbl.CreditController;
import dataservice.orderdataservice.OrderDataService;
import po.CreditPO;
import po.OrderPO;
import util.Action;
import util.OrderState;
import util.ResultMsg;
import util.Today;
import vo.OrderVO;

/**
 * ��վ��Ա�Զ�������ز���
 * @author txin15
 *
 */
public class OrderOnWeb {
	
	private OrderDataService webDataService;
	private CreditController credit;
	
	public OrderOnWeb(OrderDataService webDataService) {
		this.webDataService = webDataService;
	}
	
	/**
	 * ��վ��Ա�鿴�쳣�����б�
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
	 * ��վ��Ա���ÿ��δִ�ж���
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
			if(webPO.getOrderState() == OrderState.UNEXECUTED 
					&& webPO.getLatestExecutionTime().substring(0,10).equals(today.substring(0,10)))
				webVOs.add((OrderVO)VOPOchange.POtoVO(webPO));
		}
		
		return webVOs;
	}
	
	/**
	 * ��վ��Ա�鿴�쳣��������
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
	
	/**
	 * ��վӪ����Ա�����쳣������trueΪ�ָ�ȫ������ֵ��falseΪ�ָ�һ��
	 * @param ID
	 * @param b
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg abnormalOrderCancel(String ID,boolean b) throws RemoteException{
		ArrayList<OrderPO> webPOs;
		webPOs = webDataService.showList();
		ResultMsg resultMsg = ResultMsg.FAIL;
		for(OrderPO webPO : webPOs) {
			if(webPO.getOrderID().equals(ID)){
				OrderVO orderVO = (OrderVO)VOPOchange.POtoVO(webPO);
				credit = (CreditController)BusinessLogicDataFactory.getFactory().getCreditBLService();
				if(b){
					//�޸Ķ���״̬
					webPO.setOrderState(OrderState.CANCELLED);
					//��¼����ʱ��
					String today = new Today().getToday();
					webPO.setCancelledTime(today);
					resultMsg = webDataService.update(webPO);
					
					credit.addCredit(orderVO.getInitiator(), (int)webPO.getPrice());
					ArrayList<CreditPO> creditPOs = credit.getListByUserID(webPO.getInitiator().getUserID());
					CreditPO creditPO = creditPOs.get(creditPOs.size()-1);
					creditPO.setCreditChange("+"+(int)orderVO.getPrice());
					creditPO.setCreditResult(creditPO.getCreditResult()+(int)orderVO.getPrice());
					creditPO.setTime(new Today().getToday());
					creditPO.setAction(Action.Cancelled);
					resultMsg = credit.insert(creditPO);
				}else{
					//�޸Ķ���״̬
					webPO.setOrderState(OrderState.CANCELLED);
					//��¼����ʱ��
					String today = new Today().getToday();
					webPO.setCancelledTime(today);
					resultMsg = webDataService.update(webPO);
					
					CreditController controller = new CreditController();
					controller.addCredit(orderVO.getInitiator(), (int)webPO.getPrice()/2);
					ArrayList<CreditPO> creditPOs = credit.getListByUserID(webPO.getInitiator().getUserID());
					CreditPO creditPO = creditPOs.get(creditPOs.size()-1);
					creditPO.setCreditChange("+"+(int)orderVO.getPrice()/2);
					creditPO.setCreditResult(creditPO.getCreditResult()+(int)orderVO.getPrice()/2);
					creditPO.setTime(new Today().getToday());
					creditPO.setAction(Action.Cancelled);
					resultMsg = credit.insert(creditPO);
				}
				break;
			}
		}
		return resultMsg;
	}

}
