package blservice.userblservice;

import java.util.ArrayList;

import bl.userbl.CustomerHotelOperation;
import bl.userbl.CustomerInfoManagement;
import util.ResultMsg;
import vo.ContactVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.CreditVO;
import vo.OrderOnUserVO;
import vo.UserInfoVO;

public class Customer {

	CustomerInfoVO infomation;
	CustomerInfoManagement in;
	CustomerHotelOperation hotel;
	String userID;
	
	public Customer(String id){
		this.userID = id;
		in = new CustomerInfoManagement(userID);
		hotel=new CustomerHotelOperation(id);
		infomation=(CustomerInfoVO)in.IndividualBaseInfolnquiry(userID);
	}
	
	
	public ResultMsg BaseInfoModification(CustomerInfoVO vo2){
		return in.IndividualBaseInfoModification(userID,vo2);
	}
				
	
	public ArrayList<OrderOnUserVO> OrderInquiry(){
		return in.IndividualOrderInquiry(userID);
	}
				
   
	public ArrayList<HotelInfoVO> HotelInquiry(){
		return in.IndividualHotelInquiry(userID);
	}
				
	
	public CreditVO IndividualCredictInquiry(){
		return in.IndividualCredictInquiry(userID);
	}
	
	public String getid(){
		return infomation.getUserid();
	}
	
	public String getname(){
		return infomation.getUsername();
	}
	
	public ContactVO getContact(){
	    return infomation.getContact();
	}
}
