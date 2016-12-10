package po;

import java.io.Serializable;

import util.VipType;

public class BusinessVipPO extends CustomerInfoPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ��ҵ��Ա����
	 */
	String businessName;

	public BusinessVipPO() {}
	
	public BusinessVipPO(String userid, String username, String password,String contact,
			int credit, String businessName,VipType vipType) {
		super(userid, username,password, contact, credit, true, vipType);
		this.businessName = businessName;
	}
	
	public String getBusinessName(){
		return businessName;
	}
	
	public void setBusinessName(String businessName){
		this.businessName = businessName;
	}

}
