package vo;

import util.VipType;

public class BusinessVipVO extends CustomerInfoVO {
	
	/**
	 * 企业会员名称
	 */
	String businessName;
	
	public BusinessVipVO() {}

	public BusinessVipVO(String userid, String username, ContactVO contact,
			int credit, String businessName,VipType vipType) {
		super(userid, username, contact, credit, true ,vipType);
		this.businessName = businessName;
	}
	
	public String getBusinessName(){
		return businessName;
	}
	
	public void setBusinessName(String businessName){
		this.businessName = businessName;
	}

}
