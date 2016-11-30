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
	 * 登录
	 * @param 登录输入信息VO
	 * @return 登录结果
	 */
    public boolean  LogIn(LoginInVO vo)throws RemoteException{
    	String pass=vo.getPassword();
    	po=new LoginInPO(vo.getUsername(),vo.getPassword());
    	String real=data.GetLoginInfo(po);
    	return real.equals(pass);
    	
    }
	
	
    /**
	 * 登出	
	 * @param 登录输入信息VO
	 * @return 登出结果
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
	 * 注册	
	 * @param 登录输入信息VO
	 * @return 注册结果
	 */
	public String Register(LoginInVO vo)throws RemoteException{
		po=new LoginInPO(vo.getUsername(),vo.getPassword());
		return data.AddUser(po);
	}
}
