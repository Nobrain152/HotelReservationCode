package po;

import java.io.Serializable;

import po.UserInfoPO;

/**
 * �Ƶ������Ա����վ������Ա����վӪ����Ա����Ϣ
 * @author �ܳ�
 *
 */
public class StuffInfoPO extends UserInfoPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * �Ƶ깤����Ա�������Ƶ�ID
	 */
	private String hotel;
	
	public StuffInfoPO() {}
	
	public StuffInfoPO(String userid,String username,String contact,String VO,String password){
	    super(userid, username, contact,password);
		this.hotel = VO;
	}
	
	public String getHotel(){
		return hotel;
	}	
	
	public void setHotel(String vo){
		hotel = vo;
	}
	
	
}