package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.UserInfoVO;

public class WebManagerWebsiteManagementBLService_Stub implements WebManagerWebsiteManagementBLService {

	
	UserInfoVO user;
	ArrayList<UserInfoVO> scan;
	
	public WebManagerWebsiteManagementBLService_Stub(){
		
		user=new UserInfoVO("32345678","Dany","1234567898","32345678");
		scan=new ArrayList<UserInfoVO>();
		scan.add(user);
	}
	
	
	@Override
	public UserInfoVO UserInformationInquiry(String userid) {
		
		return user;
	}

	@Override
	public ResultMsg UserInformationModification(String userid, UserInfoVO vo2) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<UserInfoVO> WebStuffScan() {
		
		return scan;
	}

	@Override
	public String AddWebStuff(UserInfoVO vo) {
		
		return "33345678";
	}

}
