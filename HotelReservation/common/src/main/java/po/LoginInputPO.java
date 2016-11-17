package po;

import java.io.Serializable;

public class LoginInputPO implements Serializable{
    
	
	private static final long serialVersionUID = -7187002330817151504L;
	
	private String userid;
	
	private String userpassword;
	
	public LoginInputPO(String userid,String userpassword){
	    this.userid=userid;
		this.userpassword=userpassword;
	}
	
	public String getUserid(){
	    return userid;
	}
	
	public String getUserpassword(){
	    return userpassword;
	}
}