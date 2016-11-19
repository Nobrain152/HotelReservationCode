package po;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerInfoPO extends UserInfoPO implements Serializable{
    
	
	private static final long serialVersionUID = -7187002330817151504L;
	
	private String userid;
	
	private String username;
	
	private String contact;
	
	private boolean isMember;
	
	private int credit;
	
	private ArrayList<String> order;
	
	private ArrayList<String> hotel;
		
	public CustomerInfoPO(String userid,String username,String contact,int credit){
		    super(userid,username,contact);
		    this.userid=userid;
			this.username=username;
			this.contact=contact;
			this.credit=credit;
			isMember=false;
			order=new ArrayList<String>();
			hotel=new ArrayList<String>();
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
	
	public boolean setMember(boolean choose){
		if(choose!=isMember){
			isMember=choose;
		}
		return choose!=isMember;
	}
	
	public ArrayList<String> getOrder(){
		return order;
	}
	
	public boolean addOrder(String order){
		if(!this.order.contains(order)){
			this.order.add(order);
			return true;
	    }
		return false;
	}
	
	public ArrayList<String> getHotel(){
		return hotel;
	}
	
	public boolean addHotel(String hotel){
		if(!this.hotel.contains(hotel)){
			this.hotel.add(hotel);
			return true;
	    }
		return false;
	}
}