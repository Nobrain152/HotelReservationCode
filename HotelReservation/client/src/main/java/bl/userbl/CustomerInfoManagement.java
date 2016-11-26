package bl.userbl;

import java.util.ArrayList;

import bl.creditbl.Credit;
import blservice.userblservice.CustomerIndividualInformationManagementBLService;
import data.userdata.CustomerManagementDataServiceImpl;
import data.userdata.UserManagementDataServiceImpl;
import po.CustomerInfoPO;
import po.UserIDPO;
import util.ResultMsg;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.CreditVO;
import vo.OrderOnUserVO;
import vo.UserIDVO;
import vo.UserInfoVO;

public class CustomerInfoManagement {
	
	UserInfoVO userInfoVO;
	ArrayList<OrderOnUserVO> orderVOs;
	ArrayList<HotelInfoVO> hotelInfoVOs;
	ArrayList<String> orderID;
	ArrayList<String> hotelID;
	CreditVO integralVO;
	UserManagementDataServiceImpl usermanage;
	CustomerManagementDataServiceImpl customermanage;
	Credit integral;
	String po;
		
	public CustomerInfoManagement(String vo){
		usermanage = new UserManagementDataServiceImpl();
		customermanage = new CustomerManagementDataServiceImpl();
		integral=new Credit();
		po=vo;
		userInfoVO=new UserInfoVO(usermanage.GetUserBaseInfo(po));
		orderID=customermanage.GetCustomerOrders(po);
		hotelID=customermanage.GetCustomerHotel(po);
		
	}

	public UserInfoVO IndividualBaseInfolnquiry(UserIDVO vo){
		return userInfoVO;
	}

	public ResultMsg IndividualBaseInfoModification(UserIDVO vo1,CustomerInfoVO vo2){
		UserIDPO po1=new UserIDPO(vo1.getUserID());
		CustomerInfoPO po2=new CustomerInfoPO(vo2.getUserid(),vo2.getUsername(),vo2.getContact(),vo2.getCredit());
		return usermanage.SetUserBaseInfo(po1,po2);
	}
			
	
	public ArrayList<OrderOnUserVO> IndividualOrderInquiry(UserIDVO vo){
		return orderVOs;
	}
			
	
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(UserIDVO vo){
		return hotelInfoVOs;
	}
			
	
	public CreditVO IndividualCredictInquiry(UserIDVO vo){
		return 	integralVO;
	}
			
}
