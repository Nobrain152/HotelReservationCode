package bl.userbl;

import java.util.ArrayList;

import bl.hotelbl.HotelEvaluateController;
import bl.hotelbl.HotelReserveController;
import bl.hotelbl.HotelSearchController;
import bl.orderbl.OrderOnUserController;
import blservice.userblservice.CustomerHotelOperationBlService;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderOnUserVO;
import vo.VipVO;


/**
 * 客户对酒店的操作
 * 
 * @author 曹畅
 *
 */
public class CustomerHotelOperation {
	String userID;
	HotelSearchController hotel;
	HotelInfoVO cond;
	HotelReserveController reserve;
	HotelEvaluateController eval;
	OrderOnUserController order;
	
	public CustomerHotelOperation(String userID){
		this.userID=userID;
		hotel=new HotelSearchController();
		reserve=new HotelReserveController();
		eval=new HotelEvaluateController();
		order=new OrderOnUserController();
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
	public void OederCreat(HotelInfoVO vo1,OrderOnUserVO vo2){
	    order.createOrder(vo2);
		
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
	public void MemberRegisterApply(HotelInfoVO vo1,VipVO vo2){
		
	}

}
