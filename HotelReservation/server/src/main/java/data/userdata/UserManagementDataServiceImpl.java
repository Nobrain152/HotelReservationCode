package data.userdata;

import java.util.ArrayList;


import dataservice.userdataservice.UserManagementDataService;
import po.LoginInPO;
import po.StuffInfoPO;
import po.UserInfoPO;

public class UserManagementDataServiceImpl implements UserManagementDataService {

	private int number;
	private int point;
	private ArrayList<String> ID;
	private ArrayList<String> password;
	private ArrayList<UserInfoPO> info;
	private String id;
	private ArrayList<String> stuffhotel;
	private ArrayList<String> webstuff;
	
	public UserManagementDataServiceImpl(){
		point=0;
		ID=new ArrayList<String>();
		password=new ArrayList<String>();
		info=new ArrayList<UserInfoPO>();
		number=0;
		stuffhotel=new ArrayList<String>();
		webstuff=new ArrayList<String>();
	}
	
	public String GetLoginInfo(LoginInPO po) {
		id=po.getUsername();
		point=ID.indexOf(id);
		return password.get(point);
	}

	public String AddUser(LoginInPO po) {
		point=password.size();
		String pass=po.getPassword();
		password.add(pass);
		id="";
		for(int i=0;i<9-number/10;i++){
			id=id+"0";
		}
		return id+number;
	}

	public UserInfoPO GetUserBaseInfo(String userid) {
		point=ID.indexOf(userid);
		return info.get(point);
	}

	public boolean SetUserBaseInfo(String userid, UserInfoPO po2) {
		point=ID.indexOf(userid);
		info.set(point, po2);
		return true;
	}

	public boolean addHotelStuff(String hotelid,String userid){
		point=stuffhotel.indexOf(userid);
		if(point!=-1){
			return false;
		}
		else{
			StuffInfoPO po2=(StuffInfoPO)info.get(point);
			po2.setHotel(hotelid);
			info.set(point, po2);
			return true;
			}
	}
	
	public boolean addWebStuff(String userid){
		point=webstuff.indexOf(userid);
		if(point!=-1){
			return false;
		}
		else{
			webstuff.add(userid);
			return true;
			}
	}
	
	/**
	 * 查看网站营销人员列表
	 * @return 网站营销人员列表
	 */
	public ArrayList<UserInfoPO> WebStuffScan(){
		return null;
	}

}	