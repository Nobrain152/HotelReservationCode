package bl.userbl;

import blservice.userblservice.LoginInputBLService;
import data.userdata.UserManagementDataServiceImpl;
import po.LoginInputPO;
import vo.LoginInputVO;


/**
 * �û���¼
 * @author �ܳ�
 *
 */
public class LoginInputController implements LoginInputBLService {

	UserManagementDataServiceImpl data=new UserManagementDataServiceImpl();
	LoginInputPO po;
	
	
	/**
	 * ��¼
	 * @param ��¼������ϢVO
	 * @return ��¼���
	 */
    public boolean  LogIn(LoginInputVO vo){
    	String pass=vo.getUserpassword();
    	po=new LoginInputPO(vo.getUserid(),vo.getUserpassword());
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
	public String Register(LoginInputVO vo){
		po=new LoginInputPO(vo.getUserid(),vo.getUserpassword());
		return data.AddUser(po);
	}
}
