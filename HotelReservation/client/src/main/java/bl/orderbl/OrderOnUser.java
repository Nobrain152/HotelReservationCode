
package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import bl.VOPOchange;
import bl.creditbl.CreditController;
import bl.promotionbl.PromotionValueController;
import dataservice.creditdataservice.CreditDataService;
import dataservice.orderdataservice.OrderDataService;
import po.CreditPO;
import po.CustomerInfoPO;
import po.OrderPO;
import util.Action;
import util.OrderState;
import util.PromotionHotelType;
import util.PromotionWebType;
import util.ResultMsg;
import util.Today;
import util.VipType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class OrderOnUser {
	
	private OrderDataService userDataService;
	private CreditDataService creditDataService;
	
	public OrderOnUser(OrderDataService userDataService,CreditDataService creditDataService) {
		this.userDataService = userDataService;
		this.creditDataService = creditDataService;
	}
	
	/**
	 * �ͻ��鿴���˶�����Ϣ
	 *
	 * @param ID
	 * @return ���˶����б�
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> personalOrderScan(String ID) throws RemoteException {
		ArrayList<OrderVO> userVOs = new ArrayList<OrderVO>();
		ArrayList<OrderPO> userPOs;
		
		userPOs = userDataService.findByUserID(ID);
		if(userPOs == null || userPOs.isEmpty()) {
			return null;
		}
		
		userVOs = new ArrayList<OrderVO>(userPOs.size());
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
		
		CustomerInfoPO customerInfoPO = (CustomerInfoPO)VOPOchange.VOtoPO(orderVO.getInitiator());
		
		if(customerInfoPO.getCredit() > 0){
			
			CustomerInfoVO customerInfoVO = orderVO.getInitiator();
			if(customerInfoVO.getIsMember()) {
				
				VipType vipType = customerInfoVO.getVipType();
				double[] price = new double[6];
				PromotionValueController pro = new PromotionValueController();
				
				if(vipType == VipType.COMMON_VIP) {
					
					price[0] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.BIRTH_PROMOTION).getPrice();
					price[1] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.HOTEL_CUSTOM_PROMOTION).getPrice();
					price[3] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.OVERTHREE_PROMOTION).getPrice();
					price[4] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.VIP_CIRCLE_PROMOTION).getPrice();
					price[5] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.VIP_LEVEL_PROMOTION).getPrice();
					price[2] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.WEB_CUSTOM_PROMOTION).getPrice();
					
				} else if(vipType == VipType.COMPANY_VIP) {
					
					price[1] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.HOTEL_CUSTOM_PROMOTION).getPrice();
					price[2] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.JOIN_PROMOTION).getPrice();
					price[4] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.VIP_CIRCLE_PROMOTION).getPrice();
					price[3] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.OVERTHREE_PROMOTION).getPrice();
					price[5] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.VIP_LEVEL_PROMOTION).getPrice();
					price[2] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.WEB_CUSTOM_PROMOTION).getPrice();
				}
				
				double min = 0;
				for(int i = 0; i < price.length; i++) {
					if(price[i] < min) {
						min = price[i];
					}
				}
				orderVO.setPrice(min);
				
			}
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
		
		if(orderOnUserPO == null) {
			return ResultMsg.NOT_EXIST;
		}
		
		if(orderOnUserPO.getOrderState() == OrderState.UNEXECUTED) {
			
			//�޸Ķ���״̬
			orderOnUserPO.setOrderState(OrderState.CANCELLED);
			//��¼����ʱ��
			String today = new Today().getToday();
			orderOnUserPO.setCancelledTime(today);
			resultMsg = userDataService.update(orderOnUserPO);
			
			//��������Ķ�����������ִ��ʱ�䲻��6��Сʱ���۳�����ֵ��������ֵ��1/2��������creditPO״̬ΪCancelled
			String lastTime = orderOnUserPO.getLatestExecutionTime();
			if(lastTime.compareTo(today) >= 0 && resultMsg == ResultMsg.SUCCESS) {
				int lastTimeYear = Integer.parseInt(lastTime.substring(0, 4));
				int lastTimeMonth = Integer.parseInt(lastTime.substring(5, 7));
				int lastTimeDay = Integer.parseInt(lastTime.substring(8, 10));
				int lastTimeHour = Integer.parseInt(lastTime.substring(11, 13));
				int lastTimeMin = Integer.parseInt(lastTime.substring(14));
				int todayYear = Integer.parseInt(today.substring(0, 4));
				int todayMonth = Integer.parseInt(today.substring(5, 7));
				int todayDay = Integer.parseInt(today.substring(8, 10));
				int todayHour = Integer.parseInt(today.substring(11, 13));
				int todayMin = Integer.parseInt(today.substring(14));
				Calendar lastCalendar = Calendar.getInstance();
				Calendar todayCalendar = Calendar.getInstance();
				lastCalendar.set(lastTimeYear, lastTimeMonth-1, lastTimeDay, lastTimeHour, lastTimeMin);
				todayCalendar.set(todayYear, todayMonth, todayDay, todayHour, todayMin);
				if(lastCalendar.getTimeInMillis()-todayCalendar.getTimeInMillis() <= 6*60*60*1000) {
					CreditController controller = new CreditController();
					controller.subCredit(orderVO.getInitiator(), (int)orderOnUserPO.getPrice()/2);
					CreditPO creditPO = creditDataService.findByUserID(orderOnUserPO.getInitiator().getUserID());
					creditPO.setAction(Action.Cancelled);
					resultMsg = creditDataService.insert(creditPO);
				}
			}
			
		}else{
			resultMsg = ResultMsg.FAIL;
		}
		
		return resultMsg;
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
