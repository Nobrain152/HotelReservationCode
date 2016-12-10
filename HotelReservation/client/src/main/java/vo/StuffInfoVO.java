package vo;


/**
 * 酒店管理人员，网站管理人员，网站营销人员的信息
 * @author 曹畅
 *
 */
public class StuffInfoVO extends UserInfoVO{
	
	private String hotel;
	
	public StuffInfoVO() {}
	
	public StuffInfoVO(String userid,String username,String contact,String hotelid,String password){
	    super(userid, username, contact,password);
		this.hotel =hotelid;
	}
	
	public String getHotel(){
		return hotel;
	}	
	
	public void setHotel(String id){
		hotel = id;
	}
}