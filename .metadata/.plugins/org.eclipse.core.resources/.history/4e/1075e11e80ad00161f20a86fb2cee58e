package bl.userbl;

import java.util.ArrayList;

import bl.integralbl.IntegralController;
import blservice.userblservice.CustomerIndividualInformationManagementBLService;
import data.userdata.CustomerManagementDataServiceImpl;
import data.userdata.UserManagementDataServiceImpl;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.IntegralVO;
import vo.OrderOnUserVO;
import vo.UserIDVO;
import vo.UserInfoVO;

public class CustomerInfoManagementController
		implements CustomerIndividualInformationManagementBLService {
	
	UserInfoVO userInfoVO;
	ArrayList<OrderOnUserVO> orderVOs;
	ArrayList<HotelInfoVO> hotelInfoVOs;
	ArrayList<String> orderID;
	ArrayList<String> hotelID;
	IntegralVO integralVO;
	UserManagementDataServiceImpl usermanage;
	CustomerManagementDataServiceImpl customermanage;
	IntegralController integral;
	
	public CustomerInfoManagementController(UserIDVO vo){
		usermanage=new UserManagementDataServiceImpl();
		customermanage=new CustomerManagementDataServiceImpl();
		integral=new IntegralController();
		userInfoVO=usermanage.GetUserBaseInfo(vo);
		orderID=customermanage.GetCustomerOrders(vo);
		hotelID=customermanage.GetCustomerHotel(vo);
		
	}
	
	
	
	public UserInfoVO IndividualBaseInfolnquiry(UserIDVO vo){
		return userInfoVO;
	}
			
	
	public boolean IndividualBaseInfoModification(UserIDVO vo1,CustomerInfoVO vo2){
		return usermanage.SetUserBaseInfo(vo1,vo2);
	}
			
	
	public ArrayList<OrderOnUserVO> IndividualOrderInquiry(UserIDVO vo){
		return orderVOs;
	}
			
	
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(UserIDVO vo){
		return hotelInfoVOs;
	}
			
	
	public IntegralVO IndividualCredictInquiry(UserIDVO vo){
		return 	integralVO;
	}
			
}
