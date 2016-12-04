package blservice.userblservice;

import util.UserType;
import vo.LoginInVO;


/**
 * 用户登录
 * @author 曹畅
 *
 */
public interface LoginInputBLService{
        
	
	/**
	 * 登录
	 * @param 登录输入信息VO
	 * @return 登录结果
	 */
    public boolean  LogIn(LoginInVO vo);
		
	/**
	 * 登出	
	 * @param 登录输入信息VO
	 * @return 登出结果
	 */
	public boolean LogOut(boolean ok);
		
	/**
	 * 注册	
	 * @param 登录输入信息VO
	 * @return 注册结果
	 */
	public String Register(LoginInVO vo);
	
	/**
	 * 得到用户类型
	 * @param userid
	 * @return
	 */
	public UserType getType(String userid);
}