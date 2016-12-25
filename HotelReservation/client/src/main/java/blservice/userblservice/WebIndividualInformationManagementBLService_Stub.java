package blservice.userblservice;

import util.ResultMsg;
import vo.UserInfoVO;

public class WebIndividualInformationManagementBLService_Stub implements WebIndividualInformationManagementBLService {

	UserInfoVO user;
	
	public WebIndividualInformationManagementBLService_Stub(){
		user=new UserInfoVO("32345678","Dany","1234567898","32345678");
	}
	
	@Override
	public UserInfoVO IndividualBaseInfolnquiry(String userid) {
		
		return user;
	}

	@Override
	public ResultMsg IndividualBaseInfoModification(String userid, UserInfoVO vo2) {
		
		return ResultMsg.SUCCESS;
	}

}
