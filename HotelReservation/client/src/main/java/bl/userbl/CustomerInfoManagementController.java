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
	
	
	public CustomerInfoManagementController(UserIDVO vo){
		
		
	}
	
	
	
	public UserInfoVO IndividualBaseInfolnquiry(UserIDVO vo){
		return userInfoVO;
	}
			
	
	public boolean IndividualBaseInfoModification(UserIDVO vo1,CustomerInfoVO vo2){
		return true;
	}
			
	
	public ArrayList<OrderOnUserVO> IndividualOrderInquiry(UserIDVO vo){
		return null;
	}
			
	
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(UserIDVO vo){
		return null;
	}
			
	
	public IntegralVO IndividualCredictInquiry(UserIDVO vo){
		return 	null;
	}
			
}
