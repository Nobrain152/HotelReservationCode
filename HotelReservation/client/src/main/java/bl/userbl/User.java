package bl.userbl;

import data.userdata.UserManagementDataServiceImpl;
import po.LoginInPO;
import vo.LoginInVO;

public class User {
	
	private UserManagementDataServiceImpl data=new UserManagementDataServiceImpl();
	private LoginInPO po;
	
	
	/**
	 * ��¼
	 * @param ��¼������ϢVO
	 * @return ��¼���
	 */
    public boolean  LogIn(LoginInVO vo){
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
		po=new LoginInPO(vo.getUsername(),vo.getPassword());
		return data.AddUser(po);
	}
}
