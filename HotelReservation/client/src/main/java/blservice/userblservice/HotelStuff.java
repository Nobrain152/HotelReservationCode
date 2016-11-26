package blservice.userblservice;

import bl.userbl.HotelStuffHotelOperation;
import bl.userbl.StuffInfoManagement;
import util.ResultMsg;
import vo.StuffInfoVO;
import vo.UserIDVO;

public class HotelStuff {
	
	String userid;
	UserIDVO idvo;
	HotelStuffHotelOperation hotel;
	StuffInfoManagement user;
	StuffInfoVO vo;
	
	public HotelStuff(String userid){
		this.userid=userid;
		idvo=new UserIDVO(userid);
		hotel=new HotelStuffHotelOperation();
		user=new StuffInfoManagement(idvo);
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
		return vo.getHotel();
	}
	
	public ResultMsg BaseInfoModification(StuffInfoVO vo1){
		return user.IndividualBaseInfoModification(idvo,vo1);
	}
	

}
