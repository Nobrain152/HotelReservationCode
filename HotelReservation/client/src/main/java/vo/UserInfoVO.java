package vo;

import po.UserInfoPO;

public class UserInfoVO{
    
	private String userid;
	
	private String username;
	
	private String contact;
	
	public UserInfoVO(String userid,String username,String contact){
		    this.userid=userid;
			this.username=username;
			this.contact=contact;
	}
	
	public UserInfoVO(UserInfoPO po){
		this.userid=po.getUserid();
		this.username=po.getUsername();
		this.contact=po.getContact();
	}
	
	public String getUserid(){
		return userid;
	}
		
	public String getUsername(){
	    return username;
	}
		
	public String getContact(){
	    return contact;
	}
}