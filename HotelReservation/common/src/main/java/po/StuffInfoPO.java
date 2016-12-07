package po;

import java.io.Serializable;

import po.ContactPO;
import po.UserInfoPO;

/**
 * 酒店管理人员，网站管理人员，网站营销人员的信息
 * @author lenovo
 *
 */
public class StuffInfoPO extends UserInfoPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// TODO
	private String hotelVO;
	
	public StuffInfoPO() {}
	
	public StuffInfoPO(String userid,String username,ContactPO contact,String VO){
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