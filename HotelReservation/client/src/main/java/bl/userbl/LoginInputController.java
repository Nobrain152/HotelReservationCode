package bl.userbl;

import java.rmi.RemoteException;

import blservice.userblservice.LoginInputBLService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.UserType;
import vo.UserInfoVO;

/**
 * �û���¼
 * @author �ܳ�
 *
 */
public class LoginInputController implements LoginInputBLService {

	private User user;
	private UserManagementDataService data;
	
	/**
	 * ���췽��
	 * @param �û�ID
	 */
	public LoginInputController(){
		data= (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		user=new User(data);
	}
	
	
	/**
	 * ��¼
	 * @param ��¼������ϢVO
	 * @return ��¼���
	 */
    public boolean  LogIn(String id,String password){
    	try {
			return user.LogIn(id,password);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
    }
	
	
    /**
	 * �ǳ�	
	 * @param ��¼������ϢVO
	 * @return �ǳ����
	 */
	public boolean LogOut(boolean ok){
		try {
			return user.LogOut(ok);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * ע��	
	 * @param ��¼������ϢVO
	 * @return ע����
	 */
	public String Register(UserInfoVO vo){
		try {
			return user.Register(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * �õ��û�����
	 * @param userid
	 * @return
	 */
	public UserType getType(String userid){
		try {
			return user.getType(userid);
		} catch (RemoteException e) {
			return null;
		}
	}
}
