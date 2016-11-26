package bl.userbl;

import blservice.userblservice.LoginInputBLService;
import data.userdata.UserManagementDataServiceImpl;
import po.LoginInPO;
import vo.LoginInVO;


/**
 * �û���¼
 * @author �ܳ�
 *
 */
public class LoginInput implements LoginInputBLService {

	UserManagementDataServiceImpl data=new UserManagementDataServiceImpl();
	LoginInPO po;
	
	
	/**
	 * ��¼
	 * @param ��¼������ϢVO
	 * @return ��¼���
	 */
    public boolean  LogIn(LoginInVO vo){
    	String pass=vo.getUserpassword();
    	po=new LoginInPO(vo.getUserid(),vo.getUserpassword());
    	String real=data.GetLoginInfo(po);
    	return real.equals(pass);
    	
    }
	
	
    /**
	 * �ǳ�	
	 * @param ��¼������ϢVO
	 * @return �ǳ����
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
	 * ע��	
	 * @param ��¼������ϢVO
	 * @return ע����
	 */
	public String Register(LoginInVO vo){
		po=new LoginInPO(vo.getUserid(),vo.getUserpassword());
		return data.AddUser(po);
	}
}
