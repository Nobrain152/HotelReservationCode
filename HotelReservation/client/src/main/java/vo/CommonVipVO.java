package vo;

import util.VipType;

public class CommonVipVO extends CustomerInfoVO {
	
	/**
	 * 普通会员生日
	 */
	String birthday;
	
	public CommonVipVO() {}

	public CommonVipVO(String userid, String username, ContactVO contact,
			int credit, String birthday,VipType vipType) {
		super(userid, username, contact, credit, true, vipType);
		this.birthday = birthday;
	}
	
	public String getBirthday(){
		return birthday;
	}
	
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

}
