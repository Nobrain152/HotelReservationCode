package blservice.userblservice;

import vo.LoginInputVO;


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
    public boolean  LogIn(LoginInputVO vo);
		
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
	public String Register(LoginInputVO vo);
}