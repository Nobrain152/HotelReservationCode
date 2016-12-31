package bl.userbl;

import java.rmi.RemoteException;

import blservice.userblservice.StuffIndividualInformationManagementBLService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.StuffInfoVO;


/**
 * �Ƶ������Ա���������Ϣ
 * @author �ܳ�
 *
 */
public class StuffInfoManagementController implements StuffIndividualInformationManagementBLService {

	private HotelStuff stuff;
	private UserManagementDataService userManagementDataService;
	
	
	public StuffInfoManagementController(){
		userManagementDataService = (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		stuff=new HotelStuff(userManagementDataService);
	}
	
	/**
	 * �鿴���˻�����Ϣ
	 * @param �û�IDVO
	 * @return �Ƶ������Ա��ϢVO
	 */
	public StuffInfoVO individualInfolnq(String userid){
		try {
			return stuff.individualInfolnq(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	
	/**
	 * �޸ĸ�����Ϣ
	 * @param �û�IDVO
	 * @param �Ƶ������Ա��ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg individualInfoMod(String userid,StuffInfoVO vo2){
		try {
			return stuff.individualInfoMod(userid, vo2);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMsg.FAIL;
		}
	}
			
}
