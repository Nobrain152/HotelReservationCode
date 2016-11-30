package bl.userbl;

import java.rmi.RemoteException;

import blservice.userblservice.WebIndividualInformationManagementBLService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import vo.UserInfoVO;


/**
 * 网站营销人员和网站管理人员的个人信息管理
 * @author 曹畅
 *
 */
public class WebInfoManagementController implements WebIndividualInformationManagementBLService {

	private WebManager manager;
	private UserManagementDataService data;
	
	
	public WebInfoManagementController(){
		data= (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		manager=new WebManager(data);
	}
	
	/**
	 * 查看个人信息	
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
		try {
			return  manager.IndividualBaseInfolnquiry(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	/**
	 * 修改个人信息	
	 * @param 用户IDVO
	 * @param 用户信息VO
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(String userid,UserInfoVO vo2){
		try {
			return manager.IndividualBaseInfoModification(userid, vo2);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
			
}
