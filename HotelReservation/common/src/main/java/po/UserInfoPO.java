package po;

import java.io.Serializable;

public class UserInfoPO implements Serializable{

    
	
	private static final long serialVersionUID = -7187002330817151504L;
	
	
	private String userid;
	
	private String username;
	
	private String contact;
	
	
	
	public UserInfoPO(String userid,String username,String contact){
		    this.userid=userid;
			this.username=username;
			this.contact=contact;
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