package blservice.userblservice;

import vo.LoginInputVO;


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
    public boolean  LogIn(LoginInputVO vo);
		
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
	public String Register(LoginInputVO vo);
}