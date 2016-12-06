package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;


import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import blservice.creditblservice.CreditBLService;
import blservice.hotelblservice.HotelEvaluateBLService;
import blservice.hotelblservice.HotelInfoCheckBLService;
import blservice.hotelblservice.HotelReserveBLService;
import blservice.hotelblservice.HotelSearchBLService;
import blservice.orderblservice.OrderOnUserBLService;
import blservice.vipblservice.VipLevelBLService;
import dataservice.userdataservice.CustomerManagementDataService;
import po.ContactPO;
import po.CustomerInfoPO;
import po.UserInfoPO;
import util.OrderState;
import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.CreditVO;
import vo.OrderVO;
import vo.RoomInfoVO;
import vo.UserInfoVO;
/**
 * �ͻ���
 * @author �ܳ�
 *
 */
public class Customer extends User {
	private HotelSearchBLService hotel;
	private HotelEvaluateBLService eval;
	private UserInfoVO userInfoVO;
	private ArrayList<HotelInfoVO> hotelInfoVOs;
	private CreditBLService integral;
	private CustomerManagementDataService userdataservice;
	private OrderOnUserBLService order;
	private HotelInfoCheckBLService hotelinfo;
	private HotelReserveBLService reserve;
	private VipLevelBLService vip;
	private BusinessLogicDataFactory factory;
	
	/**
	 * ���췽��
	 * @param �û�ID
	 */
	public Customer(CustomerManagementDataService userdataservice){
		super(userdataservice);
		factory=BusinessLogicDataFactory.getFactory();
		hotel=factory.getHotelSearchBLService();
		eval=factory.getHotelEvaluateBLService();
		order=factory.getOrderOnUserBLService();
		hotelinfo=factory.getHotelInfoCheckBLService();
		this.userdataservice=userdataservice;
		integral=factory.getCreditBLService();
		reserve=factory.getHotelReserveBLService();
		vip=factory.getVipLevelBLService();
	}
	
	/**
	 * ��������ľƵ������������ط��������ľƵ���ϢVO�б�
	 * @param ɸѡ����VO
	 * @return �Ƶ���ϢVO�б�
	 */
	public ArrayList<HotelInfoVO> HotelSearch(RoomInfoVO vo1,HotelInfoVO vo,String userid)throws RemoteException{
		ArrayList<HotelInfoVO> hotelInfoVOs= hotel.selectCondition(vo,vo1);
		ArrayList<OrderVO> ord=this.IndividualOrderInquiry(userid);
		for(HotelInfoVO v:hotelInfoVOs){
			String hotelid=v.getHotelID();
			ArrayList<OrderVO> hotelorder=new ArrayList<OrderVO>();
			for(OrderVO v1:ord){
				if(hotelid.equals(v1.hotelID)){
					hotelorder.add(v1);
				}
			}
			v.setOrder(hotelorder);
		}
		return hotelInfoVOs;
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
			return userdataservice.SetUserBaseInfo(vo.getUserID(),(UserInfoPO)VOPOchange.VOtoPO(vo));
			
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
	public ResultMsg IndividualBaseInfoModification(String userid,CustomerInfoVO vo2)throws RemoteException{
		CustomerInfoPO past=(CustomerInfoPO) userdataservice.GetUserBaseInfo(userid);
		if((past.getIsMember()!=vo2.getIsMember())||(past.getCredit()!=vo2.getCredit())||(!past.getUserID().equals(vo2.getUserID())||(past.getVipType()!=vo2.getVipType()))){
			return ResultMsg.UNAUYHORIZED;
		}
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
	 * ��ѯ����ĳһ�ඩ����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> SpecialOrderInquiry(String userid,OrderState state)throws RemoteException{
		ArrayList<OrderVO> all= order.personalOrderScan(userid);
		ArrayList<OrderVO> special=new ArrayList<OrderVO>();
		for(OrderVO vo:all){
			if(vo.getOrderState()==state){
				special.add(vo);
			}
		}
		return special;
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
	 * ��ѯ����ĳһ��Ƶ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> SpecialHotelInquiry(String userid,OrderState state)throws RemoteException{
		ArrayList<OrderVO> special=SpecialOrderInquiry(userid, state);
		ArrayList<HotelInfoVO> hvo=new ArrayList<HotelInfoVO>();
		for(OrderVO vo:special){
			hvo.add(hotelinfo.checkHotelInfo(vo.getHotelID()));
		}
		return hvo;
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
