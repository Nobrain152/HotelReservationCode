package data.userdata;

import java.util.ArrayList;

import dataservice.userdataservice.CustomerManagementDataService;
import po.CustomerInfoPO;
import po.HotelInfoPO;
import po.OrderOnUserPO;
import po.UserIDPO;
import po.UserInfoPO;
import util.ResultMsg;

public class CustomerManagementDataServiceImpl implements CustomerManagementDataService {

	
	int point;
	ArrayList<String> ID;
	ArrayList<String> password;
	ArrayList<UserInfoPO> info;
	ArrayList<String> orderID;
	ArrayList<OrderOnUserPO> order;
	ArrayList<String> hotelID;
	ArrayList<HotelInfoPO> hotel;
	String id;
	CustomerInfoPO po2;
	ResultMsg result;
	
	public CustomerManagementDataServiceImpl(){
		point=0;
		ID=new ArrayList<String>();
		password=new ArrayList<String>();
		info=new ArrayList<UserInfoPO>();
		orderID=new ArrayList<String>();
		order=new ArrayList<OrderOnUserPO>();
		hotelID=new ArrayList<String>();
		hotel=new ArrayList<HotelInfoPO>();
	}
	
	
	public ResultMsg AddMembers(UserIDPO po) {
		id=po.getUserID();
		point=ID.indexOf(id);
		po2=(CustomerInfoPO) info.get(point);
		if(po2.setMember(true)){
			result = ResultMsg.SUCCESS;
		}else{
			result = ResultMsg.FAIL;
		}
		info.set(point, po2);
		return result;
	}

	public ArrayList<String> GetCustomerOrders(UserIDPO po) {
		id=po.getUserID();
		point=ID.indexOf(id);
		po2=(CustomerInfoPO)info.get(point);
		return po2.getOrder();
	}

	public ResultMsg addCustomerOrders(UserIDPO po, String i) {
		id=po.getUserID();
		point=ID.indexOf(id);
		po2=(CustomerInfoPO)info.get(point);
		if(po2.addOrder(i)){
			result = ResultMsg.SUCCESS;
		}else{
			result = ResultMsg.FAIL;
		}
		info.set(point, po2);
		return result;
	}

	public ArrayList<String> GetCustomerHotel(UserIDPO po) {
		id=po.getUserID();
		point=ID.indexOf(id);
		po2=(CustomerInfoPO)info.get(point);
		return po2.getHotel();
	}

	public ResultMsg addCustomerHotel(UserIDPO po, String idh) {
		id=po.getUserID();
		point=ID.indexOf(id);
		po2=(CustomerInfoPO)info.get(point);
		if(po2.addHotel(idh)){
			result = ResultMsg.SUCCESS;
		}else{
			result = ResultMsg.FAIL;
		}
		info.set(point, po2);
		return result;
	}

}
