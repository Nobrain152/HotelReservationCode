package po;

import java.io.Serializable;

import util.VipType;

/**
 * 会员信息
 * @author lenovo
 *
 */
public class VipPO extends CustomerInfoPO implements Serializable{
	
	public VipPO(String userid, String username, ContactPO contact, int credit,VipType vipType) {
		super(userid, username, contact, credit,true,vipType);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
