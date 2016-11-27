package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.CustomerHotelOperationBlService;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.VipVO;


/**
 * �ͻ��ԾƵ�Ĳ���
 * 
 * @author �ܳ�
 *
 */
public class CustomerHotelOperationController implements CustomerHotelOperationBlService {
	
	private Customer customer;
	
	public CustomerHotelOperationController(String userID){
		customer=new Customer(userID);
	}

	
	/**
	 * ��������ľƵ������������ط��������ľƵ���ϢVO�б�
	 * @param ɸѡ����VO
	 * @return �Ƶ���ϢVO�б�
	 */
	public ArrayList<HotelInfoVO> HotelSearch(HotelInfoVO vo){
		return customer.HotelSearch(vo);
	}		
	
	
	/**
	 * ��ĳһ�Ƶ����ɶ���
	 * @param �Ƶ�IDVO
	 * @param ����VO
	 *
	 */
	public void OederCreat(String hotelID,OrderVO vo2){
	   customer.OederCreat(hotelID, vo2);
		
	}
			

	/**
	 * ���۾Ƶ�	
	 * @param �Ƶ�����VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo){
		customer.HotelEvaluate(vo);
	}
			
	
	/**
	 * �����Ա
	 * @param �Ƶ�IDVO
	 * @param ��Ա��ϢVO
	 */
	public void MemberRegisterApply(String id,VipVO vo2){
		customer.MemberRegisterApply(id, vo2);
	}


}
