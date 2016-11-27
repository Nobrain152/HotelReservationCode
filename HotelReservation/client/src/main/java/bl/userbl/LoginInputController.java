package bl.userbl;

import blservice.userblservice.LoginInputBLService;
import vo.LoginInVO;

/**
 * �û���¼
 * @author �ܳ�
 *
 */
public class LoginInputController implements LoginInputBLService {

	private User user=new User();
	
	
	/**
	 * ��¼
	 * @param ��¼������ϢVO
	 * @return ��¼���
	 */
    public boolean  LogIn(LoginInVO vo){
    	return user.LogIn(vo);
    }
	
	
    /**
	 * �ǳ�	
	 * @param ��¼������ϢVO
	 * @return �ǳ����
	 */
	public boolean LogOut(boolean ok){
		return user.LogOut(ok);
	}
	
	
	/**
	 * ע��	
	 * @param ��¼������ϢVO
	 * @return ע����
	 */
	public String Register(LoginInputVO vo){
		return user.Register(vo);
	}
}
