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
 * 客户类
 * @author 曹畅
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
	 * 构造方法
	 * @param 用户ID
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
	 * 根据输入的酒店搜索条件返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
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
	 * 对某一酒店生成订单
	 * @param 酒店IDVO
	 * @param 订单VO
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
	 * 评价酒店	
	 * @param 酒店评价VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo)throws RemoteException{
		eval.inputEvaluate(vo);
	}
			
	
	/**
	 * 申请酒店会员
	 * @param 酒店IDVO
	 * @param 会员信息VO
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
	 * 查询个人基本信息
	 * @param userid
	 * @return 个人基本信息
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		UserInfoPO userInfoPO = userdataservice.GetUserBaseInfo(userid);
		userInfoVO = (UserInfoVO)VOPOchange.POtoVO(userInfoPO);
		return userInfoVO;
	}
			
	/**
	 * 修改个人基本信息
	 * @param userid
	 * @param 客户基本信息
	 * @return 修改结果
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
	 * 查询个人订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid)throws RemoteException{
		return order.personalOrderScan(userid);
	}
	
	/**
	 * 查询个人某一类订单信息
	 * @param userid
	 * @return 个人订单列表
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
	 * 查询个人酒店信息
	 * @param userid
	 * @return 个人酒店信息列表
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(String userid)throws RemoteException{
		ArrayList<String> hotel=userdataservice.GetCustomerHotel(userid);
		for(int i=0;i<hotel.size();i++){
			hotelInfoVOs.add(hotelinfo.checkHotelInfo(hotel.get(i)));
		}
		return hotelInfoVOs;
	}
	
	/**
	 * 查询个人某一类酒店信息
	 * @param userid
	 * @return 个人订单列表
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
	 * 查询个人信用
	 * @param userid
	 * @return 个人信用信息
	 */
	public int IndividualCredictInquiry(String userid)throws RemoteException{
		return 	integral.getCredit((CustomerInfoVO)VOPOchange.POtoVO(userdataservice.GetUserBaseInfo(userid)));
	}
	
	
	/**
	 * 查询个人信用记录
	 * @param userid
	 * @return 个人信用信息
	 */
	public ArrayList<CreditVO> IndividualCredictRecord(String userid)throws RemoteException{
		return 	integral.getCreditList(userid);
	}
	
	/**
	 * 撤销个人订单
	 * @param orderVO
	 * @return
	 */
	public ResultMsg personalOrderCancel(OrderVO orderVO)throws RemoteException{
		return order.personalOrderCancel(orderVO);
	}
	
	
	
}
