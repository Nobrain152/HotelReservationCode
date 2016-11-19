package po;

import java.io.Serializable;


public class StuffInfoPO extends UserInfoPO implements Serializable{

    
	private static final long serialVersionUID = -7187002330817151504L;
	
	 private String userid;
		
	private String username;
		
	private String contact;
		
	private HotelIDPO hotelpo;
		
		
	public StuffInfoPO(String userid,String username,String contact,String hotel){
		    super(userid,username,contact);
		    this.userid=userid;
			this.username=username;
			this.contact=contact;
			this.hotelpo=new HotelIDPO(hotel);
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
		
	public HotelIDPO getHotel(){
			return hotelpo;
	}
	
	public void setHotel(HotelIDPO p){
		hotelpo=p;
	}
}