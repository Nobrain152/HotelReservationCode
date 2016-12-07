package vo;

import util.VipType;

/**
 * 会员信息
 * @author gyf
 *
 */
public class VipVO extends CustomerInfoVO{
	
	public VipVO() {}

	public VipVO(String userid, String username, ContactVO contact, int credit, boolean isMember,
			VipType vipType) {
		super(userid, username, contact, credit, isMember, vipType);
		// TODO Auto-generated constructor stub
	}
	
}
