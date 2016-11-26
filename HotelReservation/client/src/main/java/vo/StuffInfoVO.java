package vo;


/**
 * 酒店管理人员，网站管理人员，网站营销人员的信息
 * @author lenovo
 *
 */
public class StuffInfoVO extends UserInfoVO{
	
	// TODO
	private String hotelVO;
	
	public StuffInfoVO(String userid,String username,ContactVO contact,String VO){
	    super(userid, username, contact);
		this.hotelVO = VO;
	}
	
	public String getHotel(){
		return hotelVO;
	}	
	
	public void setHotel(String vo){
		hotelVO = vo;
	}
}