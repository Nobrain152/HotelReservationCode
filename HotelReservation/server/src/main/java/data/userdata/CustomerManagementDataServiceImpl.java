package data.userdata;

import java.util.ArrayList;

import dataservice.userdataservice.CustomerManagementDataService;
import po.CustomerInfoPO;
import po.HotelInfoPO;
import po.OrderPO;
import po.UserInfoPO;

public class CustomerManagementDataServiceImpl extends UserManagementDataServiceImpl implements CustomerManagementDataService {

	
	int point;
	ArrayList<String> ID;
	ArrayList<String> password;
	ArrayList<UserInfoPO> info;
	ArrayList<String> orderID;
	ArrayList<OrderPO> order;
	ArrayList<String> hotelID;
	ArrayList<HotelInfoPO> hotel;
	String id;
	CustomerInfoPO po2;
	boolean result;
	
	public CustomerManagementDataServiceImpl(){
		point=0;
		ID=new ArrayList<String>();
		password=new ArrayList<String>();
		info=new ArrayList<UserInfoPO>();
		orderID=new ArrayList<String>();
		order=new ArrayList<OrderPO>();
		hotelID=new ArrayList<String>();
		hotel=new ArrayList<HotelInfoPO>();
	}
	
	
	public boolean AddMembers(String userid) {
		point=ID.indexOf(userid);
		po2=(CustomerInfoPO) info.get(point);
		po2.setIsMember(true);
		info.set(point, po2);
		return result;
	}

	public ArrayList<String> GetCustomerOrders(String userid) {
		point=ID.indexOf(userid);
		po2=(CustomerInfoPO)info.get(point);
		return po2.getOrderIDList();
	}

	public boolean addCustomerOrders(String userid, String i) {
		point=ID.indexOf(userid);
		po2=(CustomerInfoPO)info.get(point);
		po2.addOrderID(i);
		info.set(point, po2);
		return result;
	}

	public ArrayList<String> GetCustomerHotel(String userid) {
		point=ID.indexOf(userid);
		po2=(CustomerInfoPO)info.get(point);
		return po2.getHotelIDList();
	}

	public boolean addCustomerHotel(String userid, String idh) {
		point=ID.indexOf(userid);
		po2=(CustomerInfoPO)info.get(point);
		po2.addHotelID(idh);
		info.set(point, po2);
		return result;
	}

}
