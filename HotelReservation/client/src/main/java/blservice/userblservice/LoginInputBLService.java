package blservice.userblservice;

import vo.LoginInVO;


/**
 * �û���¼
 * @author �ܳ�
 *
 */
public interface LoginInputBLService{
        
	
	/**
	 * ��¼
	 * @param ��¼������ϢVO
	 * @return ��¼���
	 */
    public boolean  LogIn(LoginInVO vo);
		
	/**
	 * �ǳ�	
	 * @param ��¼������ϢVO
	 * @return �ǳ����
	 */
	public boolean LogOut(boolean ok);
		
	/**
	 * ע��	
	 * @param ��¼������ϢVO
	 * @return ע����
	 */
	public String Register(LoginInVO vo);
}