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
	 * 构造方法
	 * @param 用户ID
	 */
	public Customer(CustomerManagementDataService userdataservice){
		hotel=new HotelSearchController();
		eval=new HotelEvaluateController();
		order=new OrderOnUserController();
		hotelinfo=new HotelInfoCheckController();
		this.userdataservice=userdataservice;
	}
	
	/**
	 * 根据输入的酒店搜索条件返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public ArrayList<HotelInfoVO> HotelSearch(HotelInfoVO vo)throws RemoteException{
		return hotel.selectCondition(vo);
	}		
	
	
	/**
	 * 对某一酒店生成订单
	 * @param 酒店IDVO
	 * @param 订单VO
	 *
	 */
	public void OederCreat(String hotelID,OrderVO vo2)throws RemoteException{
	    
			order.createOrder(vo2);
		
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
	public void HotelMemberRegisterApply(String hotelID,VipVO vo2)throws RemoteException{
		
	}
	
	
	/**
	 * 申请网站会员
	 * @param 会员信息VO
	 */
	public void WebMemberRegisterApply(VipVO vo2)throws RemoteException{
		
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
	public boolean IndividualBaseInfoModification(String userid,CustomerInfoVO vo2)throws RemoteException{
		ContactPO contactPO = (ContactPO)VOPOchange.VOtoPO(vo2.getContact());
		CustomerInfoPO po2 = new CustomerInfoPO(vo2.getUserID(),vo2.getUsername(),contactPO,vo2.getCredit());
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
	 * 查询个人信用
	 * @param userid
	 * @return 个人信用信息
	 */
	public CreditVO IndividualCredictInquiry(String userid)throws RemoteException{
		return 	integralVO;
	}
}
