package po;

import java.util.ArrayList;

public class CustomerInfoPO extends UserInfoPO{
	
	private static final long serialVersionUID = -7187002330817151504L;
	
	private int credit;
	String userid;
	String username;
	String contact;
	boolean isMember;
	ArrayList<String> orderID;
	ArrayList<String> hotelID;
	
	
	public CustomerInfoPO(String userid,String username,String contact,int credit){
	    super(userid, username, contact);
		this.credit=credit;
		isMember=false;
		orderID=new ArrayList<>();
		hotelID=new ArrayList<>();
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
	
	public boolean isMember(){
		return isMember;
	}
	
	public boolean setMember(){
		if(isMember){
			return false;
		}
		else{
			isMember=true;
			return true;
		}
	}
	
	public ArrayList<String> getorder(){
		return orderID;
	}
	
	public boolean addOrder(String id){
		if(orderID.indexOf(id)!=-1){
			return false;
		}
		else{
			orderID.add(id);
			return true;
		}
	}
	
	public ArrayList<String> gethotel(){
		return hotelID;
	}
	
	public boolean addHotel(String id){
		if(hotelID.indexOf(id)!=-1){
			return false;
		}
		else{
			hotelID.add(id);
			return true;
		}
	}
}