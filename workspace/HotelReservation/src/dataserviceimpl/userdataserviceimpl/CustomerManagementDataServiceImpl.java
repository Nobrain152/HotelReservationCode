package dataserviceimpl.userdataserviceimpl;

import java.util.ArrayList;

import dataservice.userdataservice.CustomerManagementDataService;
import vo.CustomerInfoVO;
import vo.OrderOnUserVO;
import vo.UserIDVO;
import vo.UserInfoVO;

public class CustomerManagementDataServiceImpl implements CustomerManagementDataService {

	
	int point;
	ArrayList<String> ID;
	ArrayList<String> password;
	ArrayList<UserInfoVO> info;
	ArrayList<String> orderID;
	ArrayList<OrderOnUserVO> order;
	ArrayList<String> hotelID;
	ArrayList<OrderOnUserVO> hotel;
	String id;
	CustomerInfoVO vo2;
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
	public boolean AddMembers(UserIDVO vo) {
		id=vo.getUserID();
		point=ID.indexOf(id);
		vo2=(CustomerInfoVO)info.get(point);
		result=vo2.setMember();
		info.set(point, vo2);
		return result;
	}

	@Override
	public ArrayList<String> GetCustomerOrders(UserIDVO vo) {
		id=vo.getUserID();
		point=ID.indexOf(id);
		vo2=(CustomerInfoVO)info.get(point);
		return vo2.getorder();
	}

	@Override
	public boolean addCustomerOrders(UserIDVO vo, String i) {
		id=vo.getUserID();
		point=ID.indexOf(id);
		vo2=(CustomerInfoVO)info.get(point);
		result=vo2.addOrder(i);
		info.set(point, vo2);
		return result;
	}

	@Override
	public ArrayList<String> GetCustomerHotel(UserIDVO vo) {
		id=vo.getUserID();
		point=ID.indexOf(id);
		vo2=(CustomerInfoVO)info.get(point);
		return vo2.gethotel();
	}

	@Override
	public boolean addCustomerHotel(UserIDVO vo, String idh) {
		id=vo.getUserID();
		point=ID.indexOf(id);
		vo2=(CustomerInfoVO)info.get(point);
		result=vo2.addHotel(idh);
		info.set(point, vo2);
		return result;
	}

}
