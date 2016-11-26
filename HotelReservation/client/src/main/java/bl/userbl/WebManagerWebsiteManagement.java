package bl.userbl;

import java.util.ArrayList;

import blservice.userblservice.WebManagerWebsiteManagementBLService;
import data.userdata.UserManagementDataServiceImpl;
import po.UserIDPO;
import po.UserInfoPO;
import util.ResultMsg;
import vo.UserIDVO;
import vo.UserInfoVO;



/**
 * 网站管理人员对网站的操作
 * @author 曹畅
 *
 */
public class WebManagerWebsiteManagement implements WebManagerWebsiteManagementBLService {

	UserManagementDataServiceImpl check;
	UserIDPO po;
	
	public WebManagerWebsiteManagement(){
		check=new 	UserManagementDataServiceImpl();
	}
	
	/**
	 * 查看用户个人信息
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO UserInformationInquiry(UserIDVO vo){
		po=new UserIDPO(vo.getUserID());
		UserInfoPO p=check.GetUserBaseInfo(po);
		return new UserInfoVO(p.getUserid(),p.getUsername(),p.getContact());
	}
			
	
	/**
	 * 修改用户信息
	 * @param 用户IDVO
	 * @param 用户个人信息VO
	 * @return 修改结果
	 */
	public ResultMsg UserInformationModification(UserIDVO vo1,UserInfoVO vo2){
		po=new UserIDPO(vo1.getUserID());
		UserInfoPO po1=new UserInfoPO(vo2.getUserid(),vo2.getUsername(),vo2.getContact());
		return check.SetUserBaseInfo(po,po1);
	}
			
	/**
	 * 添加网站营销人员
	 * @param 用户IDVO
	 */
	public boolean WebsiteStuffAdd(UserIDVO vo){
		po=new UserIDPO(vo.getUserID());
		return check.addWebStuff(po);
	}

	/**
	 * 查看网站营销人员列表
	 * @return 网站营销人员列表
	 */
	public ArrayList<UserInfoVO> WebStuffScan() {
		// TODO Auto-generated method stub
		return null;
	}
}
