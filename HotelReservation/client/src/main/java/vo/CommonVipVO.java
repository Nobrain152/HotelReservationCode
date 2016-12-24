package vo;

import util.VipType;

/**
 * ��ͨ��Ա
 * @author txin15
 *
 */
public class CommonVipVO extends CustomerInfoVO {
	
	/**
	 * ��ͨ��Ա����
	 */
	String birthday;
	
	public CommonVipVO() {}

	public CommonVipVO(String userid, String username, String password,String contact,
			int credit, String birthday,VipType vipType) {
		super(userid, username, password, contact, credit, true, vipType);
		this.birthday = birthday;
	}
	
	public String getBirthday(){
		return birthday;
	}
	
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

}
