package po;

import java.io.Serializable;

import util.VipType;

public class BusinessVipPO extends VipPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 企业会员名称
	 */
	String businessName;

	public BusinessVipPO(String userid, String username, ContactPO contact,
			int credit, String businessName,VipType vipType) {
		super(userid, username, contact, credit,vipType);
		this.businessName = businessName;
	}
	
	public String getBusinessName(){
		return businessName;
	}
	
	public void setBusinessName(String businessName){
		this.businessName = businessName;
	}

}
