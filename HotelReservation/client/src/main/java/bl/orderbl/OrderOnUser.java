
package bl.orderbl;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.creditbl.CreditController;
import bl.promotionbl.PromotionValueController;
import bl.userbl.CustomerInfoManagementController;
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

/**
 * �ͻ��Զ�������ز���
 * @author txin15
 *
 */
public class OrderOnUser {
	
	private OrderDataService userDataService;
	private CreditController credit;
	private CustomerInfoManagementController customer;
	
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
		ArrayList<OrderVO> userVOs = new ArrayList<OrderVO>();
		ArrayList<OrderPO> userPOs;
		
		userPOs = userDataService.findByUserID(ID);
//		if(userPOs == null || userPOs.isEmpty()) {
//			return null;
//		}
		
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
	 * @return �����۸�;��������
	 * @throws RemoteException 
	 */
	public String createOrder(OrderVO orderVO) throws RemoteException {
		
		customer = (CustomerInfoManagementController)BusinessLogicDataFactory.getFactory().
				getCustomerIndividualInformationManagementBLService();
		CustomerInfoPO customerInfoPO = customer.getCustomerInfo(orderVO.getInitiator().getUserID());
		
		if(customerInfoPO.getCredit() >= 0){	//����ֵ���;ܾ����ɶ���
			CustomerInfoVO customerInfoVO = (CustomerInfoVO)VOPOchange.POtoVO(customerInfoPO);
			double min = orderVO.getPrice();
			PromotionWebType promotionWebType = null;
			PromotionHotelType promotionHotelType = null;
			
			if(customerInfoVO.getIsMember()) {
				
				VipType vipType = customerInfoVO.getVipType();
				double[] price = new double[6];
				PromotionValueController pro = new PromotionValueController();
				
				//����������Եõ��ļ۸�
				if(vipType == VipType.COMMON_VIP) {
					
					price[0] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.BIRTH_PROMOTION);
					price[1] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.HOTEL_CUSTOM_PROMOTION);
					price[3] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.OVERTHREE_PROMOTION);
					price[4] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.VIP_CIRCLE_PROMOTION);
					price[5] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.VIP_LEVEL_PROMOTION);
					price[2] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.WEB_CUSTOM_PROMOTION);
					
				} else if(vipType == VipType.COMPANY_VIP) {
					
					price[1] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.HOTEL_CUSTOM_PROMOTION);
					price[0] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.JOIN_PROMOTION);
					price[3] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.VIP_CIRCLE_PROMOTION);
					price[2] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.OVERTHREE_PROMOTION);
					price[4] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.VIP_LEVEL_PROMOTION);
					price[5] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.WEB_CUSTOM_PROMOTION);
				}
				
				//�õ���ͼ۸�
				int number = 0;
				for(int i = 0; i < price.length; i++) {
					if(price[i] < min) {
						min = price[i];
						number = i;
					}
				}
				
				//�ж���ͼ۸��Ӧ�Ĵ�������
				if(vipType == VipType.COMMON_VIP) {
					switch (number) {
					case 0:	promotionHotelType = PromotionHotelType.BIRTH_PROMOTION;	break;
					case 1:	promotionHotelType = PromotionHotelType.HOTEL_CUSTOM_PROMOTION;	break;
					case 3:	promotionHotelType = PromotionHotelType.OVERTHREE_PROMOTION;	break;
					case 4:	promotionWebType = PromotionWebType.VIP_CIRCLE_PROMOTION;	break;
					case 5:	promotionWebType = PromotionWebType.VIP_LEVEL_PROMOTION;	break;
					case 2: promotionWebType = PromotionWebType.WEB_CUSTOM_PROMOTION;	break;
					default:
						break;
					}
				}else if(vipType == VipType.COMPANY_VIP) {
					switch (number) {
					case 0:	promotionHotelType = PromotionHotelType.JOIN_PROMOTION;	break;
					case 1:	promotionHotelType = PromotionHotelType.HOTEL_CUSTOM_PROMOTION;	break;
					case 2:	promotionHotelType = PromotionHotelType.OVERTHREE_PROMOTION;	break;
					case 3:	promotionWebType = PromotionWebType.VIP_CIRCLE_PROMOTION;	break;
					case 4:	promotionWebType = PromotionWebType.VIP_LEVEL_PROMOTION;	break;
					case 5: promotionWebType = PromotionWebType.WEB_CUSTOM_PROMOTION;	break;
					default:
						break;
					}
				}
			}
			
			OrderPO orderPO = (OrderPO)VOPOchange.VOtoPO(orderVO);
			
			//��֤�۸�Ϊ��λС��
			DecimalFormat dFormat = new DecimalFormat("#.00");
			String price = dFormat.format(min);
			min = Double.valueOf(price);
			
			//�޸ļ۸������ݿ��в���
			orderPO.setPrice(min);
			orderPO.setLatestExecutionTime(orderPO.getCheckInTime().substring(0,10)+" 24:00");
			orderPO.setOrderState(OrderState.UNEXECUTED);
			
			userDataService.insert(orderPO);
			
			if(promotionHotelType == null && promotionWebType == null){
				return min + ";" + "δʹ�ô�������";
			}else if(promotionHotelType == null){
				return min + ";" + promotionWebType.toString();
			}else if(promotionWebType == null){
				return min + ";" + promotionHotelType.toString();
			}else{
				return null;
			}
			 
		}else{
			return null;
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
				todayCalendar.set(todayYear, todayMonth-1, todayDay, todayHour, todayMin);
				if(lastCalendar.getTimeInMillis()-todayCalendar.getTimeInMillis() <= 6*60*60*1000) {
					credit = (CreditController)BusinessLogicDataFactory.getFactory().getCreditBLService();
					CreditController controller = new CreditController();
					controller.subCredit(orderVO.getInitiator(), (int)orderOnUserPO.getPrice()/2);
					ArrayList<CreditPO> creditPOs = credit.getListByUserID(orderOnUserPO.getInitiator().getUserID());
					CreditPO creditPO = creditPOs.get(creditPOs.size()-1);
					creditPO.setCreditChange("-"+(int)orderVO.getPrice()/2);
					creditPO.setCreditResult(creditPO.getCreditResult()-(int)orderVO.getPrice()/2);
					creditPO.setTime(new Today().getToday());
					creditPO.setAction(Action.Cancelled);
					creditPO.setOrderID(orderVO.getOrderID());
					resultMsg = credit.insert(creditPO);
				}
			}else{
				
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
