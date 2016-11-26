package blservice.userblservice;

import java.util.ArrayList;

import bl.userbl.CustomerHotelOperation;
import bl.userbl.CustomerInfoManagement;
import util.ResultMsg;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.IntegralVO;
import vo.OrderOnUserVO;
import vo.UserIDVO;

public class Customer  {

	CustomerInfoVO infomation;
	CustomerInfoManagement in;
	CustomerHotelOperation hotel;
	UserIDVO idvo;
	
	public Customer(String id){
		idvo=new UserIDVO(id);
		in=new CustomerInfoManagement(idvo);
		hotel=new CustomerHotelOperation(id);
		infomation=(CustomerInfoVO)in.IndividualBaseInfolnquiry(idvo);
	}
	
	
	public ResultMsg BaseInfoModification(CustomerInfoVO vo2){
		return in.IndividualBaseInfoModification(idvo,vo2);
	}
				
	
	public ArrayList<OrderOnUserVO> OrderInquiry(){
		return in.IndividualOrderInquiry(idvo);
	}
				
   
	public ArrayList<HotelInfoVO> HotelInquiry(){
		return in.IndividualHotelInquiry(idvo);
	}
				
	
	public IntegralVO IndividualCredictInquiry(){
		return in.IndividualCredictInquiry(idvo);
	}
	
	public String getid(){
		return infomation.getUserid();
	}
	
	public String getname(){
		return infomation.getUsername();
	}
	
	public String getcontact(){
	    return infomation.getContact();
	}
}
