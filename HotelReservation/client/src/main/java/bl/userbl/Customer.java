package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.hotelbl.HotelEvaluateController;
import bl.hotelbl.HotelReserveController;
import bl.hotelbl.HotelSearchController;
import bl.VOPOchange;
import bl.creditbl.CreditController;
import bl.orderbl.OrderOnUser;
import data.userdata.CustomerManagementDataServiceImpl;
import data.userdata.UserManagementDataServiceImpl;
import dataservice.orderdataservice.OrderDataService;
import po.ContactPO;
import po.CustomerInfoPO;
import po.UserInfoPO;
import vo.CustomerInfoVO;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.CreditVO;
import vo.OrderVO;
import vo.UserInfoVO;
import vo.VipVO;

public class Customer extends User {
	private HotelSearchController hotel;
	private HotelInfoVO cond;
	private HotelReserveController reserve;
	private HotelEvaluateController eval;
	private OrderOnUser order;
	
	private UserInfoVO userInfoVO;
	private ArrayList<OrderVO> orderVOs;
	private ArrayList<HotelInfoVO> hotelInfoVOs;
	private ArrayList<String> orderID;
	private ArrayList<String> hotelID;
	private CreditVO integralVO;
	private UserManagementDataServiceImpl usermanage;
	private CustomerManagementDataServiceImpl customermanage;
	private CreditController integral;
	private OrderDataService orderDataService;
	
	/**
	 * ���췽��
	 * @param �û�ID
	 */
	public Customer(String userID){
		hotel=new HotelSearchController();
		reserve=new HotelReserveController();
		eval=new HotelEvaluateController();
		order=new OrderOnUser(orderDataService);
		
		usermanage=new UserManagementDataServiceImpl();
		customermanage=new CustomerManagementDataServiceImpl();
		integral=new CreditController();
		UserInfoPO userInfoPO = usermanage.GetUserBaseInfo(userID);
		userInfoVO = (UserInfoVO)VOPOchange.POtoVO(userInfoPO);
		orderID=customermanage.GetCustomerOrders(userID);
		hotelID=customermanage.GetCustomerHotel(userID);
	}
	
	/**
	 * ��������ľƵ������������ط��������ľƵ���ϢVO�б�
	 * @param ɸѡ����VO
	 * @return �Ƶ���ϢVO�б�
	 */
	public ArrayList<HotelInfoVO> HotelSearch(HotelInfoVO vo){
		cond=vo;
		return hotel.showList(cond);
	}		
	
	
	/**
	 * ��ĳһ�Ƶ����ɶ���
	 * @param �Ƶ�IDVO
	 * @param ����VO
	 *
	 */
	public void OederCreat(String hotelID,OrderVO vo2){
	    try {
			order.createOrder(vo2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
			

	/**
	 * ���۾Ƶ�	
	 * @param �Ƶ�����VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo){
		eval.inputEvaluate(vo);
	}
			
	
	/**
	 * �����Ա
	 * @param �Ƶ�IDVO
	 * @param ��Ա��ϢVO
	 */
	public void MemberRegisterApply(String hotelID,VipVO vo2){
		
	}

	/**
	 * ��ѯ���˻�����Ϣ
	 * @param userid
	 * @return ���˻�����Ϣ
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
		return userInfoVO;
	}
			
	/**
	 * �޸ĸ��˻�����Ϣ
	 * @param userid
	 * @param �ͻ�������Ϣ
	 * @return �޸Ľ��
	 */
	public boolean IndividualBaseInfoModification(String userid,CustomerInfoVO vo2){
		ContactPO contactPO = (ContactPO)VOPOchange.VOtoPO(vo2.getContact());
		CustomerInfoPO po2 = new CustomerInfoPO(vo2.getUserID(),vo2.getUsername(),contactPO,vo2.getCredit());
		return usermanage.SetUserBaseInfo(userid,po2);
	}
			
	/**
	 * ��ѯ���˶�����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid){
		return orderVOs;
	}
			
	/**
	 * ��ѯ���˾Ƶ���Ϣ
	 * @param userid
	 * @return ���˾Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(String userid){
		return hotelInfoVOs;
	}
			
	/**
	 * ��ѯ��������
	 * @param userid
	 * @return ����������Ϣ
	 */
	public CreditVO IndividualCredictInquiry(String userid){
		return 	integralVO;
	}
}
