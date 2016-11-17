package businesslogicserviceimpl.userblserviceimpl;

import businesslogicservice.userblservice.WebIndividualInformationManagementBLService;
import dataserviceimpl.userdataserviceimpl.UserManagementDataServiceImpl;
import vo.UserIDVO;
import vo.UserInfoVO;


/**
 * 网站营销人员和网站管理人员的个人信息管理
 * @author Administrator
 *
 */
public class WebIndividualInformationManagementBLServiceImpl implements WebIndividualInformationManagementBLService {

	UserManagementDataServiceImpl user=new UserManagementDataServiceImpl();
	UserIDVO v;
	
	public WebIndividualInformationManagementBLServiceImpl(UserIDVO vo){
		v=vo;
	}
	
	/**
	 * 查看个人信息	
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(UserIDVO vo){
		return (UserInfoVO)user.GetUserBaseInfo(vo);
	}
			
	/**
	 * 修改个人信息	
	 * @param 用户IDVO
	 * @param 用户信息VO
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(UserIDVO vo1,UserInfoVO vo2){
		return user.SetUserBaseInfo(vo1,vo2);
	}
			
}
