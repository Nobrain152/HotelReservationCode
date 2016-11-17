package vo;

import vo.HotelIDVO;

public class StuffInfoVO extends UserInfoVO{
    
	private String userid;
		
	private String username;
		
	private String contact;
		
	private HotelIDVO hotelVO;
	
	public StuffInfoVO(String userid,String username,String contact,HotelIDVO VO){
	    super(userid, username, contact);
		this.hotelVO=VO;
	}
		
	public String getUserid(){
	    return userid;
	}
		
	public String getUsername(){
	    return username;
	}
		
	public String getContact(){
	    return contact;
	}
	
	public HotelIDVO getHotel(){
		return hotelVO;
	}	
	
	public void setHotel(HotelIDVO vo){
		hotelVO=vo;
	}
}