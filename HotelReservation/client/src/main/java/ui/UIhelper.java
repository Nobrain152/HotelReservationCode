package ui;

public class UIhelper {
	private static UIhelper instance;
	private UIhelper(){}
	
	private String userID;
	private String hotelID;
	private String orderID;
	
	
	public static UIhelper getInstance(){
		if(instance==null){
			instance=new UIhelper();
		}
		return instance;
	}
	
	public String getUserID(){
		return userID;
	}
	
	public void setUserID(String str){
		this.userID=str;
	}
	
	public String getHotelID(){
		return hotelID;
	}
	
	public void setHotelID(String str){
		this.hotelID=str;
	}
	
	public String getOrderID(){
		return orderID;
	}
	
	public void setOrderID(String str){
		this.orderID=str;
	}
}
