package bl.userbl;

import java.rmi.RemoteException;

import dataservice.userdataservice.UserManagementDataService;
import po.LoginInPO;
import vo.LoginInVO;

public class User {
	
	private UserManagementDataService data;
	private LoginInPO po;
	
	public User(UserManagementDataService data){
		this.data=data;
	}
	
	/**
	 * ��¼
	 * @param ��¼������ϢVO
	 * @return ��¼���
	 */
    public boolean  LogIn(LoginInVO vo)throws RemoteException{
    	String pass=vo.getPassword();
    	po=new LoginInPO(vo.getUsername(),vo.getPassword());
    	String real=data.GetLoginInfo(po);
    	return real.equals(pass);
    	
    }
	
	
    /**
	 * �ǳ�	
	 * @param ��¼������ϢVO
	 * @return �ǳ����
	 */
	public boolean LogOut(boolean ok)throws RemoteException{
		if(ok){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * ע��	
	 * @param ��¼������ϢVO
	 * @return ע����
	 */
	public String Register(LoginInVO vo)throws RemoteException{
		po=new LoginInPO(vo.getUsername(),vo.getPassword());
		return data.AddUser(po);
	}
}
