package data.userdata;

import java.util.ArrayList;

import dataservice.userdataservice.CustomerManagementDataService;
import po.CustomerInfoPO;
import po.OrderOnUserPO;
import po.UserIDPO;
import po.UserInfoPO;

public class CustomerManagementDataServiceImpl implements CustomerManagementDataService {

	
	int point;
	ArrayList<String> ID;
	ArrayList<String> password;
	ArrayList<UserInfoPO> info;
	ArrayList<String> orderID;
	ArrayList<OrderOnUserPO> order;
	ArrayList<String> hotelID;
	ArrayList<OrderOnUserPO> hotel;
	String id;
	CustomerInfoPO po2;
	boolean result;
	
	public CustomerManagementDataServiceImpl(){
		point=0;
		ID=new ArrayList<>();
		password=new ArrayList<>();
		info=new ArrayList<>();
		orderID=new ArrayList<>();
		order=new ArrayList<>();
		hotelID=new ArrayList<>();
		hotel=new ArrayList<>();
	}
	
	@Override
	public boolean AddMembers(UserIDPO po) {
		id=po.getUserID();
		point=ID.indexOf(id);
		po2=(CustomerInfoPO)info.get(point);
		result=po2.setMember();
		info.set(point, po2);
		return result;
	}

	@Override
	public ArrayList<String> GetCustomerOrders(UserIDPO po) {
		id=po.getUserID();
		point=ID.indexOf(id);
		po2=(CustomerInfoPO)info.get(point);
		return po2.getorder();
	}

	@Override
	public boolean addCustomerOrders(UserIDPO po, String i) {
		id=po.getUserID();
		point=ID.indexOf(id);
		po2=(CustomerInfoPO)info.get(point);
		result=po2.addOrder(i);
		info.set(point, po2);
		return result;
	}

	@Override
	public ArrayList<String> GetCustomerHotel(UserIDPO po) {
		id=po.getUserID();
		point=ID.indexOf(id);
		po2=(CustomerInfoPO)info.get(point);
		return po2.gethotel();
	}

	@Override
	public boolean addCustomerHotel(UserIDPO po, String idh) {
		id=po.getUserID();
		point=ID.indexOf(id);
		po2=(CustomerInfoPO)info.get(point);
		result=po2.addHotel(idh);
		info.set(point, po2);
		return result;
	}

}
