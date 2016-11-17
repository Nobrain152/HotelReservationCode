package blservice.userblservice;

import bl.userbl.HotelStuffHotelOperationController;
import bl.userbl.StuffInfoManagementController;
import vo.HotelIDVO;
import vo.StuffInfoVO;
import vo.UserIDVO;

public class HotelStuff {
	
	String userid;
	UserIDVO idvo;
	HotelStuffHotelOperationController hotel;
	StuffInfoManagementController user;
	StuffInfoVO vo;
	
	public HotelStuff(String userid){
		this.userid=userid;
		idvo=new UserIDVO(userid);
		hotel=new HotelStuffHotelOperationController();
		user=new StuffInfoManagementController(idvo);
		vo=user.IndividualBaseInfolnquiry(idvo);
		//HotelIDVO id=new HotelIDVO("1234567");
		//vo=new StuffInfoVO(userid,"Tim","18192345782",id);
		//user.voi=vo;
	}
	
	public String getName(){
		return vo.getUsername();
	}
	
	public String getid(){
		return vo.getUserid();
	}
	
	public String getcontact(){
		return vo.getContact();
	}
	
	public String getHotelid(){
		HotelIDVO v = vo.getHotel();
		return v.getHotelID();
	}
	
	public boolean BaseInfoModification(StuffInfoVO vo1){
		return user.IndividualBaseInfoModification(idvo,vo1);
	}
	

}
