package po;

import java.io.Serializable;

import po.ContactPO;
import po.UserInfoPO;

/**
 * �Ƶ������Ա����վ������Ա����վӪ����Ա����Ϣ
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