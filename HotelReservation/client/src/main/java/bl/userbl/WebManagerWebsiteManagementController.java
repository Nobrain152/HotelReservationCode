package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.WebManagerWebsiteManagementBLService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.UserInfoVO;



/**
 * ��վ������Ա����վ�Ĳ���
 * @author �ܳ�
 *
 */
public class WebManagerWebsiteManagementController implements WebManagerWebsiteManagementBLService {

	private WebManager manager;
	private UserManagementDataService data;
	
	
	public WebManagerWebsiteManagementController(){
		data= (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		manager=new WebManager(data);
	}
	
	/**
	 * �鿴�û�������Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO userInfoInq(String userid){
		try {
			return manager.userInfoInq(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	
	/**
	 * �޸��û���Ϣ
	 * @param �û�IDVO
	 * @param �û�������ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg userInfoMod(String userid,UserInfoVO vo2){
		try {
			//System.out.println(userid);
			//return ResultMsg.SUCCESS;
			return manager.userInfoMod(userid, vo2);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMsg.FAIL;
		}
	}
			
	/**
	 * �����վӪ����Ա
	 * @param vo
	 * @return
	 */
	public String addWebStuff(UserInfoVO vo){
		try {
			return manager.addWebStuff(vo);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	
	/**
	 * �鿴��վӪ����Ա�б�
	 * @return ��վӪ����Ա�б�
	 */
	public ArrayList<UserInfoVO> webStuffScan() {
		try {
			return manager.webStuffScan();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
