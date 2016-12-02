package po;

import java.io.Serializable;

import util.VipType;

public class CommonVipPO extends VipPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ��ͨ��Ա����
	 */
	String birthday;

	public CommonVipPO(String userid, String username, ContactPO contact,
			int credit, String birthday,VipType vipType) {
		super(userid, username, contact, credit,vipType);
		this.birthday = birthday;
	}
	
	public String getBirthday(){
		return birthday;
	}
	
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

}