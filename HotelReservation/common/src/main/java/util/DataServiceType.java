package util;
 /** 
 * 
 * @author czq 
 * @version 2015��11��17�� ����8:31:56 
 */
public enum DataServiceType {
	
	HotelEvaluateDataService("HotelEvaluateDataService"),
	HotelInfoDataService("HotelInfoDataService"),
	RoomInfoDataService("RoomInfoDataService"),
	IntegralDataService("IntegralDataService"),
	OrderOnHotelDataService("OrderOnHotelDataService"),
	OrderOnUserDataService("OrderOnUserDataService"),
	OrderOnWebDataService("OrderOnWebDataService"),
	PromotionHotelDataService("PromotionHotelDataService"),
	PromotionWebDataService("PromotionWebDataService"),
	CustomerManagementDataService("CustomerManagementDataService"),
	UserManagementDataService("UserManagementDataService"),
	VipDataService("VipDataService");
	
	private DataServiceType(String name){
		this.name = name;
	}
	
	private String name;
	
	public String getName(){
		return this.name;
	}
	
}
