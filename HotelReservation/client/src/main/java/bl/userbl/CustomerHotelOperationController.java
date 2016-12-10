package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
 * 客户对酒店的操作
 * 
 * @author 曹畅
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
	 * 根据输入的酒店搜索条件返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
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
	 * 根据排序种类返回排好序的酒店列表
	 * @param before
	 * @param type
	 * @return
	 */
	public ArrayList<HotelInfoVO> sortHotel(ArrayList<HotelInfoVO> before,Sort type){
		return customer.sortHotel(before, type);
	}
	
	
	/**
	 * 对某一酒店生成订单
	 * @param 酒店IDVO
	 * @param 订单VO
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
	 * 评价酒店	
	 * @param 酒店评价VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo){
		try {
			customer.HotelEvaluate(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
			
	
	
	
	

}
