package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.hotelbl.HotelEvaluateController;
import bl.hotelbl.HotelInfoCheckController;
import bl.hotelbl.HotelSearchController;
import bl.VOPOchange;
import bl.orderbl.OrderOnUserController;
import dataservice.userdataservice.CustomerManagementDataService;
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
	private HotelEvaluateController eval;
	private UserInfoVO userInfoVO;
	private ArrayList<HotelInfoVO> hotelInfoVOs;
	private CreditVO integralVO;
	private CustomerManagementDataService userdataservice;
	private OrderOnUserController order;
	private HotelInfoCheckController hotelinfo;
	
	/**
	 * ���췽��
	 * @param �û�ID
	 */
	public Customer(CustomerManagementDataService userdataservice){
		hotel=new HotelSearchController();
		eval=new HotelEvaluateController();
		order=new OrderOnUserController();
		hotelinfo=new HotelInfoCheckController();
		this.userdataservice=userdataservice;
	}
	
	/**
	 * ��������ľƵ������������ط��������ľƵ���ϢVO�б�
	 * @param ɸѡ����VO
	 * @return �Ƶ���ϢVO�б�
	 */
	public ArrayList<HotelInfoVO> HotelSearch(HotelInfoVO vo)throws RemoteException{
		return hotel.selectCondition(vo);
	}		
	
	
	/**
	 * ��ĳһ�Ƶ����ɶ���
	 * @param �Ƶ�IDVO
	 * @param ����VO
	 *
	 */
	public void OederCreat(String hotelID,OrderVO vo2)throws RemoteException{
	    
			order.createOrder(vo2);
		
	}
			

	/**
	 * ���۾Ƶ�	
	 * @param �Ƶ�����VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo)throws RemoteException{
		eval.inputEvaluate(vo);
	}
			
	
	/**
	 * ����Ƶ��Ա
	 * @param �Ƶ�IDVO
	 * @param ��Ա��ϢVO
	 */
	public void HotelMemberRegisterApply(String hotelID,VipVO vo2)throws RemoteException{
		
	}
	
	
	/**
	 * ������վ��Ա
	 * @param ��Ա��ϢVO
	 */
	public void WebMemberRegisterApply(VipVO vo2)throws RemoteException{
		
	}

	/**
	 * ��ѯ���˻�����Ϣ
	 * @param userid
	 * @return ���˻�����Ϣ
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		UserInfoPO userInfoPO = userdataservice.GetUserBaseInfo(userid);
		userInfoVO = (UserInfoVO)VOPOchange.POtoVO(userInfoPO);
		return userInfoVO;
	}
			
	/**
	 * �޸ĸ��˻�����Ϣ
	 * @param userid
	 * @param �ͻ�������Ϣ
	 * @return �޸Ľ��
	 */
	public boolean IndividualBaseInfoModification(String userid,CustomerInfoVO vo2)throws RemoteException{
		ContactPO contactPO = (ContactPO)VOPOchange.VOtoPO(vo2.getContact());
		CustomerInfoPO po2 = new CustomerInfoPO(vo2.getUserID(),vo2.getUsername(),contactPO,vo2.getCredit());
		return userdataservice.SetUserBaseInfo(userid,po2);
	}
			
	/**
	 * ��ѯ���˶�����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid)throws RemoteException{
		return order.personalOrderScan(userid);
	}
			
	/**
	 * ��ѯ���˾Ƶ���Ϣ
	 * @param userid
	 * @return ���˾Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(String userid)throws RemoteException{
		ArrayList<String> hotel=userdataservice.GetCustomerHotel(userid);
		for(int i=0;i<hotel.size();i++){
			hotelInfoVOs.add(hotelinfo.checkHotelInfo(hotel.get(i)));
		}
		return hotelInfoVOs;
	}
			
	/**
	 * ��ѯ��������
	 * @param userid
	 * @return ����������Ϣ
	 */
	public CreditVO IndividualCredictInquiry(String userid)throws RemoteException{
		return 	integralVO;
	}
}
