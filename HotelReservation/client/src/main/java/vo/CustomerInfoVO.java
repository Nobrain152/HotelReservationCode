
package vo;


import util.VipType;

/**
 * �ͻ���Ϣ
 * 
 * @author �ܳ�
 *
 */
public class CustomerInfoVO extends UserInfoVO {

	/**
	 * �ͻ�����ֵ
	 */
	private int credit;
	
	/**
	 * �Ƿ��Ա
	 */
	private boolean isMember;
	
	/**
	 * ��Ա����
	 */
	private VipType vipType;
	
	public CustomerInfoVO() {}
	
	public CustomerInfoVO(String userid, String username, ContactVO contact,
			int credit, boolean isMember,VipType vipType) {
		super(userid, username, contact);
		this.credit = credit;
		this.isMember = isMember;
		this.vipType = vipType;
		
	}

	public int getCredit() {
		return credit;
	}

	public boolean getIsMember() {
		return isMember;
	}
	
	public VipType getVipType() {
		return vipType;
	}
	
	
	public void setVipType(VipType vipType) {
		this.vipType = vipType;
	}
	
	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	
}