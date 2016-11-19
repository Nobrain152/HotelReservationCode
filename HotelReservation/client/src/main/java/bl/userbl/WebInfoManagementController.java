package bl.userbl;

import blservice.userblservice.WebIndividualInformationManagementBLService;
import data.userdata.UserManagementDataServiceImpl;
import po.UserIDPO;
import po.UserInfoPO;
import vo.UserIDVO;
import vo.UserInfoVO;


/**
 * 网站营销人员和网站管理人员的个人信息管理
 * @author Administrator
 *
 */
public class WebInfoManagementController implements WebIndividualInformationManagementBLService {

	UserManagementDataServiceImpl user=new UserManagementDataServiceImpl();
	UserIDVO v;
	UserIDPO po;
	
	public WebInfoManagementController(UserIDVO vo){
		v=vo;
	}
	
	/**
	 * 查看个人信息	
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(UserIDVO vo){
		po=new UserIDPO(vo.getUserID());
		UserInfoPO p=user.GetUserBaseInfo(po);
		return new UserInfoVO(p.getUserid(),p.getUsername(),p.getContact());
	}
			
	/**
	 * 修改个人信息	
	 * @param 用户IDVO
	 * @param 用户信息VO
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(UserIDVO vo1,UserInfoVO vo2){
		po=new UserIDPO(vo1.getUserID());
		UserInfoPO p=new UserInfoPO(vo2.getUserid(),vo2.getUsername(),vo2.getContact());
		return user.SetUserBaseInfo(po,p);
	}
			
}
