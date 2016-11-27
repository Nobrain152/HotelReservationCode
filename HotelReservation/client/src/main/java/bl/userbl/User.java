package bl.userbl;

import data.userdata.UserManagementDataServiceImpl;
import po.LoginInPO;
import vo.LoginInVO;

public class User {
	
	private UserManagementDataServiceImpl data=new UserManagementDataServiceImpl();
	private LoginInPO po;
	
	
	/**
	 * 登录
	 * @param 登录输入信息VO
	 * @return 登录结果
	 */
    public boolean  LogIn(LoginInVO vo){
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
	public boolean LogOut(boolean ok){
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
	public String Register(LoginInVO vo){
		po=new LoginInPO(vo.getUsername(),vo.getPassword());
		return data.AddUser(po);
	}
}
