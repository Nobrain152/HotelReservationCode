package bl.userbl;

import java.rmi.RemoteException;

import dataservice.userdataservice.UserManagementDataService;
import po.LoginInPO;
import util.UserType;
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
	
	/**
	 * 得到用户类型
	 * @param userid
	 * @return
	 */
	public UserType getType(String userid)throws RemoteException{
		char charge=userid.charAt(0);
		switch(charge){
		case'1':return UserType.Customer;
		case'2':return UserType.HotelStuff;
		case'3':return UserType.WebStuff;
		case'4':return UserType.WebManager;
		default:return null;
		}
	}
}
