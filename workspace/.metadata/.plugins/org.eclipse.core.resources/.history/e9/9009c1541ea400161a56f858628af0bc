package businesslogicserviceimpl.userblserviceimpl;

import po.HotelIDVoPO;
import vo.HotelInfoVO;
import vo.UserIDVO;

import java.security.PublicKey;

import dataservice.userdataservice.HotelIDVO;
import dataservice.userdataservice.UserManagementDataServiceImp;

public class WebManagerHotelOperationBlServiceImpl implements WebManagerHotelOperationBlService {

	UserManagementDataServiceImpl check;
	
	public WebManagerHotelOperationBlServiceImpl(){
		check=new UserManagementDataServiceImpl();
	}
	
	
	public void HotelAdd(HotelInfoVO vo){
		
	}
			
	
	public boolean StuffAdd(HotelIDVoPO vo1,UserIDVO vo2){
		return check.addHotelStuff(vo2,vo1);
	}
}
