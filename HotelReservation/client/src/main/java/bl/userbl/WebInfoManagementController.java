package bl.userbl;

import java.rmi.RemoteException;

import blservice.userblservice.WebIndividualInformationManagementBLService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import vo.UserInfoVO;


/**
 * ��վӪ����Ա����վ������Ա�ĸ�����Ϣ����
 * @author �ܳ�
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
	 * �鿴������Ϣ	
	 * @param �û�IDVO
	 * @return �û�������ϢVO
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
	 * �޸ĸ�����Ϣ	
	 * @param �û�IDVO
	 * @param �û���ϢVO
	 * @return �޸Ľ��
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
