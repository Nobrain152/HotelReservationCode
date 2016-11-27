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
	 * 构造方法
	 * @param 用户ID
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
	 * 根据输入的酒店搜索条件返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public ArrayList<HotelInfoVO> HotelSearch(HotelInfoVO vo){
		cond=vo;
		return hotel.showList(cond);
	}		
	
	
	/**
	 * 对某一酒店生成订单
	 * @param 酒店IDVO
	 * @param 订单VO
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
	 * 评价酒店	
	 * @param 酒店评价VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo){
		eval.inputEvaluate(vo);
	}
			
	
	/**
	 * 申请会员
	 * @param 酒店IDVO
	 * @param 会员信息VO
	 */
	public void MemberRegisterApply(String hotelID,VipVO vo2){
		
	}

	/**
	 * 查询个人基本信息
	 * @param userid
	 * @return 个人基本信息
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
		return userInfoVO;
	}
			
	/**
	 * 修改个人基本信息
	 * @param userid
	 * @param 客户基本信息
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(String userid,CustomerInfoVO vo2){
		ContactPO contactPO = (ContactPO)VOPOchange.VOtoPO(vo2.getContact());
		CustomerInfoPO po2 = new CustomerInfoPO(vo2.getUserID(),vo2.getUsername(),contactPO,vo2.getCredit());
		return usermanage.SetUserBaseInfo(userid,po2);
	}
			
	/**
	 * 查询个人订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid){
		return orderVOs;
	}
			
	/**
	 * 查询个人酒店信息
	 * @param userid
	 * @return 个人酒店信息列表
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(String userid){
		return hotelInfoVOs;
	}
			
	/**
	 * 查询个人信用
	 * @param userid
	 * @return 个人信用信息
	 */
	public CreditVO IndividualCredictInquiry(String userid){
		return 	integralVO;
	}
}
