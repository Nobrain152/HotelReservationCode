package bl.userbl;

import blservice.userblservice.LoginInputBLService;
import vo.LoginInVO;

/**
 * 用户登录
 * @author 曹畅
 *
 */
public class LoginInputController implements LoginInputBLService {

	private User user=new User();
	
	
	/**
	 * 登录
	 * @param 登录输入信息VO
	 * @return 登录结果
	 */
    public boolean  LogIn(LoginInVO vo){
    	return user.LogIn(vo);
    }
	
	
    /**
	 * 登出	
	 * @param 登录输入信息VO
	 * @return 登出结果
	 */
	public boolean LogOut(boolean ok){
		return user.LogOut(ok);
	}
	
	
	/**
	 * 注册	
	 * @param 登录输入信息VO
	 * @return 注册结果
	 */
	public String Register(LoginInputVO vo){
		return user.Register(vo);
	}
}
