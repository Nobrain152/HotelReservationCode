package po;

import java.io.Serializable;

public class CustomerInfoPO implements Serializable{
    
	
	private static final long serialVersionUID = -7187002330817151504L;
	
	private String userid;
	
	private String username;
	
	private String contact;
	
	
	private int credit;
		
	public CustomerInfoPO(String userid,String username,String contact,int credit){
		    this.userid=userid;
			this.username=username;
			this.contact=contact;
			this.credit=credit;
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
		
	public int getCredit(){
		   return credit;
	}
}