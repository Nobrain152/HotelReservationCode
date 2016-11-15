package po;

import java.io.Serializable;

public class UserIDPO implements Serializable{
    
	
	private static final long serialVersionUID = -7187002330817151504L;
	
	
    private String userid;
	
	public UserIDPO(String userid){
	    this.userid=userid;
	}
	
	public String getUserID(){
	    return userid;
	}
}