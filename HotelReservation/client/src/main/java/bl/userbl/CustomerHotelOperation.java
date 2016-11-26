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
 * �ͻ��ԾƵ�Ĳ���
 * 
 * @author �ܳ�
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
	public void OederCreat(HotelInfoVO vo1,OrderOnUserVO vo2){
	    order.createOrder(vo2);
		
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
	public void MemberRegisterApply(HotelInfoVO vo1,VipVO vo2){
		
	}

}
