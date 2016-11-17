package businesslogicservice.userblservice;

import java.util.ArrayList;

import businesslogicserviceimpl.userblserviceimpl.CustomerHotelOperationBLServiceImpl;
import businesslogicserviceimpl.userblserviceimpl.CustomerIndividualInformationManagementBLServiceImpl;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.IntegralVO;
import vo.OrderOnUserVO;
import vo.UserIDVO;

public class Customer  {

	CustomerInfoVO infomation;
	CustomerIndividualInformationManagementBLServiceImpl in;
	CustomerHotelOperationBLServiceImpl hotel;
	UserIDVO idvo;
	
	public Customer(String id){
		idvo=new UserIDVO(id);
		in=new CustomerIndividualInformationManagementBLServiceImpl(idvo);
		hotel=new CustomerHotelOperationBLServiceImpl(id);
		infomation=(CustomerInfoVO)in.IndividualBaseInfolnquiry(idvo);
	}
	
	
	public boolean BaseInfoModification(CustomerInfoVO vo2){
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
