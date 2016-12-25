package blservice.userblservice;

import util.ResultMsg;
import vo.StuffInfoVO;

public class StuffIndividualInformationManagementBLService_Stub implements StuffIndividualInformationManagementBLService {

	StuffInfoVO stuff;
	
	public StuffIndividualInformationManagementBLService_Stub(){
		stuff=new StuffInfoVO("22345678","Jack","1234567898","5000","22345678");
	}
	
	@Override
	public StuffInfoVO IndividualBaseInfolnquiry(String userid) {
		
		return stuff;
	}

	@Override
	public ResultMsg IndividualBaseInfoModification(String userid, StuffInfoVO vo2) {
		
		return ResultMsg.SUCCESS;
	}

}
