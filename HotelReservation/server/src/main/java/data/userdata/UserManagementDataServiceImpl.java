package data.userdata;

import java.util.ArrayList;


import dataservice.userdataservice.UserManagementDataService;
import po.HotelIDPO;
import po.LoginInputPO;
import po.StuffInfoPO;
import po.UserIDPO;
import po.UserInfoPO;
import po.UserIDPO;

public class UserManagementDataServiceImpl implements UserManagementDataService {

	int number;
	int point;
	ArrayList<String> ID;
	ArrayList<String> password;
	ArrayList<UserInfoPO> info;
	String id;
	ArrayList<String> stuffhotel;
	ArrayList<String> webstuff;
	
	public UserManagementDataServiceImpl(){
		point=0;
		ID=new ArrayList<String>();
		password=new ArrayList<String>();
		info=new ArrayList<UserInfoPO>();
		number=0;
		stuffhotel=new ArrayList<String>();
		webstuff=new ArrayList<String>();
	}
	
	public String GetLoginInfo(LoginInputPO po) {
		id=po.getUserid();
		point=ID.indexOf(id);
		return password.get(point);
	}

	public String AddUser(LoginInputPO po) {
		point=password.size();
		String pass=po.getUserpassword();
		password.add(pass);
		id="";
		for(int i=0;i<9-number/10;i++){
			id=id+"0";
		}
		return id+number;
	}

	public UserInfoPO GetUserBaseInfo(UserIDPO vo) {
		id=vo.getUserID();
		point=ID.indexOf(id);
		return info.get(point);
	}

	public boolean SetUserBaseInfo(UserIDPO po1, UserInfoPO po2) {
		id=po1.getUserID();
		point=ID.indexOf(id);
		info.set(point, po2);
		return true;
	}

	public boolean addHotelStuff(HotelIDPO po1,UserIDPO po3){
		point=stuffhotel.indexOf(po3.getUserID());
		if(point!=-1){
			return false;
		}
		else{
			StuffInfoPO po2=(StuffInfoPO)info.get(point);
			po2.setHotel(po1);
			info.set(point, po2);
			return true;
			}
	}
	
	public boolean addWebStuff(UserIDPO po){
		point=webstuff.indexOf(po.getUserID());
		if(point!=-1){
			return false;
		}
		else{
			webstuff.add(po.getUserID());
			return true;
			}
	}

}	