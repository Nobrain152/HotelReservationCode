package bl.userbl;

import java.util.ArrayList;

import blservice.userblservice.WebManagerWebsiteManagementBLService;
import vo.UserInfoVO;



/**
 * 网站管理人员对网站的操作
 * @author 曹畅
 *
 */
public class WebManagerWebsiteManagementController implements WebManagerWebsiteManagementBLService {

	private WebManager manager=new WebManager();
	
	/**
	 * 查看用户个人信息
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO UserInformationInquiry(String userid){
		return manager.UserInformationInquiry(userid);
	}
			
	
	/**
	 * 修改用户信息
	 * @param 用户IDVO
	 * @param 用户个人信息VO
	 * @return 修改结果
	 */
	public boolean UserInformationModification(String userid,UserInfoVO vo2){
		return manager.UserInformationModification(userid, vo2);
	}
			
	/**
	 * 添加网站营销人员
	 * @param 用户IDVO
	 */
	public boolean WebsiteStuffAdd(String userid){
		return manager.WebsiteStuffAdd(userid);
	}

	/**
	 * 查看网站营销人员列表
	 * @return 网站营销人员列表
	 */
	public ArrayList<UserInfoVO> WebStuffScan() {
		return manager.WebStuffScan();
	}
}
