package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.hotelbl.HotelEvaluateController;
import bl.hotelbl.HotelInfoCheckController;
import bl.hotelbl.HotelReserveController;
import bl.hotelbl.HotelSearchController;
import bl.VOPOchange;
import bl.creditbl.CreditController;
import bl.orderbl.OrderOnUserController;
import bl.vipbl.VipController;
import dataservice.userdataservice.CustomerManagementDataService;
import po.ContactPO;
import po.CustomerInfoPO;
import po.UserInfoPO;
import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.CreditVO;
import vo.OrderVO;
import vo.UserInfoVO;
/**
 * �ͻ���
 * @author �ܳ�
 *
 */
public class Customer extends User {
	private HotelSearchController hotel;
	private HotelEvaluateController eval;
	private UserInfoVO userInfoVO;
	private ArrayList<HotelInfoVO> hotelInfoVOs;
	private CreditController integral;
	private CustomerManagementDataService userdataservice;
	private OrderOnUserController order;
	private HotelInfoCheckController hotelinfo;
	private HotelReserveController reserve;
	private VipController vip;
	
	/**
	 * ���췽��
	 * @param �û�ID
	 */
	public Customer(CustomerManagementDataService userdataservice){
		super(userdataservice);
		hotel=new HotelSearchController();
		eval=new HotelEvaluateController();
		order=new OrderOnUserController();
		hotelinfo=new HotelInfoCheckController();
		this.userdataservice=userdataservice;
		integral=new CreditController();
		reserve=new HotelReserveController();
		try {
			vip=new VipController();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
	public ResultMsg OederCreat(String userid,OrderVO vo2)throws RemoteException{
	    ResultMsg r1=reserve.reserveHotel(vo2);
	    if(r1==ResultMsg.SUCCESS){
	    	order.createOrder(vo2);
	    	boolean r=userdataservice.addCustomerOrders(userid,vo2.getOrderID());
	    	boolean r2=userdataservice.addCustomerHotel(userid,vo2.getHotelID());
	    	if(r&&r2){
	    		return ResultMsg.SUCCESS;
	    	}
	    }
	    return ResultMsg.FAIL;
		
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
	public ResultMsg HotelMemberRegisterApply(VipType type,String pa,CustomerInfoVO vo)throws RemoteException{
		if(vo.getIsMember()){
			if(vo.getVipType()==type){
				return ResultMsg.FAIL;
			}
		}
		vo.setIsMember(true);
		vo.setVipType(type);
		ResultMsg resultMsg= vip.registerVip(vo,pa);
		if(resultMsg==ResultMsg.SUCCESS){
			boolean r=userdataservice.SetUserBaseInfo(vo.getUserID(),(UserInfoPO)VOPOchange.VOtoPO(vo));
			if(r){
				return ResultMsg.SUCCESS;
			}
		}
		return ResultMsg.FAIL;
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
		CustomerInfoPO po2 = new CustomerInfoPO(vo2.getUserID(),vo2.getUsername(),contactPO,vo2.getCredit(),vo2.getIsMember(),vo2.getVipType());
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
	public int IndividualCredictInquiry(String userid)throws RemoteException{
		return 	integral.getCredit((CustomerInfoVO)VOPOchange.POtoVO(userdataservice.GetUserBaseInfo(userid)));
	}
	
	
	/**
	 * ��ѯ�������ü�¼
	 * @param userid
	 * @return ����������Ϣ
	 */
	public ArrayList<CreditVO> IndividualCredictRecord(String userid)throws RemoteException{
		return 	integral.getCreditList(userid);
	}
	
	/**
	 * ɾ�����˶���
	 * @param orderVO
	 * @return
	 */
	public ResultMsg personalOrderCancel(OrderVO orderVO)throws RemoteException{
		return order.personalOrderCancel(orderVO);
	}
	
}
