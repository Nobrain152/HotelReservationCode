package ui;

public class UIhelper {
	private static UIhelper instance;
	private UIhelper(){}
	
	private String userID;
	private String hotelID;
	private String orderID;
	//网站管理人员管理客户信息时使用
	private String customerIDbyManager;
	//网站管理人员管理酒店工作人员信息时使用
	private String hotelStuffIDbyManager;
	//网站管理人员管理网站营销人员信息时使用
	private String salesmanIDbyManager;
	
	
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
	
	
	public String getCustomerIDbyManager(){
		return customerIDbyManager;
	}
	
	public void setCustomerIDbyManager(String str){
		this.customerIDbyManager=str;
	}
	
	public String getHotelStuffIDbyManager(){
		return hotelStuffIDbyManager;
	}
	
	public void setHotelStuffIDbyManager(String str){
		this.hotelStuffIDbyManager=str;
	}
	
	public String getSalesmanIDbyManager(){
		return salesmanIDbyManager;
	}
	
	public void setSalesmanIDbyManager(String str){
		this.salesmanIDbyManager=str;
	}
}
