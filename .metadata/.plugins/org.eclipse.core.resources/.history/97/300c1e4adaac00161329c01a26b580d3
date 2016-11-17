package businesslogicserviceimpl.userblserviceimpl;

import vo.StuffInfoVO;
import vo.UserIDVO;
import vo.UserInfoVO;
import businesslogicservice.userblservice.StuffIndividualInformationManagementBLService;
import dataserviceimpl.userdataserviceimpl.UserManagementDataServiceImpl;


/**
 * 酒店管理人员管理个人信息
 * @author Administrator
 *
 */
public class StuffIndividualInformationManagementBLServiceImpl implements StuffIndividualInformationManagementBLService {

	UserInfoVO voi;
	UserManagementDataServiceImpl user;
	
	public StuffIndividualInformationManagementBLServiceImpl(UserIDVO vo){
		user=new UserManagementDataServiceImpl();
		voi=user.GetUserBaseInfo(vo);
	}
	
	/**
	 * 查看个人基本信息
	 * @param 用户IDVO
	 * @return 酒店管理人员信息VO
	 */
	public StuffInfoVO IndividualBaseInfolnquiry(UserIDVO vo){
		return (StuffInfoVO)voi;
	}
			
	
	/**
	 * 修改个人信息
	 * @param 用户IDVO
	 * @param 酒店管理人员信息VO
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(UserIDVO vo1,StuffInfoVO vo2){
		return user.SetUserBaseInfo(vo1,vo2);
	}
			
}
