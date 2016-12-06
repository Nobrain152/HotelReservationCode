package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.CustomerHotelOperationBlService;
import dataservice.userdataservice.CustomerManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;


/**
 * �ͻ��ԾƵ�Ĳ���
 * 
 * @author �ܳ�
 *
 */
public class CustomerHotelOperationController implements CustomerHotelOperationBlService {
	
	private Customer customer;
	private CustomerManagementDataService customerManagementDataService;
	
	public CustomerHotelOperationController(){
		customerManagementDataService = (CustomerManagementDataService)RMIManage.
				getDataService(DataServiceType.CustomerManagementDataService);
		customer=new Customer(customerManagementDataService);
	}

	
	/**
	 * ��������ľƵ������������ط��������ľƵ���ϢVO�б�
	 * @param ɸѡ����VO
	 * @return �Ƶ���ϢVO�б�
	 */
	public ArrayList<HotelInfoVO> HotelSearch(RoomInfoVO vo1,HotelInfoVO vo,String userid){
		try {
			return customer.HotelSearch(vo1,vo,userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
	}		
	
	
	/**
	 * ��ĳһ�Ƶ����ɶ���
	 * @param �Ƶ�IDVO
	 * @param ����VO
	 *
	 */
	public ResultMsg OederCreat(String hotelID,OrderVO vo2){
	   try {
		return customer.OederCreat(hotelID, vo2);
	} catch (RemoteException e) {
		e.printStackTrace();
		return ResultMsg.FAIL;
	}
		
	}
			

	/**
	 * ���۾Ƶ�	
	 * @param �Ƶ�����VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo){
		try {
			customer.HotelEvaluate(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
			
	
	/**
	 * ����Ƶ��Ա
	 * @param �Ƶ�IDVO
	 * @param ��Ա��ϢVO
	 */
	public ResultMsg HotelMemberRegisterApply(VipType type,String pa,CustomerInfoVO vo){
		try {
			return customer.HotelMemberRegisterApply(type,pa, vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
	
	

}
