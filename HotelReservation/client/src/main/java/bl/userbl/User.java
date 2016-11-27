package bl.userbl;

import data.userdata.UserManagementDataServiceImpl;
import po.LoginInputPO;
import vo.LoginInputVO;

public class User {
	
	private UserManagementDataServiceImpl data=new UserManagementDataServiceImpl();
	private LoginInputPO po;
	
	
	/**
	 * 登录
	 * @param 登录输入信息VO
	 * @return 登录结果
	 */
    public boolean  LogIn(LoginInputVO vo){
    	String pass=vo.getUserpassword();
    	po=new LoginInputPO(vo.getUserid(),vo.getUserpassword());
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
	public String Register(LoginInputVO vo){
		po=new LoginInputPO(vo.getUserid(),vo.getUserpassword());
		return data.AddUser(po);
	}
}
