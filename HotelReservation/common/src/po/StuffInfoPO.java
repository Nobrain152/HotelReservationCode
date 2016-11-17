package po;

import java.io.Serializable;

import vo.HotelIDVO;

public class StuffInfoPO implements Serializable{

    
	private static final long serialVersionUID = -7187002330817151504L;
	
	 private String userid;
		
	private String username;
		
	private String contact;
		
	private HotelIDVO hotelvo;
		
		
	public StuffInfoPO(String userid,String username,String contact,HotelIDVO vo){
		    this.userid=userid;
			this.username=username;
			this.contact=contact;
			this.hotelvo=vo;
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
			return hotelvo;
	}
}