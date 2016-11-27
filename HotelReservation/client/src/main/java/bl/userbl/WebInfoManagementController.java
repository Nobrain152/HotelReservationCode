package bl.userbl;

import blservice.userblservice.WebIndividualInformationManagementBLService;
import vo.UserInfoVO;


/**
 * 网站营销人员和网站管理人员的个人信息管理
 * @author Administrator
 *
 */
public class WebInfoManagementController implements WebIndividualInformationManagementBLService {

	private WebManager manager=new WebManager();
	
	
	/**
	 * 查看个人信息	
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
		return  manager.IndividualBaseInfolnquiry(userid);
	}
			
	/**
	 * 修改个人信息	
	 * @param 用户IDVO
	 * @param 用户信息VO
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(String userid,UserInfoVO vo2){
		return manager.IndividualBaseInfoModification(userid, vo2);
	}
			
}
