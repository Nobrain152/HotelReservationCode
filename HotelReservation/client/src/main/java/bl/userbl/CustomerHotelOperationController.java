package bl.userbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
import blservice.userblservice.CustomerHotelOperationBlService;
import dataservice.userdataservice.CustomerManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import util.Sort;
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
public class CustomerHotelOperationController extends BusinessController implements CustomerHotelOperationBlService {
	
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
	public ArrayList<HotelInfoVO> hotelSearch(RoomInfoVO vo1,HotelInfoVO vo,String userid,boolean done){
		try {
			return customer.hotelSearch(vo1,vo,userid,done);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * ��������ľƵ�ID���û�ID���ط��������ľƵ���ϢVO�б�
	 * @param ɸѡ����VO
	 * @return �Ƶ���ϢVO�б�
	 */
	public HotelInfoVO hotelDetail(String hotelid,String userid){
		try {
			return customer.hotelDetail(hotelid, userid);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * ���ݾƵ�ID���û�ID���ض����б�
	 * @param hotelid
	 * @param userid
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> getHotelOrder(String hotelid,String userid){
		try {
			return customer.getHotelOrder(hotelid, userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * �����������෵���ź���ľƵ��б�
	 * @param before
	 * @param type
	 * @return
	 */
	public ArrayList<HotelInfoVO> sortHotel(ArrayList<HotelInfoVO> before,Sort type){
		return customer.sortHotel(before, type);
	}
	
	
	/**
	 * ��ĳһ�Ƶ����ɶ���
	 * @param �Ƶ�IDVO
	 * @param ����VO
	 *
	 */
	public ResultMsg orderCreat(String hotelID,OrderVO vo2){
	   try {
		return customer.orderCreat(hotelID, vo2);
	} catch (RemoteException e) {
		e.printStackTrace();
		return ResultMsg.FAIL;
	}
		
	}
			

	/**
	 * ���۾Ƶ�	
	 * @param �Ƶ�����VO
	 */
	public void hotelEvaluate(HotelEvaluateVO vo){
		try {
			customer.hotelEvaluate(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void reinitDataService(Remote dataService) {
		customerManagementDataService = (CustomerManagementDataService)dataService;
		customer = new Customer(customerManagementDataService);
	}
			
	
	
	
	

}
